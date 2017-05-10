/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
INSERT INTO category (name, description, unit, available, create_user_id, create_time, update_time)
VALUES ('方木', '方形木棍', '根', TRUE, 1, '2017-02-20 12:00:00', '2017-02-20 12:00:00');
INSERT INTO category (name, description, unit, available, create_user_id, create_time, update_time)
VALUES ('圆木', '圆柱木棍', '根', TRUE, 1, '2017-02-20 12:00:00', '2017-02-20 12:00:00');
INSERT INTO category (name, description, unit, available, create_user_id, create_time, update_time)
VALUES ('木板', '板子', '张', TRUE, 1, '2017-02-20 12:00:00', '2017-02-20 12:00:00');
INSERT INTO category (name, description, unit, available, create_user_id, create_time, update_time)
VALUES ('钢管', '钢管', '根', FALSE, 1, '2017-02-20 12:00:00', '2017-02-20 12:00:00');


/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time)
VALUES ('方木2m', 18.50, 20, '根', '方木', 0, 1, '2017-03-01 12:00:00', '2017-03-01 12:00:00');
INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time)
VALUES ('方木3m', 22, 24, '根', '方木', 0, 1, '2017-03-01 12:00:00', '2017-03-01 13:01:00');
INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time)
VALUES ('方木4m', 24, 26, '根', '方木', 0, 1, '2017-03-02 13:00:00', '2017-03-03 14:00:00');

INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time)
VALUES ('圆木3m', 12, 14, '根', '圆木', 0, 1, '2017-03-01 12:00:00', '2017-03-01 12:00:00');
INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time)
VALUES ('圆木4m', 18, 21, '根', '圆木', 0, 1, '2017-03-01 12:00:00', '2017-03-01 12:00:00');

INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time)
VALUES ('木板1*1.5', 50, 62, '张', '木板', 0, 1, '2017-03-01 12:00:00', '2017-03-01 12:00:00');
INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time)
VALUES ('木板1*2', 60, 70, '张', '木板', 0, 1, '2017-03-01 12:00:00', '2017-03-01 12:00:00');
INSERT INTO commodity (name, cost, price, unit, category, inventory, create_user_id, create_time, update_time)
VALUES ('木板1.2*2.44', 100, 120, '张', '木板', 0, 1, '2017-03-01 12:00:00', '2017-03-01 12:00:00');

