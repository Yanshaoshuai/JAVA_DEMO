CREATE TABLE `role_user` (
                             `rid` bigint NOT NULL COMMENT '角色id',
                             `uid` bigint NOT NULL COMMENT '用户id',
                             PRIMARY KEY (`rid`,`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `shiro`.`role`(`id`, `name`, `description`) VALUES (1, 'admin', '管理员');
INSERT INTO `shiro`.`role`(`id`, `name`, `description`) VALUES (2, 'user', '普通用户');
