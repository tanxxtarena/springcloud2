CREATE TABLE `sys_gateway_route` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `service_id` varchar(255) DEFAULT NULL,
  `uri` varchar(255) DEFAULT NULL,
  `predicates` varchar(255) DEFAULT NULL,
  `filters` int(5) DEFAULT NULL,
  `order` int(5) DEFAULT NULL,
  `creator_id` int(10) DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_id` varchar(255) DEFAULT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

INSERT INTO `db2020`.`sys_gateway_route` (`id`, `service_id`, `uri`, `predicates`, `filters`, `order`, `creator_id`, `create_date`, `update_id`, `update_date`, `remarks`, `del_flag`) VALUES ('1', 'payment-service', 'CLOUD-PAYMENT-SERVICE', '/payment/**', '1', '0', '1', '2020-03-16 12:04:32', '1', '2020-03-16 12:04:32', '支付服务', '0');

/**
服务测试地址： http://localhost:9527/payment/payment/get/1
查看路由配置信息: http://localhost:9527/actuator/gateway/routes
手动刷新路由配置信息：http://localhost:9527/route/refresh
*/
