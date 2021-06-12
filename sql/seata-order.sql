CREATE TABLE t_order
(
    `id`         BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`    BIGINT(11) DEFAULT NULL COMMENT '用户id',
    `product_id` BIGINT(11) DEFAULT NULL COMMENT '产品id',
    `count`      INT(11) DEFAULT NULL COMMENT '数量',
    `money`      DECIMAL(11, 0) DEFAULT NULL COMMAND_FUNCTION '订单金额',
    `status`     SMALLINT(5) DEFAULT NULL COMMENT '订单状态：0：创建中；1：已完结'
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb4;

