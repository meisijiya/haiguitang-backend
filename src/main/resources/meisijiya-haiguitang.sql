-- 用户表：存储系统用户的基本信息
CREATE TABLE IF NOT EXISTS `user`
(
    `id`          VARCHAR(255) NOT NULL,
    `name`        VARCHAR(255) NOT NULL,
    `password`    VARCHAR(255) NOT NULL,
    `type`        VARCHAR(255) DEFAULT NULL,
    `avatar`      TEXT         DEFAULT NULL,
    `email`       VARCHAR(255) DEFAULT NULL,
    `badge`       TEXT         DEFAULT NULL,
    `login_time`  timestamp(3) DEFAULT NULL,
    `create_time` timestamp(3) NOT NULL,
    `update_time` timestamp(3) NOT NULL,
    PRIMARY KEY (`id`)
    );

-- 群组表：存储群组的基本信息
CREATE TABLE IF NOT EXISTS `group`
(
    `id`          VARCHAR(255) NOT NULL,
    `name`        VARCHAR(255) NOT NULL,
    `avatar`      TEXT DEFAULT NULL,
    `create_time` timestamp(3) NOT NULL,
    `update_time` timestamp(3) NOT NULL,
    PRIMARY KEY (`id`)
    );

-- 聊天列表表：存储用户的聊天会话信息
CREATE TABLE IF NOT EXISTS `chat_list`
(
    `id`           VARCHAR(255) NOT NULL,
    `user_id`      VARCHAR(255) NOT NULL,
    `target_id`    VARCHAR(255) NOT NULL,
    `target_info`  TEXT         NOT NULL,
    `unread_count` INT          DEFAULT 0,
    `last_message` TEXT         DEFAULT NULL,
    `type`         VARCHAR(255) DEFAULT NULL,
    `create_time`  timestamp(3) NOT NULL,
    `update_time`  timestamp(3) NOT NULL,
    PRIMARY KEY (`id`)
    );

-- 消息表：存储用户之间的消息记录
CREATE TABLE IF NOT EXISTS `message`
(
    `id`            VARCHAR(255) NOT NULL,
    `from_id`       VARCHAR(255) NOT NULL,
    `to_id`         VARCHAR(255) NOT NULL,
    `from_info`     TEXT         NOT NULL,
    `message`       TEXT         DEFAULT NULL,
    `reference_msg` TEXT         DEFAULT NULL,
    `at_user`       TEXT         DEFAULT NULL,
    `is_show_time`  TINYINT(1) DEFAULT 0,
    `type`          VARCHAR(255) DEFAULT NULL,
    `source`        VARCHAR(255) DEFAULT NULL,
    `create_time`   timestamp(3) NOT NULL,
    `update_time`   timestamp(3) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX           `idx_message_from_id_to_id` (`from_id`, `to_id`)
    );

-- 通知表：存储系统通知信息
CREATE TABLE IF NOT EXISTS `notify`
(
    `id`             VARCHAR(255) NOT NULL,
    `notify_title`   VARCHAR(255) DEFAULT NULL,
    `notify_content` TEXT         DEFAULT NULL,
    `type`           VARCHAR(255) DEFAULT NULL,
    `create_time`    timestamp(3) NOT NULL,
    `update_time`    timestamp(3) NOT NULL,
    PRIMARY KEY (`id`)
    );

-- 海归汤历史记录表：存储海归汤功能的历史记录
CREATE TABLE IF NOT EXISTS `haiguitang_history`
(
    `id`          VARCHAR(255) NOT NULL,
    `user_id`     VARCHAR(255) NOT NULL,
    `create_time` timestamp(3) NOT NULL,
    `update_time` timestamp(3) NOT NULL,
    PRIMARY KEY (`id`)
    );

-- 海归汤历史详情表：存储海归汤完整对话的详细信息
CREATE TABLE IF NOT EXISTS `haiguitang_history_detail`
(
    `id`            VARCHAR(255) NOT NULL,
    `haiguitang_id` VARCHAR(255) NOT NULL,
    `ai_chat`     TEXT         DEFAULT NULL,
    `human_chat`     TEXT         DEFAULT NULL,
    `user_id`       VARCHAR(255) NOT NULL,
    `create_time`   timestamp(3) NOT NULL,
    `update_time`   timestamp(3) NOT NULL,
    PRIMARY KEY (`id`)
    );

-- 海归汤统计表：存储海归汤游戏统计信息
CREATE TABLE IF NOT EXISTS `haiguitang_static`
(
    `id`          VARCHAR(255) NOT NULL,
    `user_id`     VARCHAR(255) NOT NULL,
    `total_haiguitang`  INT          DEFAULT 0,
    `total_win`   INT          DEFAULT 0,
    `last_haiguitang_playtime`   INT          DEFAULT 0,
    `create_time` timestamp(3) NOT NULL,
    `update_time` timestamp(3) NOT NULL,
    PRIMARY KEY (`id`)
    );

-- 我的背景表：存储用户的个人背景链接
CREATE TABLE IF NOT EXISTS `my_background`
(
    `id`          VARCHAR(255) NOT NULL,
    `user_id`     VARCHAR(255) NOT NULL,
    `background`  TEXT         DEFAULT NULL,
    `create_time` timestamp(3) NOT NULL,
    `update_time` timestamp(3) NOT NULL,
    PRIMARY KEY (`id`)
    );
