CREATE TABLE `pub_config` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `key` varchar(200) NOT NULL COMMENT '根据key取值',
  `value` varchar(200) DEFAULT '' COMMENT '配置的值',
  `remark` varchar(50) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unKey_configKey` (`key`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8