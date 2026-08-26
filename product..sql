-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--


Create database defaultdb;
--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `franchise_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `franchise_id` (`franchise_id`),
  CONSTRAINT `branch_ibfk_1` FOREIGN KEY (`franchise_id`) REFERENCES `franchise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Treyarch',1),(2,'Ubisoft Montreal',2),(3,'id Software',3);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `franchise`
--

DROP TABLE IF EXISTS `franchise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `franchise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `franchise`
--

LOCK TABLES `franchise` WRITE;
/*!40000 ALTER TABLE `franchise` DISABLE KEYS */;
INSERT INTO `franchise` VALUES (1,'Actvision'),(2,'Ubisoft'),(3,'Bethesda Softworks');
/*!40000 ALTER TABLE `franchise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `branch_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `branch_id` (`branch_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Call of Duty Black Ops',100,1),(2,'Call of Duty Black Ops 2',200,1),(4,'Call of Duty Black Ops 3',300,1),(5,'Assassins Creed 2',100,2),(6,'Assassins Creed 3',200,2),(7,'Doom Eternal',400,3),(8,'Doom: The Dark Ages',600,3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;



