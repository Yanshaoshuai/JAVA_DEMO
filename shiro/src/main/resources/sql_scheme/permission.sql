CREATE TABLE `permission` (
                              `id` bigint NOT NULL,
                              `name` varchar(30) DEFAULT NULL COMMENT '权限名',
                              `info` varchar(30) DEFAULT NULL COMMENT '权限信息',
                              `desc` varchar(50) DEFAULT NULL COMMENT '描述',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `shiro`.`permission`(`id`, `name`, `info`, `desc`) VALUES (1, 'addUser', 'user:add', '添加用户');
INSERT INTO `shiro`.`permission`(`id`, `name`, `info`, `desc`) VALUES (2, 'editUser', 'user:edit', '修改用户');
INSERT INTO `shiro`.`permission`(`id`, `name`, `info`, `desc`) VALUES (3, 'deleteUser', 'user:delete', '删除用户');
INSERT INTO `shiro`.`permission`(`id`, `name`, `info`, `desc`) VALUES (4, 'getUser', 'user:get', '查看用户');
