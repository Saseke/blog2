-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.10.1

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text,
  `author_name` varchar(100) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL,
  `browseTime` int(11) DEFAULT NULL,
  `author_Id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `article_id_uindex` (`id`),
  KEY `article_author_id_fk` (`author_Id`),
  KEY `article_classify_id_fk` (`category_id`),
  CONSTRAINT `article_author_id_fk` FOREIGN KEY (`author_Id`) REFERENCES `author` (`id`),
  CONSTRAINT `article_classify_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'排序','一.排序： \n第一种排序：插入排序 \n运行时间问题： \n1.输入本身： \n2.输入的规模 \n运行时间上界 \n最坏情况： \n时间：1.取决于计算机 \n平均情况： \n最好情况： \n2.渐近分析： \n1）.基本思路： \n忽略掉那些依赖机器的常量，不是检查其实际的运行时间，而是关注运行时间的增长T(n) n->无穷大 \n2).渐近符号： \ntheta:写个公式，丢弃它的低阶项，，并且忽略前面的常数因子 \nEx 3*x^3+x^2+x+1=theta(x^3) \n3.插入排序最坏的情况： \n最大的元素占首，最小的元素占尾 \n算数级数 \n插入排序对于n较小时，比较快，但是n很大时，就不是了 \n第二种排序：归并排序 \n步骤： \n1.if n=1,done \n2.递归的对A[1,n/2向上取整]，A[n/2+1向上取整，n]这部分排序 \n3.把排好序的两个表归并 \n其运算结果：theta(nlg(n))当取无穷大时，将小于n^2','yoke','2017-12-05 15:22:29','2017-12-05 15:22:35',12,1,1),(2,' linux-配置java，mysql','一。配置java环境变量 \n1.下载jdk \nwget –no-check-certificate –no-cookies –header “Cookie: oraclelicense=accept-securebackup-cookie” http://download.oracle.com/otn-pub/java/jdk/8u144-b01/090f390dda5b47b9b721c7dfaa008135/jdk-8u144-linux-x64.tar.gz\n\n2.配置java环境变量 \nexport JAVA_HOME=/etc/jdk 根据jdk下载的路径不同，写法不同 \nexport PATH=JAVAHOME/bin:PATH \nexport CLASSPATH=.:JAVAHOME/lib/dt.jar:JAVA_HOME/lib/tools.jar \n二.配置mysql的编码问题 \nvi /etc/my.cnf \n在[client]下添加\n\ndefault-charater-set=utf8\n\n在[mysqld]下添加 \ncollation_server = utf8_general_ci \ncharacter_set_server = utf8\n\n保存退出后重启mysqld： \nservice mysqld restart','yoke','2017-12-07 03:18:32','2017-12-07 03:18:34',0,1,1),(3,'Git-分支管理','1.查看分支： \ngit branch \n2.创建分支 \ngit branch \n3.切换分支 \ngit checkout \n4.创建和切换分支： \ngit checkout -b \n5.合并某分支到当前分支 \ngit merge \n6.删除分支： \ngit branch -d \n7.Git无法自动合并分支时，用git log –gtaph命令可以看到分支合并图','yoke','2017-12-07 03:19:54','2017-12-07 03:19:56',0,1,1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_login_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES ('demo','csdc',1,NULL);
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `classificaiton_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'1',NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) NOT NULL,
  `content` varchar(100) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `comment_id_uindex` (`id`),
  KEY `comment_author_id_fk` (`author_id`),
  KEY `comment_article_id_fk` (`article_id`),
  CONSTRAINT `comment_article_id_fk` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `comment_author_id_fk` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-07 11:46:54
