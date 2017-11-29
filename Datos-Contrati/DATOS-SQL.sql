CREATE DATABASE  IF NOT EXISTS `contratista_2017` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `contratista_2017`;
-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: contratista_2017
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `arl`
--

DROP TABLE IF EXISTS `arl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) DEFAULT NULL,
  `riesgo` varchar(5) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arl`
--

LOCK TABLES `arl` WRITE;
/*!40000 ALTER TABLE `arl` DISABLE KEYS */;
INSERT INTO `arl` (`id`, `codigo`, `riesgo`, `activo`) VALUES (1,'1806001','I',1),(2,'2013001','II',1),(3,'2731002','II',1),(4,'2753001','II',1),(5,'3517002','III',1),(6,'3632002','III',1),(7,'3851401','III',1),(8,'5101001','V',1),(9,'5452102','V',1),(10,'5453002','V',1),(11,'5851501','V',1);
/*!40000 ALTER TABLE `arl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aseguradora`
--

DROP TABLE IF EXISTS `aseguradora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aseguradora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_aseguradora` varchar(45) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aseguradora`
--

LOCK TABLES `aseguradora` WRITE;
/*!40000 ALTER TABLE `aseguradora` DISABLE KEYS */;
/*!40000 ALTER TABLE `aseguradora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `departamentos_id` varchar(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ciudades_departamentos1_idx` (`departamentos_id`),
  CONSTRAINT `fk_ciudades_departamentos1` FOREIGN KEY (`departamentos_id`) REFERENCES `departamentos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` (`id`, `nombre`, `activo`, `departamentos_id`) VALUES (1,'PALMIRA',1,'VAL'),(2,'CALI',1,'VAL'),(3,'BUGA',1,'VAL'),(4,'EL CERRITO',1,'VAL'),(5,'TULUA',1,'VAL'),(6,'PRADERA',1,'VAL'),(7,'ROZO',1,'VAL'),(8,'POPAYAN',1,'CAU'),(9,'COTA',1,'CUN'),(10,'BOGOTA',1,'CUN');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratos`
--

DROP TABLE IF EXISTS `contratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contratos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_contrato` int(11) DEFAULT NULL,
  `fecha_suscripcion` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `valor_contrato` int(11) DEFAULT NULL,
  `fecha_terminacion_adicional` date DEFAULT NULL,
  `valor_adicion` int(15) DEFAULT NULL,
  `estado_contrato` varchar(15) DEFAULT NULL,
  `archivo_adjunto` varchar(250) DEFAULT NULL,
  `tipos_contrato_id` varchar(8) DEFAULT NULL,
  `objeto_contrato_id` int(11) DEFAULT NULL,
  `crp_id` int(11) DEFAULT NULL,
  `contratista_id` int(11) DEFAULT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contratos_tipos_contrato1_idx` (`tipos_contrato_id`),
  KEY `fk_contratos_objeto_contrato1_idx` (`objeto_contrato_id`),
  KEY `fk_contratos_crp1_idx` (`crp_id`),
  KEY `fk_contratos_usuarios1_idx` (`contratista_id`),
  KEY `fk_contratos_usuarios2_idx` (`supervisor_id`),
  CONSTRAINT `fk_contratos_crp1` FOREIGN KEY (`crp_id`) REFERENCES `crp` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contratos_objeto_contrato1` FOREIGN KEY (`objeto_contrato_id`) REFERENCES `objeto_contrato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contratos_tipos_contrato1` FOREIGN KEY (`tipos_contrato_id`) REFERENCES `tipos_contrato` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contratos_usuarios1` FOREIGN KEY (`contratista_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contratos_usuarios2` FOREIGN KEY (`supervisor_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratos`
--

LOCK TABLES `contratos` WRITE;
/*!40000 ALTER TABLE `contratos` DISABLE KEYS */;
/*!40000 ALTER TABLE `contratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crp`
--

DROP TABLE IF EXISTS `crp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_crp` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crp`
--

LOCK TABLES `crp` WRITE;
/*!40000 ALTER TABLE `crp` DISABLE KEYS */;
INSERT INTO `crp` (`id`, `numero_crp`) VALUES (1,'117'),(2,'217'),(3,'317'),(4,'417'),(5,'817'),(6,'717'),(7,'617'),(8,'517'),(9,'1217'),(10,'1417'),(11,'1317'),(12,'1517'),(13,'2317'),(14,'2417'),(15,'2117'),(16,'2517'),(17,'2217'),(18,'1717'),(19,'1817'),(20,'2017'),(21,'1917'),(22,'2617'),(23,'2717'),(24,'2917'),(25,'3117'),(26,'3017'),(27,'3217'),(28,'3617'),(29,'3517'),(30,'3717'),(31,'3817'),(32,'3917'),(33,'4017'),(34,'4317'),(35,'4417'),(36,'4517'),(37,'4617'),(38,'4817'),(39,'4917'),(40,'4717'),(41,'5117'),(42,'5317'),(43,'5417'),(44,'5217'),(45,'5017'),(46,'6317'),(47,'6417'),(48,'6517'),(49,'6717'),(50,'6617'),(51,'7017'),(52,'6817'),(53,'6917'),(54,'7517'),(55,'7417'),(56,'7317'),(57,'7217'),(58,'7117'),(59,'8517'),(60,'7717'),(61,'8417'),(62,'8317'),(63,'8217'),(64,'8117'),(65,'7817'),(66,'8017'),(67,'7917'),(68,'7617'),(69,'9217'),(70,'8617'),(71,'9017'),(72,'8817'),(73,'8717'),(74,'9317'),(75,'9117'),(76,'8917'),(77,'9817'),(78,'9917'),(79,'9417'),(80,'9517'),(81,'9617'),(82,'9717'),(83,'10017'),(84,'10117'),(85,'10217'),(86,'10317'),(87,'10417'),(88,'11317'),(89,'11217'),(90,'11117'),(91,'10817'),(92,'10717'),(93,'10617'),(94,'11017'),(95,'10917'),(96,'10517'),(97,'11917'),(98,'11817'),(99,'11717'),(100,'12017'),(101,'12117'),(102,'11417'),(103,'11617'),(104,'12517'),(105,'12217'),(106,'12317'),(107,'12417'),(108,'13317'),(109,'13217'),(110,'13117'),(111,'13017'),(112,'12917'),(113,'12817'),(114,'12617'),(115,'12717'),(116,'16217'),(117,'17017'),(118,'15917'),(119,'15817'),(120,'15717'),(121,'16317'),(122,'16917'),(123,'15317'),(124,'15017'),(125,'14717'),(126,'17117'),(127,'14417'),(128,'14117'),(129,'14017'),(130,'13917'),(131,'14517'),(132,'13817'),(133,'13717'),(134,'13617'),(135,'14217'),(136,'14317'),(137,'13517'),(138,'13417'),(139,'14817'),(140,'14617'),(141,'14917'),(142,'15217'),(143,'15517'),(144,'16717'),(145,'15117'),(146,'16817'),(147,'15417'),(148,'15617'),(149,'20317'),(150,'20717'),(151,'20417'),(152,'20517'),(153,'20617'),(154,'17817'),(155,'17917'),(156,'17417'),(157,'18017'),(158,'17717'),(159,'17517'),(160,'17617'),(161,'18117'),(162,'18817'),(163,'18717'),(164,'18917'),(165,'19017'),(166,'20817'),(167,'19317'),(168,'19217'),(169,'19117'),(170,'19717'),(171,'19517'),(172,'19617'),(173,'19417'),(174,'19817'),(175,'20217'),(176,'21017'),(177,'20917'),(178,'21117'),(179,'21517'),(180,'21617'),(181,'31017'),(182,'31817'),(183,'32817'),(184,'32917'),(185,'33017'),(186,'33117'),(187,'33517'),(188,'33617'),(189,'36417'),(190,'36517'),(191,'37417'),(192,'37517'),(193,'37617'),(194,'37817'),(195,'37917'),(196,'38017'),(197,'45617'),(198,'45417'),(199,'45517'),(200,'45717'),(201,'54017'),(202,'55717'),(203,'57817'),(204,'62517'),(205,'73717'),(206,'74017'),(207,'74117'),(208,'75917'),(209,'79217'),(210,'99517'),(211,'101517'),(212,'101617');
/*!40000 ALTER TABLE `crp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamentos` (
  `id` varchar(5) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` (`id`, `nombre`) VALUES ('CAU','CAUCA'),('CUN','CUNDINAMARCA'),('VAL','VALLE DEL CAUCA');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eps`
--

DROP TABLE IF EXISTS `eps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eps`
--

LOCK TABLES `eps` WRITE;
/*!40000 ALTER TABLE `eps` DISABLE KEYS */;
INSERT INTO `eps` (`id`, `nombre`, `activo`) VALUES (1,'ASMETSALUD',1),(2,'CAFESALUD',1),(3,'COLSANITAS',1),(4,'COMFANDI',1),(5,'COMFENALCO',1),(6,'COOMEVA',1),(7,'CRUZ BLANCA',1),(8,'EMSSANAR',1),(9,'S.O.S',1),(10,'SALUD TOTAL',1),(11,'SOS',1),(12,'SURA',1),(13,'NUEVA EPS',1),(14,'SANITAS',1),(15,'COMPESAR',1);
/*!40000 ALTER TABLE `eps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objeto_contrato`
--

DROP TABLE IF EXISTS `objeto_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objeto_contrato` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto_contrato`
--

LOCK TABLES `objeto_contrato` WRITE;
/*!40000 ALTER TABLE `objeto_contrato` DISABLE KEYS */;
INSERT INTO `objeto_contrato` (`id`, `descripcion`) VALUES (1,'Prestación temporal de servicios personales  para apoyar los procesos de gestión de comunicaciones oficiales en la unidad de correspondencia en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(2,'Prestación temporal de servicios personales, para realizar las actividades administrativas inherentes al proceso de adquisición de bienes y servicios,  de acuerdo con los parámetros de calidad definidos del Centro de Biotecnología Industrial del SENA Regional Valle.'),(3,'Prestación temporal de servicios profesionales, para la realizar actividades correspondientes a los trámites Preparatoria, Pre-contractuales, Contractuales y pos-contractuales de servicios personales del Centro de Biotecnología Industrial del SENA Regional Valle'),(4,'Prestación temporal de servicios profesionales, para el manejo del aplicativo Sistema Integrado de información Financieras SIIF nación,  en el área de presupuesto del Centro de Biotecnología Industrial del SENA Regional Valle.'),(5,'Prestación temporal de servicios profesionales para gestionar en aspectos técnicos,  operacionales relacionados con la programación y ejecución de formación complementaria  y virtual en  el Centro de Biotecnología Industrial del SENA Regional Valle'),(6,'Prestar los servicios personales de carácter temporal, apoyo técnico a los procesos misionales, con énfasis en la planeación comunicación estratégica, brindando apoyo en el desarrollo de proyectos estratégicos  del Centro de Biotecnología Industrial del SENA Regional Valle'),(7,'Prestar los servicios profesionales de carácter temporal para realizar los procesos de adquisición de bienes, obras y servicios a través de las diferentes modalidades de contratación de acuerdo con los procedimientos legales establecidos y normatividad vigente para garantizar el adecuado funcionamiento del Centro de Biotecnología.'),(8,'Prestación temporal de servicios profesionales, para el manejo del aplicativo Sistema Integrado de información Financieras SIIF nación,  en el área de Contabilidad y tributaria del Centro de Biotecnología Industrial del SENA Regional Valle'),(9,'Prestación de servicios profesionales de carácter temporal como Orientadora del Programa de Victimas para acompañar, supervisar, planear, orientar, apoyar y realizar seguimiento y control a la ejecución del programa y apoyar la orientación en procesos grupales a poblaciones vulnerables en el marco de los lineamientos establecidos en el plan de acción y el procedimiento del Sistema Integrado de Gestión de Calidad del Centro de Biotecnología Industrial del SENA Regional Valle.'),(10,'Prestación de servicios profesionales de un abogado  para el desarrollo de las gestiones jurídicas relacionadas con las etapas preparatoria, precontractual, contractual y pos contractual de los tramites de contratación de bienes y servicios, así como apoyar jurídicamente a todas las áreas del Centro de   Biotecnología Industrial.'),(11,'Prestación temporal de servicios profesionales de carácter temporal para apoyar la implementación, divulgación, mantenimiento y mejoramiento continuo de los cuatro subsistemas que conforman el Sistema Integrado de Gestión y Autocontrol en el  Centro de Biotecnología Industrial y las sedes adscritas a éste'),(12,'Prestación temporal de servicios personales, para apoyar los procesos administrativos del área de Bienestar, realizando actividades pertinentes a los procedimientos de convocatoria, adjudicación y desembolso de los apoyos económicos para los aprendices, aplicando las normas y procedimientos definidos por el SENA,  elaborando y revisando documentación necesaria, a fin de dar cumplimiento a cada uno de los procedimientos Internos de la oficina de Bienestar del Centro de Biotecnología Industrial del SENA Regional Valle.'),(13,'Prestación temporal de servicios profesionales, como Gestor de Conocimiento Sectorial en la Red de Biotecnología en el SENA.'),(14,'Prestación de servicio temporales de la gestión y el control del ingreso de aprendices de formación titulada en el aplicativo Sofía Plus, citación a primera y segunda fase y matricula académica en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(15,'Prestar los servicios personales de carácter temporal para apoyar a la Coordinación Académica en  procesos de registro y control de eventos en Programador de horarios y sofiaplus para los programas de formación del Centro de Biotecnología Industrial del SENA Regional Valle'),(16,'Prestación temporal de servicios personales, para realizar seguimiento a los procesos de almacenamiento, control, custodia, despacho, revisión, organización y distribución conforme a las normas y procedimientos vigentes para el manejo de bienes devolutivos y de consumo, a fin de mantener los niveles de inventarios necesarios y garantizar un servicio eficiente en el Centro de Biotecnología Industrial del SENA Regional Valle'),(17,'Prestación temporal de servicios personales, para apoyo al manejo del aplicativo Sistema Integrado de información Financieras SIIF nación, en las actividades de validación de la aplicación de normas y procedimientos vigentes al interior del proceso de financiero, en el área de Tesorería del Centro de Biotecnología Industrial del SENA Regional Valle.'),(18,'Prestación temporal de servicios personales, para apoyar los procesos administrativos del área de Bienestar, aplicando las normas y procedimientos definidos por el SENA,  elaborando y revisando documentación necesaria, a fin de dar cumplimiento a cada uno de los procedimientos Internos de la oficina de Bienestar del Centro de Biotecnología Industrial del SENA Regional Valle.'),(19,'Prestación temporal de servicios profesionales en psicología, para apoyar las actividades del Plan Nacional de Bienestar al Aprendiz e implementar estrategias de  promoción de salud mental en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(20,'Prestación temporal de servicios profesionales como trabajador social, para apoyar los programas de Bienestar al Aprendiz, generar planes y proyectos con el fin de brindar atención, apoyo y orientación oportuna en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(21,'Prestación de servicios personales de carácter temporal, para el apoyo el Proceso de Gestión por Competencias Laborales en el control, alimentación y administración del Aplicativo del SECCL del Centro de Biotecnología Industrial del SENA Regional Valle'),(22,'Prestar los servicios profesionales de carácter temporal en el Área  Innovación y Desarrollo Tecnológico para realizar investigación en el área de Biotecnología, apoyar  los semilleros de investigación, realizar acciones de transferencia a los programas de formación profesional Integral, Garantizar la continuidad del Sistema Integrado de Calidad  en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(23,'Prestación temporal de servicios profesionales, como líder de Certificación de Competencias Laborales, para el cumplimiento de los proyectos de Certificación de Competencias Laborales atendidos por el Centro de Biotecnología Industrial en empresas y  en atención de la demanda social, teniendo en cuenta las líneas de acción establecidas en el Plan Operativo 2016'),(24,'Prestar servicios personales de apoyo a la gestión, administración, registro y actualización de la información y la documentación del proceso de gestión de instancias de concertación y competencias laborales en el Centro de Biotecnología Industrial del SENA Regional Valle'),(25,'Prestación temporal de servicios profesionales como líder del grupo de Bienestar al Aprendiz para apoyar las actividades contempladas en el plan de Bienestar de Aprendices de conformidad con los lineamientos establecidos para tal fin en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(26,'Prestación de servicios profesionales para gestionar y garantizar el funcionamiento de la Biblioteca del Centro de Formación, que incluye la organización normalizada de las colecciones y  la producción de los servicios de búsqueda y recuperación de información desde el Sistema de Bibliotecas SENA (SBS) del Centro de Biotecnología Industrial del SENA Regional Valle.'),(27,'Prestar los servicios personales de carácter temporal para gestionar la prevención y manejo de  riesgos químicos, biológicos, mecánicos, eléctricos entre otros que se presentan  en el Centro de Biotecnología Industrial y las sedes adscritas a este'),(28,'Prestación temporal de servicios personales, de un enfermero(a) para apoyar  el programa de Bienestar Aprendices del Centro en el área de la Salud en el diseño e implementación de estrategias que mejoren las condiciones ambientales, físicas, nutricionales, psíquicas, emocionales y de salud ocupacional de los aprendices del Centro de Biotecnología Industrial del SENA Regional Valle.'),(29,'Prestación temporal de servicios profesionales, como capellán para apoyar las acciones del Plan Nacional de Bienestar al Aprendiz con el fin de  promover los principios y valores en la comunidad educativa en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(30,'Prestación temporal de servicios personales , de un profesional del área Cultura Física, para apoyar el programa Bienestar Aprendices del Centro en el componente estratégico de Deporte del Centro de Biotecnología Industrial del SENA Regional Valle.'),(31,'Prestación temporal de servicios profesionales, para apoyar el fortalecimiento de calidad de la Formación del Centro de Biotecnología Industrial del SENA, Regional Valle'),(32,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  AREAS  BASICAS  Y/O TRANSVERSALES y SEGUIMIENTO A LAS ACTIVIDADES DE FORMACION EN LA ETAPA PRACTICA DE LOS APRENDICES en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(33,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN ANALISIS Y DESARROLLO DE SISTEMAS DE INFORMACION - TECNICO EN SISTEMAS, COMPLEMENTARIO EN  INFORMATICA Y COMO TRANSVERSAL.  FORMACION COMPLEMENTARIA AFIN  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(34,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Tecnólogo EN GESTION DEL TALENTO HUMANO, GESTION ADMINISTRATIVA, DIRECCION DE VENTAS. TECNICO EN  RECURSOS HUMANOS, VENTA DE PRODUCTOS Y SERVICIOS. FORMACION COMPLEMENTARIA AFIN  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(35,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  TECNICO EN SOLDADURA, CONSTRUCCION DE ESTRUCTORAS METALICAS SOLDADAS, SOLDADURA EN PLATINA. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(36,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN GESTION LOGISTICA, TECNICO EN LOGISTICA EMPRESARIAL,  DESARROLLO DE OPERACIONES LOGISTICAS  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(37,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Tecnólogo EN MANTENIMIENTO MECÁNICO INDUSTRIAL, TECNICO EN MAQUINAS Y HERRAMIENTAS, MECANICO INDUSTRIAL, FABRICACIÓN DE ESTRUCTURAS METÁLICAS SOLDADAS, .   FORMACION COMPLEMENTARIA  AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(38,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de    AREAS  BASICAS  Y/O TRANSVERSALES EN CULTURA FISICA  EN PROGRAMAS DE FORMACION TITULADA.  FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(39,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) deTecnólogo EN GESTION ADMINISTRATIVA. Tecnólogo EN GESTION DOCUMENTAL, TECNICO EN ASISTENCIA EN ORGANIZACIÓN DE ARCHIVOS, ASISTENCIA ADMINISTRATIVA, FORMACION COMPLEMENTARIA AFIN en la modalidad de periodos temporales en el Centro de Biotecnología Industrial del SENA Regional Valle'),(40,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN GESTIÓN DE LA PRODUCCION, TECNICO EN  SEGURIDAD OCUPACIONAL, SALUD OCUPACIONAL (TECNICA Y TRANSVERSAL) FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(41,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN CONTABILIDAD Y FINANZAS, GESTION BANCARIA Y DE ENTIDADES FINANCIERAS, DIRECCION DE VENTAS, GESTION DE MERCADOS Y GESTION ADMINISTRATIVA, GESTION LOGISTICA. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(42,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN CONTABILIDAD Y FINANZAS, GESTION BANCARIA Y DE ENTIDADES FINANCIERAS, DIRECCION DE VENTAS, GESTION DE MERCADOS Y GESTION ADMINISTRATIVA, GESTION LOGISTICA. FORMACION COMPLEMENTARIA AFIN. en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(43,'Prestar los servicios personales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  TECNICO EN PELUQUERÍA, COSMETOLOGIA Y FORMACION COMPLEMENTARIA CORTES Y PEINADOS, TÉCNICAS DE CORTE Y ESCULPIDO DE CABELLO, COLORIMETRIA en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(44,'Prestación temporal de servicios profesionales, como líder para acompañar, supervisar, apoyar y orientar todas las actividades relacionadas con el programa de articulación con la media del Centro de Biotecnología Industrial del SENA Regional Valle.'),(45,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de   AREAS  BASICAS  Y/O TRANSVERSALES en EMPRENDIMIENTO EN PROGRAMAS DE FORMACION TITULADA. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(46,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN GESTIÓN DE MERCADOS, GESTION COMERCIAL DE SERVICIOS, DIRECCION DE VENTAS, GESTIÓN ADMINISTRATIVA, GESTIÓN DOCUMENTAL.  TECNICO EN VENTAS DE PRODUCTOS Y SERVICIOS Y DE OPERACIONES COMERCIALES. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(47,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo  EN SISTEMAS GESTION AMBIENTAL,  Tecnólogo EN GESTIÓN INTEGRADA DE LA CALIDAD, MEDIO AMBIENTE, SEGURIDAD Y SALUD OCUPACIONAL, TECNICO EN MANEJO AMBIENTAL  (TECNICA Y TRANSVERSAL) FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(48,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN GESTION ADMINISTRATIVA, GESTION EMPRESARIAL, FORMULACIÓN DE PROYECTOS, DIRECCION DE VENTAS, BIOCOMERCIO SOSTENIBLE, GESTION COMERCIAL DE SERVICIOS. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(49,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN ANALISIS Y DESARROLLO DE SISTEMAS DE INFORMACION - TECNICO EN SISTEMAS, COMPLEMENTARIO EN  INFORMATICA Y COMO TRANSVERSAL.  FORMACION COMPLEMENTARIA AFIN.  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(50,'Prestar los servicios personales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  CORTES Y PEINADOS, TÉCNICAS DE CORTE Y ESCULPIDO DE CABELLO, PELUQUERÍA, MANICURE Y PEDICURE en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(51,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Tecnólogo EN  MANTENIMIENTO ELECTRONICO E INSTRUMENTAL INDUSTRIAL, MANTENIMIETO ELECTRICO, MANTENIMIETO ELECTRICO INDUSTRIAL, -FORMACION COMPLEMENTARIA EN  ELECTRÓNICA BÁSICA, PROGRAMACIÓN BÁSICA DE MICROCONTROLADORES PIC en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(52,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de    AREAS  BASICAS  Y/O TRANSVERSALES en ETICA - EN PROGRAMAS DE FORMACION TITULADA. Tecnólogo EN  TALENTO HUMANO , TECNICO EN RECUSOS HUMANOS. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(53,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  AREAS  BASICAS  Y/O TRANSVERSALES en COMUNICACIÓN EN PROGRAMAS DE FORMACION TITULADA. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(54,'Prestar los servicios profesionales de carácter teTecnólogo  EN SISTEMAS GESTION AMBIENTAL,  Tecnólogo EN GESTIÓN INTEGRADA DE LA CALIDAD, MEDIO AMBIENTE, SEGURIDAD Y SALUD OCUPACIONAL, TECNICO EN MANEJO AMBIENTAL  (TECNICA Y TRANSVERSAL) FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(55,'Prestación temporal de servicios personales, de apoyo a la gestión para actividades administrativas de la coordinación académica   del Centro de Biotecnología Industrial del SENA Regional Valle.'),(56,'Prestación temporal de servicios personales, para realizar actividades de soporte a la coordinación de  formación profesional, promoción y relacionamiento corporativo en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(57,'Prestación temporal de servicios personales, para realizar las actividades de cotizaciones previas a los  estudios de mercado y análisis comparativos inherentes  los procesos precontractuales, y acompañamiento a la supervisión de los procesos contractuales y pos contractuales; de adquisición de bienes y servicios en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(58,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Formacion Complementaria en  ACOMPAÑAMIENTO AL DESEMPEÑO PEDAGOGICO DEL INSTRUCTOR, ELABORACION DE GUIAS DE APRENDIZAJE, ESTRUCTURACION DE PROYECTOS FORMATIVOS en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(59,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACION TITULADA Y COMPLEMENTARIA EN BILINGUISMO (LIDER) en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(60,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Tecnólogo EN PROCESOS BIOTECNOLOGICOS APLICADOS A LA INDUSTRIA, TECNICO EN PRODUCCION DE BIOCOMBUSTIBLES Y FERMENTACIONES INDUSTRIALES,   FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(61,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  CONSTRUCCION- CONSTRUCCIONES LIVIANAS EN SECO, CONSTRUCCIÓN DE EDIFICACIONES, BÁSICO DE INSTALACIÓN DE ENCHAPE CERAMICO, PAÑETES O REVOQUES del fondo de industria de la construcción FIC en la modalidad de periodos temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(62,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de   Tecnólogo EN  FORMULACION DE PROYECTOS, GESTION  EMPRESARIAL Y GESTION ADMINISTRATIVA. TECNICO EN   SEGURIDAD OCUPACIONAL, FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(63,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACIÓN COMPLEMENTARIA VIRTUAL EN BILINGUISMO en la modalidad de periodos temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(64,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACION TITULADA Y COMPLEMENTARIA EN BILINGUISMO en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(65,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN GESTION LOGISITICA, GESTIÓN DE MERCADOS.  VIRTUAL Y PRESENCIAL  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(66,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) deTecnólogo EN GESTION DEL TALENTO HUMANO, GESTION ADMINISTRATIVA, DIRECCION DE VENTAS. TECNICO EN  RECURSOS HUMANOS, VENTA DE PRODUCTOS Y SERVICIOS. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(67,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  AREAS  BASICAS  Y/O TRANSVERSALES en ETICA del fondo de industria de la construcción FIC en la modalidad de periodos temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(68,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  AVANZADO TRABAJO SEGURO EN ALTURAS, REENTRENAMIENTO NIVEL AVANZADO TRABAJO SEGURO EN ALTURAS en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(69,'Prestar los servicios personales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACION COMPLEMENTARIA EN ARTESANIAS-ARTESANIAS EN RESIDUO SOLIDO, ELABORACIÓN DE ARTESANIAS-TRANSFORMACION DE RESIDUOS SOLIDOS EN ARTESANIAS en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(70,'Prestar los servicios personales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  FORMACION COMPLEMENTARIA  EN BÁSICO EN MANTENIMIENTO Y OPERACIÓN DEL TRACTOR, OPERACIÓN TÉCNICA PARA MONTACARGAS CTT, BÁSICO EN OPERACIÓN Y MANTENIMIENTO DE MAQUINARIA PESADA (RETROCARGADOR), MANTENIMIENTO PREVENTIVO DEL TRACTOR AGRICOLA en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(71,'Prestación temporal de servicios profesionales, para apoyar los procesos de acompañamiento técnico de instructores contratistas, para el apoyo a la supervisión, seguimiento, evaluación y control de los contratos y procedimientos del proceso de ejecución de la formación, con el objetivo de verificar el cumplimiento de las obligaciones suscritas por los instructores de acuerdo a la normatividad establecida'),(72,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Apoyo a la orientación de procesos formatico y fortalecimiento pedagógico en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(73,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Sistemas, mantenimiento de equipos de cómputo, diseño e integración de multimedia en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(74,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Manejo ambiental, Sistemas de gestión ambiental en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(75,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Contabilización de operaciones comerciales y financieras, contabilidad  y finanzas en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(76,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Áreas  básicas  y/o transversales en emprendimiento en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(77,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Asistencia administrativa en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(78,'Prestar servicios profesionales de carácter temporal como instructor  y apoyo a la gestión del emprendimiento rural, para crear y fortalecer unidades productivas rurales sostenibles y demás áreas de su competencia, realizando acciones de formación y de acompañamiento técnico para el desarrollo empresarial rural, en las areas de Emprendedor en producción y comercialización de hortalizas con bio preparados Emprendedor en producción y comercialización de plántulas en vivero  Emprendedor en la producción y la comercialización en cultivo de hortalizas orgánicas. Emprendedor en la producción y la comercialización del cultivo de plátano Emprendedor en producción de bioinsumos Emprendedor en sistemas de producción agroecológica implementando BPA en cultivo de plátano en el marco de los lineamientos del Programa Sena Emprende Rurales-SER del Centro de Biotecnología Industrial.'),(79,'Prestar servicios profesionales de carácter temporal como instructor  y apoyo a la gestión del emprendimiento rural, para crear y fortalecer unidades productivas rurales sostenibles y demás áreas de su competencia, realizando acciones de formación y de acompañamiento técnico para el desarrollo empresarial rural, en las areas de Emprendedor en producción de derivados cárnicos Emprendedor en producción de quesos y productos lácteos fermentados  Emprendedor en la transformación y la comercialización de lácteos.  Emprendedor en procesamiento y comercialización de productos derivados de frutas y hortalizas en el marco de los lineamientos del Programa Sena Emprende Rurales-SER del Centro de Biotecnología Industrial.'),(80,'Prestar los servicios personales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  FORMACION COMPLEMENTARIA EN PANADERIA AVANZADA, PROCESOS BASICOS DE PASTELERIA, ELABORACIÓN DE PRODUCTOS DE PANADERIA Y PASTELERIA DE ALTA GAMA, ELABORACIÓN DE ALIMENTOS DE PANIFICACION DE MANERA ARTESANAL EN PANADERIA en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(81,'Prestar servicios profesionales de carácter temporal como instructor  y apoyo a la gestión del emprendimiento rural, para crear y fortalecer unidades productivas rurales sostenibles y demás áreas de su competencia, realizando acciones de formación y de acompañamiento técnico para el desarrollo empresarial rural, en las areas de Emprendedor en producción y comercialización de suplementos alimenticios para ganado bovinos. Emprendedor en producción y comercialización en lechones. Emprendedor en producción y comercialización de cerdo en pie Emprendedor en producción y comercialización de pollo de engorde en el marco de los lineamientos del Programa Sena Emprende Rurales-SER del Centro de Biotecnología Industrial.'),(82,'Prestar servicios profesionales de carácter temporal como instructor  y apoyo a la gestión del emprendimiento rural, para crear y fortalecer unidades productivas rurales sostenibles y demás áreas de su competencia, realizando acciones de formación y de acompañamiento técnico para el desarrollo empresarial rural, en las areas deEmprendedor en prestación del servicio de información turística local  Emprendedor en servicios de alojamiento   Emprendedor en formación agro-turística Emprendedor en actividades de animación en espacios rurales Emprendedores en recorridos de agro ecoturismo  Emprendedor en organización y manejo de posadas rurales  en el marco de los lineamientos del Programa Sena Emprende Rurales-SER del Centro de Biotecnología Industrial.'),(83,'Prestar servicios profesionales de carácter temporal como instructor  y apoyo a la gestión del emprendimiento rural, para crear y fortalecer unidades productivas rurales sostenibles y demás áreas de su competencia, realizando acciones de formación y de acompañamiento técnico para el desarrollo empresarial rural, en las areas de Emprendedor en comercialización de productos y servicios rurales, todos los programas de formación dirigidos a población de jóvenes rurales emprendedores en el marco de los lineamientos del Programa Sena Emprende Rurales-SER del Centro de Biotecnología Industrial.'),(84,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACIÓN  COMPLEMENTARIA VIRTUAL EN CONTABILIDAD EN LAS ORGANIZACIONES, INGRESOS Y GASTOS PERSONALES, ANALISIS FINANCIERO, CUENTAS CONTABLES, MICROFINANZAS, ADMINISTRACION DE RECURSOS HUMANOS en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(85,'Prestación temporal de servicios personales de apoyo administrativo a la  gestión relacionada con la ejecución de formación en  el Centro de Biotecnología Industrial del SENA Regional Valle'),(86,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Tecnólogo EN GESTION LOGISTICA Y Tecnólogo EN  GESTION DE MERCADOS VIRTUAL  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(87,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Fortalecimiento en Lectura Crítica para Articulación con la Media grados 9 (Complementario) en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(88,'Prestar servicios profesionales de carácter temporal como instructor  y apoyo a la gestión del emprendimiento rural, para crear y fortalecer unidades productivas rurales sostenibles y demás áreas de su competencia, realizando acciones de formación y de acompañamiento técnico para el desarrollo empresarial rural, en las areas de Fortalecimiento comercial en el marco de los lineamientos del Programa Sena Emprende Rurales-SER del Centro de Biotecnología Industrial.'),(89,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Seguridad ocupacional, salud ocupacional en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(90,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Instalaciones eléctricas residenciales en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(91,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Carpintería metálica, Fabricación de estructuras soldadas, Mecánica automotriz, mecanizado de productos metalmecánicos en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(92,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Fortalecimiento en Razonamiento Cuantitativo para Articulación con la Media grados 9 (Complementario) en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(93,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  FORMACIÓN COMPLEMENTARIA EN AUTOCAD - OFIMATICA - INFORMÁTICA  en la modalidad de Horas en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(94,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de INSTALASIONES ELECTRICAS EN BAJA TENSIÓN  - MANTENIMIENTO ELECTRICO, ELECTRICIDAD BÀSICA, CONSTRUCCIÓN del fondo de industria de la construcción FIC en la modalidad de Horas de Formación en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(95,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACION COMPLEMENTARIA EN  BIOSEGURIDAD, BIOSEGURIDAD  APLICADA A LA COSMETOLOGIA, MANEJO INTEGRAL DE RESIDUOS HOSPITALARIOS Y SIMILARES,  SERVICIOS FARMACEUTICOS en la modalidad de Horas de Formación en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(96,'Prestar los servicios profesionales de carácter temporal, para la ejecución de acciones de formación para Población Desplazada en el área de Complementario en Procesamiento de alimentos (cárnicos, lácteos, frutas y hortalizas) en la modalidad periodo temporal en el Centro de Biotecnología Industrial del SENA Regional Valle'),(97,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Fortalecimiento en Ciencias Naturales para Articulación con la Media grados 9 (Complementario) en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(98,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en Recreación en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(99,'Prestar los servicios profesionales de carácter temporal de un doctor para liderar los procesos de Semilleros de Investigación y fomentar la publicación de artículos científicos de los grupos de investigación del Centro, así como apoyar la reclasificación de los mismos.'),(100,'Prestar los servicios personales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  CONFECCIONES, FUNDAMENTOS DE PATRONAJE DE ROPA FEMENINA, OPERACIONES BÁSICAS EN CONFECCIÓN INDUSTRIAL en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(101,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  Tecnólogo EN GESTION BANCARIA Y DE ENTIDADES FINANCIERAS Y  GESTION ADMINISTRATIVA, CONTABILIDAD Y FINANZAS,  TECNICO EN ASESORIA COMERCIAL Y OPERACIONES  DE ENTIDADES FINANCIERAS. FORMACION COMPLEMENTARIA AFIN.  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(102,'Prestar servicios profesionales de carácter temporal como instructor  y apoyo a la gestión del emprendimiento rural, para crear y fortalecer unidades productivas rurales sostenibles y demás áreas de su competencia, realizando acciones de formación y de acompañamiento técnico para el desarrollo empresarial rural, en las areas de Emprendedor en gastronomía típica rural   Emprendedores en gastronomía típica de la región  Emprendedor en preparación de platos típicos  Emprendedor en cocina  Emprendedor en servicios gastronómico  en el marco de los lineamientos del Programa Sena Emprende Rurales-SER del Centro de Biotecnología Industrial.'),(103,'Prestar los servicios personales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACION COMPLEMENTARIA EN COCINA - PREPARACION DE SALSAS BÁSICAS PARA LA COCINA CALIENTE - COCINA INTERNACIONAL en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(104,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Educación económica y financiera para la formación básica en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(105,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  AREAS  BASICAS  Y/O TRANSVERSALES y SEGUIMIENTO A LAS ACTIVIDADES DE FORMACION EN LA ETAPA PRACTICA DE LOS APRENDICES del fondo de industria de la construcción FIC en la modalidad de periodos temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(106,'Prestar los servicios profesionales de carácter temporal, para la ejecución de acciones de formación para Población Desplazada en el área de Complementario en Emprendimiento y formulación de proyectos en la modalidad periodo temporal en el Centro de Biotecnología Industrial del SENA Regional Valle'),(107,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de   FORMACION COMPLEMENTARIA EN TEJIDOS EN CROCHET Y MACRAME, MUÑEQUERÍA Y ARREGLOS NAVIDEÑOS NIVEL BÁSICO, BORDADOS EN CINTAS, BORDADOS DESHILADOS, EMPRENDEDOR DE ARTES Y OFICIOS MACRAME en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(108,'Prestación temporal de servicios personales para apoyo técnico a los  Componentes Estratégico de Equidad e igualdad de Oportunidades y  Componente Estratégico de Responsabilidad Social'),(109,'Prestación temporal de servicios personales, para realizar las actividades de atención e información oportuna, confiable y pertinente a los clientes y usuarios de los servicios  del centro de  manera personal y telefónica, con base en el portafolio de servicios, la programación específica de acciones  del Centro, las políticas institucionales y la normatividad vigente, registrando información de atención, solicitudes y quejas en las bases de datos institucionales del Centro de Biotecnología Industrial del SENA Regional Valle.'),(110,'Prestación temporal de servicios personales, para el desarrollo de las actividades propias de los ambientes de aprendizaje de biotecnología, correspondientes al proceso de almacén, control de inventarios, preparación de Practicas al igual que la logística necesaria para el funcionamiento de los ambientes de aprendizaje en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(111,'Prestación temporal de servicios personales, de apoyo a la gestión para actividades administrativas de la coordinación académica  en los procesos de evaluación y seguimiento de los aprendices del Centro de Biotecnología Industrial del SENA Regional Valle.'),(112,'Prestación temporal de servicios profesionales, de carácter temporal para apoyar la implementación y mantenimiento de los Sub-sistemas de Gestión Ambiental del Centro de Biotecnología Industrial y las sedes adscritas a éste - Regional Valle.'),(113,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en  Áreas  básicas  y/o transversales en ética - talento humano -  recursos humanos en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(114,'Prestación temporal de servicios personales como evaluadores competencias laborales, para evaluar la competencia laboral de acuerdo con el procedimiento de evaluación y certificación de competencias laborales del SENA en el área de Transporte en el Centro de Biotecnología Industrial del SENA Regional Valle'),(115,'Prestación temporal de servicios personales como evaluadores competencias laborales, para evaluar la competencia laboral de acuerdo con el procedimiento de evaluación y certificación de competencias laborales del SENA en el área de  Minería/maquinaria pesada en el Centro de Biotecnología Industrial del SENA Regional Valle'),(116,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Tecnólogo Tecnólogo EN GESTION LOGISTICA, TECNICO EN LOGISTICA EMPRESARIAL,  DESARROLLO DE OPERACIONES LOGISTICAS en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(117,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en  Áreas  básicas  y/o transversales en Técnico en Sistemas, mantenimiento de equipos de cómputo, diseño e integración de multimedia en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(118,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Tecnólogo EN GESTIÓN DE MERCADOS, GESTION COMERCIAL DE SERVICIOS, DIRECCION DE VENTAS, GESTIÓN ADMINISTRATIVA, GESTIÓN DOCUMENTAL.  TECNICO EN VENTAS DE PRODUCTOS Y SERVICIOS Y DE OPERACIONES COMERCIALES. FORMACION COMPLEMENTARIA AFIN en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(119,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de  AREAS  BASICAS  Y/O TRANSVERSALES EN CULTURA FISICA  EN PROGRAMAS DE FORMACION TITULADA.  FORMACION COMPLEMENTARIA AFIN. en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(120,'Prestación temporal de servicios personales como auxiliar de laboratorio para soportar proyectos de investigación del Grupo de Investigación e Innovación en Biotecnología'),(121,'Prestación temporal de servicios personales para apoyar el proceso de Gestión de la Innovación y la Competitividad de acuerdo con los lineamientos establecidos por el SENA bajo el proyecto modelo de adaptación al cambio climático'),(122,'Prestación temporal de servicios personales para apoyar al trabajador oficial en el mantenimiento preventivo y correctivo de las sedes del  Centro de Biotecnología Industrial del SENA Regional Valle.'),(123,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de Tecnólogo EN GESTIÓN DE LA PRODUCCION, TECNICO EN  SEGURIDAD OCUPACIONAL, SALUD OCUPACIONAL (TECNICA Y TRANSVERSAL) FORMACION COMPLEMENTARIA AFIN Y DE TRABAJO SEGURO EN ALTURAS  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(124,'Prestación temporal de servicios personales como evaluadores competencias laborales, para evaluar la competencia laboral de acuerdo con el procedimiento de evaluación y certificación de competencias laborales del SENA en el área de Azúcar y Biocombustibles, para el proyecto especial de Corteros de Caña del Centro de Biotecnología Industrial del SENA Regional Valle - Competencia a evaluar 290802027 Alistar caña de azúcar de acuerdo con programa de cosecha y Normas de calidad.'),(125,'Prestar los servicios profesionales de carácter temporal, para impartir formación profesional, asistencia técnica, asesoría a las empresas y/o jornadas de divulgación tecnológica para la ejecución de las acciones de Formación en el Programa Articulación con la Media en  Áreas  básicas  y/o transversales en Técnico en asistencia en organización de archivos, Asistencia administrativa, formación complementaria afín en la modalidad de periodos temporales, programadas por el Centro de Biotecnología Industrial.'),(126,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACION TITULADA  EN GESTION DEL TALENTO HUMANO, GESTION ADMINISTRATIVA, DIRECCION DE VENTAS. TECNICO EN  RECURSOS HUMANOS, VENTA DE PRODUCTOS Y SERVICIOS. FORMACION COMPLEMENTARIA EN ÁREAS AFINES  en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.'),(127,'Prestar los servicios de apoyo para la Agencia Pública de Empleo, con el fin de desarrollar las actividades que conllevan a cumplir con los procesos relacionados con la atención de los servicios de intermediación laboral que se brindan a través de la APE, a buscadores de empleo, victimas del desplazamiento por la violencia, poblaciones vulnerables y empresarios del Centro de Biotecnología Industrial.'),(128,'Prestar los servicios profesionales de carácter temporal, para desarrollar la formación profesional en el (os) programa (s) de FORMACIÓN COMPLEMENTARIA EN SEGURIDAD VIAL,  FORMULACION DEL PLAN ESTRATEGICO DE SEGURIDAD VIAL, ESTRUCTURACION DEL PLAN ESTRATEGICO DE SEGURIDAD VIAL, NORMATIVIDAD EN TRANSITO Y SEGURIDAD VIAL en la modalidad de Periodos Temporales en el Centro de Biotecnología Industrial del SENA Regional Valle.');
/*!40000 ALTER TABLE `objeto_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pension`
--

DROP TABLE IF EXISTS `pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pension` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pension`
--

LOCK TABLES `pension` WRITE;
/*!40000 ALTER TABLE `pension` DISABLE KEYS */;
INSERT INTO `pension` (`id`, `nombre`, `activo`) VALUES (1,'PROTECCION',1),(2,'COLPENSIONES',1),(3,'OLD MUTUAL',1),(4,'PENSIONADO COLPENSIONES',1),(5,'PORVENIR',1),(6,'PROTECCION',1);
/*!40000 ALTER TABLE `pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polizas`
--

DROP TABLE IF EXISTS `polizas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `polizas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_poliza` varchar(20) DEFAULT NULL,
  `fecha_poliza` date DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `aseguradora_id` int(11) NOT NULL,
  `usuarios_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_polizas_aseguradora1_idx` (`aseguradora_id`),
  KEY `fk_polizas_usuarios1_idx` (`usuarios_id`),
  CONSTRAINT `fk_polizas_aseguradora1` FOREIGN KEY (`aseguradora_id`) REFERENCES `aseguradora` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_polizas_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polizas`
--

LOCK TABLES `polizas` WRITE;
/*!40000 ALTER TABLE `polizas` DISABLE KEYS */;
/*!40000 ALTER TABLE `polizas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `descripcion`, `activo`) VALUES (1,'CONTRATISTA',1),(2,'SUPERVISOR',1),(3,'ADMINISTRADOR',1),(4,'COORDINADOR ACADEMICO',1),(5,'Subdirector de Centro',1),(6,'El Coordinador de Administración Educativa',1),(7,'La Coordinadora Administrativa',1),(8,'La Coordinadora del Grupo Formación Integral,  Promoción y  Relaciones Corporativas',1),(9,'Metodologa',1);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_contrato`
--

DROP TABLE IF EXISTS `tipos_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_contrato` (
  `id` varchar(8) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_contrato`
--

LOCK TABLES `tipos_contrato` WRITE;
/*!40000 ALTER TABLE `tipos_contrato` DISABLE KEYS */;
INSERT INTO `tipos_contrato` (`id`, `descripcion`, `activo`) VALUES ('CI','CONTRATACION DE INSTRUCTORES',1),('SPGBA','SERVICIOS PERSONALES - GASTOS BIENESTAR APRENDICES',1),('SPI','SERVICIOS PERSONALES INDIRECTOS',1),('TV','TUTORES VIRTUALES',1);
/*!40000 ALTER TABLE `tipos_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_documento`
--

DROP TABLE IF EXISTS `tipos_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_documento` (
  `id` varchar(5) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_documento`
--

LOCK TABLES `tipos_documento` WRITE;
/*!40000 ALTER TABLE `tipos_documento` DISABLE KEYS */;
INSERT INTO `tipos_documento` (`id`, `descripcion`) VALUES ('CC','CEDULA'),('CE','CEDULA EXTRANJERIA'),('O','OTRO');
/*!40000 ALTER TABLE `tipos_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_documento` varchar(20) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `nombres_completos` varchar(100) DEFAULT NULL,
  `sexo` varchar(2) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `email_personal` varchar(60) DEFAULT NULL,
  `email_institucional` varchar(60) DEFAULT NULL,
  `telefono_fijo` varchar(20) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `tipos_documento_id` varchar(5) DEFAULT NULL,
  `eps_id` int(11) DEFAULT NULL,
  `pension_id` int(11) DEFAULT NULL,
  `ciudades_id` int(11) DEFAULT NULL,
  `arl_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuarios_tipos_documento1_idx` (`tipos_documento_id`),
  KEY `fk_usuarios_eps1_idx` (`eps_id`),
  KEY `fk_usuarios_pension1_idx` (`pension_id`),
  KEY `fk_usuarios_ciudades1_idx` (`ciudades_id`),
  KEY `fk_usuarios_arl1_idx` (`arl_id`),
  CONSTRAINT `fk_usuarios_arl1` FOREIGN KEY (`arl_id`) REFERENCES `arl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_ciudades1` FOREIGN KEY (`ciudades_id`) REFERENCES `ciudades` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_eps1` FOREIGN KEY (`eps_id`) REFERENCES `eps` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_pension1` FOREIGN KEY (`pension_id`) REFERENCES `pension` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_tipos_documento1` FOREIGN KEY (`tipos_documento_id`) REFERENCES `tipos_documento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=222 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_has_roles`
--

DROP TABLE IF EXISTS `usuarios_has_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios_has_roles` (
  `usuarios_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  PRIMARY KEY (`usuarios_id`,`roles_id`),
  KEY `fk_usuarios_has_roles_roles1_idx` (`roles_id`),
  KEY `fk_usuarios_has_roles_usuarios1_idx` (`usuarios_id`),
  CONSTRAINT `fk_usuarios_has_roles_roles1` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_roles_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_has_roles`
--

LOCK TABLES `usuarios_has_roles` WRITE;
/*!40000 ALTER TABLE `usuarios_has_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_has_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-29 15:47:05
