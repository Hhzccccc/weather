CREATE TABLE `user_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `ip` varchar(128) NOT NULL DEFAULT '' COMMENT '访问的IP',
  `imei` varchar(255) NOT NULL DEFAULT '' COMMENT '访问设备号',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户Id',
  `visit_time` datetime DEFAULT NULL COMMENT '访问时间',
  `visit_date` date DEFAULT NULL COMMENT '访问的日期',
  `use_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '访问接口耗时',
  `request_url` varchar(255) NOT NULL DEFAULT '' COMMENT '请求的url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
