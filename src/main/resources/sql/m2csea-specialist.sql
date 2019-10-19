CREATE DATABASE  IF NOT EXISTS `m2csea-specialist`;
USE `m2csea-specialist`;

DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `login_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `password_hash` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
);

DROP TABLE IF EXISTS `user_visions`;
CREATE TABLE `user_visions` (
  `user_id` int(11) NOT NULL,
  `vision_comparison_id` int(11) NOT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`user_id`,`vision_comparison_id`)
);

INSERT INTO `user_visions` VALUES (1,1,3),(1,2,0.166),(1,3,2),(1,4,0.333),(1,5,0.166),(1,6,0.5),(1,7,0.25),(1,8,2),(1,9,0.166),(1,10,2),(1,11,0.166),(1,12,0.142),(1,13,0.125),(1,14,1),(1,15,0.142);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `dt_register` datetime DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `job_title` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `users` VALUES (1,'Exemplo_Analista','01_E01','2019-08-27 17:55:23','Empresa_01','Analista de Sistemas'),(2,'Exemplo_Analista','02_E01','2019-08-27 17:55:23','Empresa_01','Analista de Sistemas'),(3,'Exemplo_Arquiteto','01_E01','2019-08-27 17:55:23','Empresa_01','Arquiteto de Software'),(4,'Exemplo_Arquiteto','02_E01','2019-08-27 17:55:23','Empresa_01','Arquiteto de Software'),(5,'Exemplo_Gerente','01_E01','2019-08-27 17:55:23','Empresa_01','Gerente de Projeto'),(6,'Exemplo_Gerente','02_E01','2019-08-27 17:55:23','Empresa_01','Gerente de Projeto'),(7,'Exemplo_Analista','01_E02','2019-08-27 17:55:23','Empresa_02','Analista de Sistemas'),(8,'Exemplo_Analista','02_E02','2019-08-27 17:55:23','Empresa_02','Analista de Sistemas'),(9,'Exemplo_Arquiteto','01_E02','2019-08-27 17:55:23','Empresa_02','Arquiteto de Software'),(10,'Exemplo_Arquiteto','02_E02','2019-08-27 17:55:23','Empresa_02','Arquiteto de Software'),(11,'Exemplo_Gerente','01_E02','2019-08-27 17:55:23','Empresa_02','Gerente de Projeto'),(12,'Exemplo_Gerente','02_E02','2019-08-27 17:55:23','Empresa_02','Gerente de Projeto');

DROP TABLE IF EXISTS `vision_comparison`;
CREATE TABLE `vision_comparison` (
  `id` int(11) NOT NULL,
  `main_vision` int(11) DEFAULT NULL,
  `compared_vision` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `vision_comparison` VALUES (1,1,2),(2,1,3),(3,1,4),(4,1,5),(5,1,6),(6,2,3),(7,2,4),(8,2,5),(9,2,6),(10,3,4),(11,3,5),(12,3,6),(13,4,5),(14,4,6),(15,5,6);

DROP TABLE IF EXISTS `visions`;
CREATE TABLE `visions` (
  `vision_id` int(11) NOT NULL,
  `vision_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`vision_id`)
);

INSERT INTO `visions` VALUES (1,'Dependência de outros serviços'),(2,'Tempo de Resposta'),(3,'Cobertura de Testes Unitários'),(4,'Débito Técnico'),(5,'Consumo de Recursos Computacionais'),(6,'Disponibilidade');
