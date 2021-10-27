

DROP TABLE IF EXISTS `spring_cloud_config`;

CREATE TABLE `spring_cloud_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `akey` varchar(30) DEFAULT NULL,
  `avalue` varchar(128) DEFAULT NULL,
  `application` varchar(30) DEFAULT NULL,
  `aprofile` varchar(30) DEFAULT NULL,
  `label` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `spring_cloud_config` (`id`, `akey`, `avalue`, `application`, `aprofile`, `label`)
VALUES
	(2,'name_server','127.0.0.1:9876','product-service','dev','dev'),
	(3,'name_server','127.0.0.1:9876','order-service','dev','dev'),
	(4,'order_topic','order_topic','order-service','dev','dev'),
	(5,'order_topic','order_topic','product-service','dev','dev');






