CREATE TABLE `user`
(
    `id`   bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(30) DEFAULT NULL COMMENT '用户名',
    `pwd`  varchar(50) DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- zhangsan 123456 /lisi 123
INSERT INTO `shiro`.`user`(`id`, `name`, `pwd`) VALUES (2, 'zhangsan', 'd1b129656359e35e95ebd56a63d7b9e0');
INSERT INTO `shiro`.`user`(`id`, `name`, `pwd`) VALUES (3, 'lisi', '07ca00e10899418f0ea4ab92a9d69065');
