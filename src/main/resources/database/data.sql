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

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
INSERT INTO role (name, description, addable) VALUES ('经理', '系统管理员角色', FALSE);
INSERT INTO role (name, description, addable) VALUES ('采购', '负责采购', TRUE);
INSERT INTO role (name, description, addable) VALUES ('销售', '负责订单商品管理', TRUE);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
INSERT INTO user (name, password_digest, phone, role, status, create_user_id, create_time, update_time)
VALUES
  ('经理', '098f6bcd4621d373cade4e832627b4f6', '13121708225', 1, TRUE, 0, '2017-03-10 12:00:00',
   '2017-03-21 14:00:00');
INSERT INTO user (name, password_digest, phone, role, status, create_user_id, create_time, update_time)
VALUES
  ('采购1', '098f6bcd4621d373cade4e832627b4f6', '13121708226', 2, TRUE, 0, '2017-03-10 12:00:00',
   '2017-03-21 14:00:00');
INSERT INTO user (name, password_digest, phone, role, status, create_user_id, create_time, update_time)
VALUES
  ('销售1', '098f6bcd4621d373cade4e832627b4f6', '13121708227', 3, TRUE, 0, '2017-03-10 12:00:00',
   '2017-03-21 14:00:00');
INSERT INTO user (name, password_digest, phone, role, status, create_user_id, create_time, update_time)
VALUES
  ('销售2', '098f6bcd4621d373cade4e832627b4f6', '13121708229', 3, FALSE, 0, '2017-03-10 12:00:00',
   '2017-03-22 15:00:00');

/*==============================================================*/
/* Table: consumer                                              */
/*==============================================================*/

INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('李秀英', '15153822830', '凤阳县', 0, 1, '2017-03-10 12:00:00',
        '2017-03-11 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('李杰', '15153808225', '江山市', 0, 1, '2017-03-10 14:00:00',
        '2017-03-10 18:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('刘晨', '13865832873', '常山县', 0, 1, '2017-03-11 12:00:00',
        '2017-03-12 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('张东海', '13183962028', '嵊泗县', 0, 1, '2017-03-05 12:00:00',
        '2017-03-08 15:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('王安', '13903172157', '台州市', 0, 1, '2017-03-18 12:00:00',
        '2017-03-20 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('王海', '15153822833', '龙游县', 0, 1, '2017-03-16 12:00:00',
        '2017-03-21 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('曹昆', '18303517744', '灵璧县', 0, 1, '2017-04-06 12:00:00',
        '2017-04-12 06:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('何羽衣', '15219466201', '无为县', 0, 1, '2017-04-10 12:00:00',
        '2017-04-16 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('高淑贤', '15219466204', '庐江县', 0, 1, '2017-04-10 12:00:00',
        '2017-04-21 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('李刚', '18876941131', '萧县', 0, 1, '2017-02-09 12:00:00',
        '2017-03-20 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('徐婷婷', '18876941139', '沂水县', 0, 1, '2017-03-20 12:00:00',
        '2017-04-28 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('朱小玲', '18352936688', '苍山县', 0, 1, '2017-03-10 12:00:00',
        '2017-05-01 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('黄登高', '18352939688', '沂南县', 0, 1, '2017-02-10 13:00:00',
        '2017-03-20 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('马杰', '15777770130', '费县', 0, 1, '2017-03-18 12:00:00',
        '2017-05-02 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('汪佳丽', '13632577333', '孝昌县', 0, 1, '2017-04-10 12:00:00',
        '2017-04-20 19:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('李旺', '15777770138', '大悟县', 0, 1, '2017-05-10 12:00:00',
        '2017-05-12 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('范佳慧', '13153802835', '云梦县', 0, 1, '2017-05-10 12:00:00',
        '2017-04-22 14:00:00');
INSERT INTO consumer (name, phone, address, credit, create_user_id, create_time, update_time)
VALUES ('刘永杰', '13632577363', '开县', 0, 1, '2017-04-10 12:00:00',
        '2017-04-21 14:00:00');


/*==============================================================*/
/* some useful sql                                              */
/*==============================================================*/
SELECT *
FROM consumer
WHERE name LIKE #{name} AND phone LIKE #{phone} AND address LIKE #{address}
ORDER BY update_time DESC
LIMIT #{offset}, #{pageSize}