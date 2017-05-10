/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/24 8:58:47                            */
/*==============================================================*/


DROP TABLE IF EXISTS asset_record;


DROP TABLE IF EXISTS consumer;

DROP TABLE IF EXISTS date_statistics;

DROP TABLE IF EXISTS inventory_record;

DROP TABLE IF EXISTS "order";

DROP TABLE IF EXISTS payment_record;

DROP TABLE IF EXISTS role;

DROP TABLE IF EXISTS user;

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
DROP TABLE IF EXISTS category;
CREATE TABLE category
(
  id             INT         NOT NULL AUTO_INCREMENT,
  name           VARCHAR(32) NOT NULL,
  description    VARCHAR(255),
  unit           VARCHAR(32) NOT NULL,
  available      TINYINT              DEFAULT 1
  COMMENT '1代表可用，0代表不可用',
  create_user_id INT,
  create_time    DATETIME,
  update_time    DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '商品类别表';


/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
DROP TABLE IF EXISTS commodity;

CREATE TABLE commodity
(
  id             INT         NOT NULL AUTO_INCREMENT,
  name           VARCHAR(32) NOT NULL,
  cost           DOUBLE               DEFAULT 0
  COMMENT '成本',
  price          DOUBLE               DEFAULT 0
  COMMENT '定价',
  unit           VARCHAR(32) COMMENT '单位',
  category       VARCHAR(32),
  inventory      INT                  DEFAULT 0
  COMMENT '库存',
  create_user_id INT         NOT NULL,
  create_time    DATETIME,
  update_time    DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '商品表';


/*==============================================================*/
/* Table: asset_record                                          */
/*==============================================================*/
CREATE TABLE asset_record
(
  id          INT NOT NULL,
  type        VARCHAR(32),
  old_asset   DOUBLE,
  variation   DOUBLE,
  new_asset   DOUBLE,
  create_time DATETIME,
  PRIMARY KEY (id)
);

ALTER TABLE asset_record
  COMMENT '资产记录表';


/*==============================================================*/
/* Table: consumer                                              */
/*==============================================================*/
CREATE TABLE consumer
(
  id             INT NOT NULL,
  name           VARBINARY(32),
  phone          VARBINARY(32),
  address        VARBINARY(32),
  credit         DOUBLE,
  create_user_id INT,
  create_time    DATETIME,
  update_time    DATETIME,
  PRIMARY KEY (id)
);

ALTER TABLE consumer
  COMMENT '客户表';

/*==============================================================*/
/* Table: date_statistics                                       */
/*==============================================================*/
CREATE TABLE date_statistics
(
  date         DATE,
  order_num    INT,
  tuenover     DOUBLE,
  credit_num   INT,
  total_credit DOUBLE
);

ALTER TABLE date_statistics
  COMMENT '按日期统计记录表';

/*==============================================================*/
/* Table: inventory_record                                      */
/*==============================================================*/
CREATE TABLE inventory_record
(
  id             INT NOT NULL,
  commodity_id   INT,
  type           VARCHAR(32),
  old_inventory  INT,
  variation      INT,
  amount         DOUBLE,
  cost           DOUBLE,
  new_inventory  DOUBLE,
  create_user_id INT,
  create_time    DATETIME,
  PRIMARY KEY (id)
);

ALTER TABLE inventory_record
  COMMENT '库存变更记录表';

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
CREATE TABLE "order"
(
  id             INT NOT NULL,
  consumer_id    INT,
  consumer_name  VARCHAR(32),
  commodities    VARCHAR(65535),
  total          DOUBLE,
  credit         DOUBLE,
  payments       VARCHAR(65535),
  status         VARCHAR(32),
  create_user_id INT,
  create_time    DATETIME,
  update_time    DATETIME,
  PRIMARY KEY (id)
);

ALTER TABLE "order"
  COMMENT '订单表';

/*==============================================================*/
/* Table: payment_record                                        */
/*==============================================================*/
CREATE TABLE payment_record
(
  id             INT NOT NULL,
  consumer_id    INT,
  type           VARCHAR(32),
  money          DOUBLE,
  ref_orders     VARCHAR(65535),
  create_user_id INT,
  create_time    DATETIME,
  PRIMARY KEY (id)
);

ALTER TABLE payment_record
  COMMENT '客户付款记录表';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
CREATE TABLE role
(
  id          INT,
  name        VARCHAR(32),
  description VARCHAR(255),
  usable      TINYINT
);

ALTER TABLE role
  COMMENT '角色表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
CREATE TABLE user
(
  id              INT NOT NULL,
  name            VARCHAR(32),
  password_digest VARCHAR(255),
  phone           VARCHAR(32),
  role            VARCHAR(32),
  status          VARCHAR(32),
  create_time     DATETIME,
  update_time     DATETIME,
  PRIMARY KEY (id)
);

ALTER TABLE user
  COMMENT '用户表';

ALTER TABLE inventory_record
  ADD CONSTRAINT FK_inventory_ref FOREIGN KEY (commodity_id)
REFERENCES commodity (id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE "order"
  ADD CONSTRAINT FK_order_consumer FOREIGN KEY (consumer_id)
REFERENCES consumer (id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE payment_record
  ADD CONSTRAINT FK_payment FOREIGN KEY (consumer_id)
REFERENCES consumer (id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

