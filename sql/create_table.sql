create database if not exists tb_furn;

use tb_furn;

CREATE TABLE tb_furn
(
    `id`          INT(11) PRIMARY KEY AUTO_INCREMENT comment 'id',
    `name`        VARCHAR(64)                        NOT NULL comment '家居名',
    `maker`       VARCHAR(64)                        NOT NULL comment '厂商',
    `price`       DECIMAL(11, 2)                     NOT NULL comment '价格',
    `sales`       INT(11)                            NOT NULL comment '销量',
    `stock`       INT(11)                            NOT NULL comment '库存',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_delete`   tinyint  default 0                 not null comment '是否删除 0 - 否， 1 - 是'
);

# 初始数据
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '北欧风格小桌子', '熊猫家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约风格小椅子', '熊猫家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '典雅风格小台灯', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约沙发 1', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '温馨风格盆景架', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约沙发 2', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约沙发 3', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约沙发 4', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约沙发 5', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约沙发 6', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约沙发 7', '蚂蚁家居', 180, 666, 7);
INSERT INTO tb_furn(`id`, `name`, `maker`, `price`, `sales`, `stock`)
VALUES (NULL, '简约沙发 8', '蚂蚁家居', 180, 666, 7);