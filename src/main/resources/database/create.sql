/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/24 8:58:47                            */
/*==============================================================*/

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
  cost           DOUBLE
  COMMENT '成本',
  price          DOUBLE
  COMMENT '定价',
  unit           VARCHAR(32) COMMENT '单位',
  category       VARCHAR(32),
  inventory      INT
  COMMENT '库存',
  create_user_id INT,
  create_time    DATETIME,
  update_time    DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '商品表';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
DROP TABLE IF EXISTS role;

CREATE TABLE role
(
  id          INT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(32),
  description VARCHAR(255),
  addable     TINYINT COMMENT '是否允许增加此角色用户',
  PRIMARY KEY (id)
)
  COMMENT '角色表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
  id              INT NOT NULL AUTO_INCREMENT,
  name            VARCHAR(32),
  password_digest VARCHAR(255) COMMENT '密码密文',
  phone           VARCHAR(32),
  role            INT,
  status          TINYINT,
  create_user_id  INT,
  create_time     DATETIME,
  update_time     DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '用户表';


/*==============================================================*/
/* Table: consumer                                              */
/*==============================================================*/
DROP TABLE IF EXISTS consumer;

CREATE TABLE consumer
(
  id             INT NOT NULL AUTO_INCREMENT,
  name           VARCHAR(32),
  phone          VARCHAR(32),
  address        VARCHAR(32),
  credit         DOUBLE,
  create_user_id INT,
  create_time    DATETIME,
  update_time    DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '客户表';

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
  id             INT NOT NULL AUTO_INCREMENT,
  consumer_id    INT,
  consumer_name  VARCHAR(32),
  commodities    VARCHAR(10240) COMMENT '该订单包含的商品信息json',
  total          DOUBLE,
  credit         DOUBLE,
  payments       VARCHAR(10240) COMMENT '该订单的付款记录',
  status         INT,
  create_user_id INT,
  create_time    DATETIME,
  update_time    DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '订单表';

/*==============================================================*/
/* Table: inventory_record                                      */
/*==============================================================*/
DROP TABLE IF EXISTS inventory_record;

CREATE TABLE inventory_record
(
  id             INT NOT NULL AUTO_INCREMENT,
  commodity_id   INT,
  old_inventory  INT,
  addition       INT,
  amount         DOUBLE,
  cost           DOUBLE,
  new_inventory  INT,
  create_user_id INT,
  create_time    DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '库存变更记录表';


/*==============================================================*/
/* Table: payment_record                                        */
/*==============================================================*/
DROP TABLE IF EXISTS payment_record;

CREATE TABLE payment_record
(
  id             INT NOT NULL AUTO_INCREMENT,
  consumer_id    INT,
  type           INT,
  money          DOUBLE,
  ref_orders     VARCHAR(10240),
  create_user_id INT,
  create_time    DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '客户付款记录表';

/*==============================================================*/
/* Table: asset_record                                          */
/*==============================================================*/
DROP TABLE IF EXISTS asset_record;

CREATE TABLE asset_record
(
  id          INT NOT NULL AUTO_INCREMENT,
  type        TINYINT,
  old_asset   DOUBLE,
  variation   DOUBLE,
  new_asset   DOUBLE,
  create_time DATETIME,
  PRIMARY KEY (id)
)
  COMMENT '资产记录表';


/*==============================================================*/
/* Table: date_statistics                                       */
/*==============================================================*/
DROP TABLE IF EXISTS date_statistics;
CREATE TABLE date_statistics
(
  date         DATE,
  order_num    INT,
  turnover     DOUBLE,
  credit_num   INT,
  total_credit DOUBLE
)
  COMMENT '按日期统计记录表';

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
