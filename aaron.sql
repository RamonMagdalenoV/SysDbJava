-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: maxdb
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bitacoracliente`
--

DROP TABLE IF EXISTS `bitacoracliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacoracliente` (
  `idbitacoracliente` int(11) NOT NULL AUTO_INCREMENT,
  `idclientes` int(11) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `accion` varchar(45) NOT NULL,
  PRIMARY KEY (`idbitacoracliente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoracliente`
--

LOCK TABLES `bitacoracliente` WRITE;
/*!40000 ALTER TABLE `bitacoracliente` DISABLE KEYS */;
INSERT INTO `bitacoracliente` VALUES (1,5,'004','Liz','Arnasdk','38213214','sdahj@dfsn.es','root@localhost','2017-05-10 15:06:22','INSERTAR'),(2,6,'sad','saf','dfh','5151514','saf@sdf','root@localhost','2017-05-10 15:13:08','INSERTAR'),(3,7,'ASD','XZXCG','FHH','622161111','DSGGDAS@DFS','root@localhost','2017-05-10 15:30:35','INSERTAR'),(4,8,'ASDsad','safASF','dfhXVC','5151514XCV','saf@sdfXCV','root@localhost','2017-05-10 15:30:45','INSERTAR'),(5,5,'004','Liz','Arnasdk','38213214','sdahj@dfsn.es','root@localhost','2017-05-10 15:31:24','ACTUALIZAR'),(6,9,'0021WS','AAAA','BBBBB','544651','AASD@SJKGD','root@localhost','2017-05-10 15:34:54','INSERTAR'),(7,5,'004','LizBETH','Arnasdk','38213214','sdahj@dfsn.es','root@localhost','2017-05-10 15:35:01','ACTUALIZAR'),(8,7,'ASD','XZXCG','FHH','622161111','DSGGDAS@DFS','root@localhost','2017-05-10 15:37:40','ELIMINAR');
/*!40000 ALTER TABLE `bitacoracliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacoraproducto`
--

DROP TABLE IF EXISTS `bitacoraproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacoraproducto` (
  `idbitacoraProducto` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `precio` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `accion` varchar(45) NOT NULL,
  PRIMARY KEY (`idbitacoraProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoraproducto`
--

LOCK TABLES `bitacoraproducto` WRITE;
/*!40000 ALTER TABLE `bitacoraproducto` DISABLE KEYS */;
INSERT INTO `bitacoraproducto` VALUES (1,7,'005','aa','bb','111','root@localhost','2017-05-10 13:34:31','INSERTAR'),(2,7,'005','Tarjeta Video','Nvidia 2GB','2680','root@localhost','2017-05-10 13:35:23','MODIFICAR'),(3,7,'005','Tarjeta Video','Nvidia 2GB','2680','root@localhost','2017-05-10 13:37:18','MODIFICAR'),(4,7,'005','Tarjeta Video','Nvidia ','2680','root@localhost','2017-05-10 13:38:00','MODIFICAR'),(5,12,'006','AAA','AAAA','222','root@localhost','2017-05-10 13:38:25','INSERTAR'),(6,7,'005','XXXX','XXXX','2500','root@localhost','2017-05-10 13:45:27','ELIMINAR'),(7,5,'003','Monitor LED','Tecnologia ','1900','root@localhost','2017-05-16 09:13:31','MODIFICAR'),(8,13,'003sfsfs','Monitor LEDssssssxxxxx','Tecnologia xxxx','1900xxx','root@localhost','2017-05-16 10:47:00','INSERTAR'),(9,13,'003sfsfs','Monitor LEDssssssxxxxx','Tecnologia xxxx','1900xxx','root@localhost','2017-05-16 10:47:25','ELIMINAR'),(10,5,'003','Monitor LEDssssss','Tecnologia ','1900','root@localhost','2017-06-06 12:26:47','MODIFICAR');
/*!40000 ALTER TABLE `bitacoraproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacoraproveedores`
--

DROP TABLE IF EXISTS `bitacoraproveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacoraproveedores` (
  `idbitacoraproveedores` int(11) NOT NULL AUTO_INCREMENT,
  `idproveedor` int(11) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `accion` varchar(45) NOT NULL,
  PRIMARY KEY (`idbitacoraproveedores`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoraproveedores`
--

LOCK TABLES `bitacoraproveedores` WRITE;
/*!40000 ALTER TABLE `bitacoraproveedores` DISABLE KEYS */;
INSERT INTO `bitacoraproveedores` VALUES (1,4,'004','Hector','asdk','4545454','gf@df','root@localhost','2017-05-10 15:51:00','INSERTAR'),(2,5,'005','dfh','ll','5555555','ooooo@skd','root@localhost','2017-05-10 15:51:34','INSERTAR'),(3,3,'003','Raul Vera','Alguna2','5121005184','reaulex@sad.com','root@localhost','2017-05-10 15:51:46','ACTUALIZAR'),(4,1,'001','rsd','sddsa','11351235','sad@hotmail.com','root@localhost','2017-05-10 15:51:59','ELIMINAR'),(5,4,'004','Hector','asdk','4545454','gf@df','root@localhost','2017-06-06 12:25:54','ACTUALIZAR'),(6,5,'005','dfh','ll','5555555','ooooo@skd','root@localhost','2017-06-06 12:26:25','ACTUALIZAR');
/*!40000 ALTER TABLE `bitacoraproveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `idClientes` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`idClientes`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'001','Raul','Alguna1','31215445','skja@dsfkh.com'),(3,'003','Rafa M','AlgunaM','31231001','sk@fsdj.M'),(4,'002','Ramon','Alguna','21252123','sad@sad.com'),(5,'004','Liz','Arnasdk','38213214','sdahj@dfsn.es'),(6,'sad','saf','dfh','5151514','saf@sdf'),(8,'ASDsad','safASF','dfhXVC','5151514XCV','saf@sdfXCV'),(9,'0021WS','AAAA','BBBBB','544651','AASD@SJKGD');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER InsertClientes AFTER INSERT
ON clientes
FOR EACH ROW
INSERT INTO 
bitacoracliente(idclientes,codigo,nombre,direccion,telefono,mail,usuario,fecha,accion)
VALUES
(NEW.idClientes,NEW.codigo,NEW.nombre,NEW.direccion,NEW.telefono,NEW.mail,user(),now(),'INSERTAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER UpdateClientes AFTER UPDATE
ON clientes 
FOR EACH ROW
INSERT INTO 
bitacoracliente(idclientes,codigo,nombre,direccion,telefono,mail,usuario,fecha,accion)
VALUES
(OLD.idClientes,OLD.codigo,OLD.nombre,OLD.direccion,OLD.telefono,OLD.mail,user(),now(),'ACTUALIZAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER DeleteClientes AFTER DELETE
ON clientes 
FOR EACH ROW
INSERT INTO 
bitacoracliente(idclientes,codigo,nombre,direccion,telefono,mail,usuario,fecha,accion)
VALUES
(OLD.idClientes,OLD.codigo,OLD.nombre,OLD.direccion,OLD.telefono,OLD.mail,user(),now(),'ELIMINAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `idproductos` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `precio` varchar(45) NOT NULL,
  PRIMARY KEY (`idproductos`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'001','Laptop','Hp','3600'),(2,'002','Horno','Electrodomesticos','2300'),(5,'003','Monitor LED','Tecnologia ','1900'),(6,'004','Mouse ','Tecnologia Inalambrica','120'),(12,'006','AAA','AAAA','222');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER InsertProductos AFTER INSERT
ON productos 
FOR EACH ROW
INSERT INTO 
bitacoraproducto(idProducto,codigo,nombre,descripcion,precio,usuario,fecha,accion)
VALUES
(NEW.idproductos,NEW.codigo,NEW.nombre,NEW.descripcion,NEW.precio,user(),now(),'INSERTAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER UpdateProductos AFTER UPDATE
ON productos 
FOR EACH ROW
INSERT INTO 
bitacoraproducto(idProducto,codigo,nombre,descripcion,precio,usuario,fecha,accion)
VALUES
(OLD.idproductos,OLD.codigo,OLD.nombre,OLD.descripcion,OLD.precio,user(),now(),'MODIFICAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER DeleteProductos AFTER DELETE
ON productos 
FOR EACH ROW
INSERT INTO 
bitacoraproducto(idProducto,codigo,nombre,descripcion,precio,usuario,fecha,accion)
VALUES
(OLD.idproductos,OLD.codigo,OLD.nombre,OLD.descripcion,OLD.precio,user(),now(),'ELIMINAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `idproveedores` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`idproveedores`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (2,'002','Ramon','Alguna1','21252123','sad@sad.com'),(3,'003A','Raul Vera','Alguna2','5121005184','reaulex@sad.com'),(4,'004','Hector','ASDK','4545454','gf@df'),(5,'005','JUAN','ALGUNA4','5555555555','ooooo@skd.es');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER InsertProveedores AFTER INSERT
ON proveedores
FOR EACH ROW
INSERT INTO 
bitacoraproveedores(idproveedor,codigo,nombre,direccion,telefono,mail,usuario,fecha,accion)
VALUES
(NEW.idproveedores,NEW.codigo,NEW.nombre,NEW.direccion,NEW.telefono,NEW.mail,user(),now(),'INSERTAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER UpdateProveedores AFTER UPDATE
ON proveedores 
FOR EACH ROW
INSERT INTO 
bitacoraproveedores(idproveedor,codigo,nombre,direccion,telefono,mail,usuario,fecha,accion)
VALUES
(OLD.idproveedores,OLD.codigo,OLD.nombre,OLD.direccion,OLD.telefono,OLD.mail,user(),now(),'ACTUALIZAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER DeleteProveedores AFTER DELETE
ON proveedores 
FOR EACH ROW
INSERT INTO 
bitacoraproveedores(idproveedor,codigo,nombre,direccion,telefono,mail,usuario,fecha,accion)
VALUES
(OLD.idproveedores,OLD.codigo,OLD.nombre,OLD.direccion,OLD.telefono,OLD.mail,user(),now(),'ELIMINAR') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping routines for database 'maxdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-12  0:43:13
