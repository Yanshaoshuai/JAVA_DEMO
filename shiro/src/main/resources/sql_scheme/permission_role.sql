CREATE TABLE `permission_role` (
                                   `pid` int NOT NULL COMMENT '权限id',
                                   `rid` int NOT NULL COMMENT '角色id',
                                   PRIMARY KEY (`pid`,`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `shiro`.`permission_role`(`pid`, `rid`) VALUES (1, 1);
INSERT INTO `shiro`.`permission_role`(`pid`, `rid`) VALUES (2, 1);
INSERT INTO `shiro`.`permission_role`(`pid`, `rid`) VALUES (3, 1);
INSERT INTO `shiro`.`permission_role`(`pid`, `rid`) VALUES (4, 2);
