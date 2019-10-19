CREATE DATABASE  IF NOT EXISTS `m2csea-metrics`;
USE `m2csea-metrics`;

DROP TABLE IF EXISTS `criticality_factor`;
CREATE TABLE `criticality_factor` (
  `microservice` varchar(100) NOT NULL,
  `factor` int(11) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `vision` varchar(45) DEFAULT NULL,
  `dt_transaction` datetime DEFAULT NULL
);

INSERT INTO `criticality_factor` VALUES ('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:31:15'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:31:25'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:31:35'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:31:46'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:31:55'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:32:05'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:32:15'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:32:25'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:32:35'),('product',1,'CPU: 1 | RAM: 1','computational-resource-usage','2019-10-14 12:32:45'),('microservice-banner-rest',5,'5.5','response-time','2019-10-14 12:33:07'),('microservice-banner-rest',1,'1','availability','2019-10-14 12:33:15'),('microservice-banner-rest',1,'1','availability','2019-10-14 12:33:25'),('microservice-banner-rest',5,'0','availability','2019-10-15 20:20:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-15 20:20:46'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 09:40:01'),('mysql',5,'CPU: 5 | RAM: 1','computational-resource-usage','2019-10-19 09:40:06'),('mysql',5,'CPU: 5 | RAM: 1','computational-resource-usage','2019-10-19 09:40:16'),('mysql',5,'CPU: 5 | RAM: 1','computational-resource-usage','2019-10-19 09:40:26'),('mysql',5,'CPU: 5 | RAM: 1','computational-resource-usage','2019-10-19 09:40:36'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 09:41:06'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:41:12'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:41:22'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:41:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:41:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:41:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:41:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:42:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:42:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:42:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:42:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:42:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:42:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:43:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:43:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:43:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:43:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:43:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:43:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:44:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:44:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:44:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:44:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:44:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:44:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:45:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:45:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:45:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:45:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:45:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:45:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:46:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:46:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:46:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:46:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:46:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:46:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:47:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:47:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:47:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:47:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:47:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:47:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:48:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:48:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:48:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:48:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:48:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:48:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:49:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:49:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:49:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:49:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:49:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:49:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:50:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:50:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:50:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:50:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:50:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:50:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:51:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:51:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:51:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:51:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:51:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:51:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:52:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:52:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:52:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:52:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:52:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:52:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:53:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:53:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:53:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:53:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:53:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:53:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:54:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:54:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:54:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:54:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:54:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:54:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:55:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:55:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:55:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:55:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:55:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:55:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:56:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:56:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:56:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:56:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:56:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:56:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:57:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:57:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:57:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:57:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:57:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:57:57'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:58:07'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:58:17'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:58:27'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:58:37'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:58:47'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:58:51'),('microservice-banner-rest',5,'5.5','response-time','2019-10-19 09:59:01'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:06:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:07:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:07:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:08:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:08:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:09:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:09:33'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:10:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:10:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:11:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:11:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:12:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:12:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:13:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:13:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:14:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:14:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:15:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:15:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:16:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:16:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:17:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:17:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:18:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:18:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:19:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:19:33'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:20:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:20:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:21:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:21:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:22:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:22:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:23:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:23:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:24:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:24:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:25:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:25:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:26:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:26:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:27:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:27:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:28:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:28:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:29:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:29:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:30:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:30:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:31:02'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:33:03'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 10:33:32'),('microservice-product-rest',4,'540.0','tech-debit','2019-10-19 11:30:45');

DROP TABLE IF EXISTS `response_time`;
CREATE TABLE `response_time` (
  `microservice` varchar(100) DEFAULT NULL,
  `response_time` bigint(50) DEFAULT NULL,
  `dt_transaction` datetime DEFAULT NULL,
  KEY `microservice_name` (`microservice`)
);

INSERT INTO `response_time` VALUES ('microservice-user-manager-rest',0,NULL),('microservice-user-manager-rest',1,NULL),('microservice-user-manager-rest',1,NULL),('microservice-banner-rest',5,NULL),('microservice-banner-rest',6,NULL),('microservice-user-manager-rest',0,'2019-10-09 00:00:00'),('microservice-user-manager-rest',1,'2019-10-09 20:31:54'),('microservice-user-manager-rest',3,'2019-10-09 20:32:00'),('microservice-user-manager-rest',0,'2019-10-09 20:32:01');

DROP TABLE IF EXISTS `transaction_status`;
CREATE TABLE `transaction_status` (
  `microservice` varchar(100) NOT NULL,
  `http_status` int(11) DEFAULT NULL,
  `dt_transaction` datetime DEFAULT NULL
);