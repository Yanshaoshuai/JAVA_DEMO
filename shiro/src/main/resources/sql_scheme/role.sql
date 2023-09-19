CREATE TABLE `role` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名',
                        `description` varchar(255) DEFAULT NULL COMMENT '描述',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `shiro`.`role`(`id`, `name`, `description`) VALUES (1, 'admin', '管理员');
INSERT INTO `shiro`.`role`(`id`, `name`, `description`) VALUES (2, 'user', '普通用户');
