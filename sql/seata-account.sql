CREATE TABLE seata_account.`t_account`
(
    `id`         BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`    BIGINT(11)     DEFAULT NULL COMMENT '用户id',
    `total`      DECIMAL(10, 0) DEFAULT NULL COMMENT '总额度',
    `used`       DECIMAL(10, 0) DEFAULT '0' COMMENT '已用额度',
    `residue`    DECIMAL(10, 0) DEFAULT NULL COMMENT '剩余额度'
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4;

INSERT INTO seata_account.`t_account`(`id`, `user_id`, `total`, `used`, `residue`)
VALUES (1, 1, 1000, 0, 1000);

SELECT *
FROM seata_account.`t_account`;