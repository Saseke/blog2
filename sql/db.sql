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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'排序','一.排序： \n第一种排序：插入排序 \n运行时间问题： \n1.输入本身： \n2.输入的规模 \n运行时间上界 \n最坏情况： \n时间：1.取决于计算机 \n平均情况： \n最好情况： \n2.渐近分析： \n1）.基本思路： \n忽略掉那些依赖机器的常量，不是检查其实际的运行时间，而是关注运行时间的增长T(n) n->无穷大 \n2).渐近符号： \ntheta:写个公式，丢弃它的低阶项，，并且忽略前面的常数因子 \nEx 3*x^3+x^2+x+1=theta(x^3) \n3.插入排序最坏的情况： \n最大的元素占首，最小的元素占尾 \n算数级数 \n插入排序对于n较小时，比较快，但是n很大时，就不是了 \n第二种排序：归并排序 \n步骤： \n1.if n=1,done \n2.递归的对A[1,n/2向上取整]，A[n/2+1向上取整，n]这部分排序 \n3.把排好序的两个表归并 \n其运算结果：theta(nlg(n))当取无穷大时，将小于n^2','yoke','2017-12-05 15:22:29','2017-12-05 15:22:35',12,1,1),(2,' linux-配置java，mysql','一。配置java环境变量 \n1.下载jdk \nwget –no-check-certificate –no-cookies –header “Cookie: oraclelicense=accept-securebackup-cookie” http://download.oracle.com/otn-pub/java/jdk/8u144-b01/090f390dda5b47b9b721c7dfaa008135/jdk-8u144-linux-x64.tar.gz\n\n2.配置java环境变量 \nexport JAVA_HOME=/etc/jdk 根据jdk下载的路径不同，写法不同 \nexport PATH=JAVAHOME/bin:PATH \nexport CLASSPATH=.:JAVAHOME/lib/dt.jar:JAVA_HOME/lib/tools.jar \n二.配置mysql的编码问题 \nvi /etc/my.cnf \n在[client]下添加\n\ndefault-charater-set=utf8\n\n在[mysqld]下添加 \ncollation_server = utf8_general_ci \ncharacter_set_server = utf8\n\n保存退出后重启mysqld： \nservice mysqld restart','yoke','2017-12-07 03:18:32','2017-12-07 03:18:34',0,1,1),(3,'Git-分支管理','1.查看分支： \ngit branch \n2.创建分支 \ngit branch \n3.切换分支 \ngit checkout \n4.创建和切换分支： \ngit checkout -b \n5.合并某分支到当前分支 \ngit merge \n6.删除分支： \ngit branch -d \n7.Git无法自动合并分支时，用git log –gtaph命令可以看到分支合并图','yoke','2017-12-07 03:19:54','2017-12-07 03:19:56',0,1,1),(4,'递归函数','一,大O符号：定上界\n	f(n)=O(g(n)) means:\n	假设f(n)非负\n	有常熟c>0,n0>0使得0<f(n)<=c*g(n),对于充分大的n成立\n	类似于f(n)属于g(n)构成的函数集合，定义O(g(n))为一个函数集合，集合内的函数记作f(n):  O(g(n))={f(n):有常数c>0 and n0>0使得f(n)以0和c*g(n)为界}\n	举例：2n^2=O(n^3) 大O粗略的说就是小于等于,理解：2n^2属于函数集合O(n^3)\n	另一个角度来看：\n	f(n)=O(g(n))中=并不对称 O(n^3)!=n^2\n二.大O符号精妙的用法：\n	把它当作宏来用\n	有些大O符号置于更一般的表达式右侧的大O符号就会更有用处\n	比如：f(n)=n^3+O(n^2)  表示了一个误差界限\n	存在某个函数h(n)在函数集O(n^2)中使得f(n)=n^3+h(n),总的来说，有些低阶项以某个常数乘以n^2为上界，对于足够大 的n成立\n	大O出现等式的左边\n	Ex: n^2+O(n)=O(n^2)  等号上边的线比下边的线要长一些\n	从左到右：任何n^2=O(n)都是O(n^2),反之就不是\n三：大Ω符号：\n	Ω（g(n))={f(n):存在常数：c>0,n0>0使得：0<=c*g(n)<=f(n)} 对所有的n>n0成立\n	Ex:n的平方根=Ω(lgn):  对于充分大的n,根号n至少是lgn的常数倍\n四：渐近世界的类似符号，只是忽略的系数，和低阶项：\n	Θ（g(n)=O(g(n))且Ω（g(n)） 两个集合的交集\n五：严格符号：\n	o和ω\n   o:大致相当于小于而ω大致相当于大于	\n     他们与O与Ω的区别在于：不是存在某个常数c和n0,而是对于任意的常数c都存在一个常数n0 函数f和g之间的关系要对所有的c成立\n  Ex:2n^2=o(n^3)  \n      忽略常数，当n足够大时，n^2总是小于n^3\n六.解决递归式\n  1.代换法：\n      step1:  guess answer,不需要猜出常数系数 确切的值\n  2.验证这个递归式按照数学归纳法满足条件\n  3.从那可以容易的获得常数系数，设法找出什么系数，可以使问题成立\n   Ex:T(n)=4*T(n/2)+n\n     猜是n2:\n    Guess:   T(n)=O(n^3)\n   assume: T(k)<=c*k^3 对于：k<n\n  -T(n)=4*T(n/2)+n \n       <=4*c(n/2)^3+n\n       =1/2*c*n^3+n\n       =c*n^3-(1/2*c*n^3-n)\n	  desired    residue\n	为了让c*n^3成为最大值必须保证residue是非负的  \n       <=c*n^3  ，1/2*c*n^3-n>=0 \n          c>=2;n>1=1\n base:T(1)=Θ（1）<=c  ,c要取至少很大的值\n   -更加好的假设\n   -T(k)<c1*k^2-c2*k,对于k<n\n   T(n)=4*T(n/2)+n\n       =4(c1*(n/2)^2-c2*(n/2))+n\n       =c1*n^2+(1-2*c2)*n\n       =c1*n^2-c2*n-(-1+c2)*n     \n   同样需要residue非负\n  2.递归树法\n  Ex: T(n)=T(n/4)+T(n/2)+n^2\n\n     叶子节点数不超过n\n 求法：一层一层的求和\n  3.主方法：\n   限制：只能应用到特别的递归式上 T(n)=a*T(n/b)+f(n),a>=1至少递归一次b要严格大于1 ,f(n)函数要满足一些性质法f(n)渐近趋正（存在某特定的n0,当n>=n0时f(n)>=0）\n   最简单的思路：比较非递归函数f(n)和函数n^logb(a)(它是递归树叶节点的数量)\n case1:(<)   f(n)=O(n^logb(a)-epsilon) for some epsilon>0\n        =>T(n)=Θ(n^logb(a))\n case2:(接近相等) f(n)=Θ(n^logb(a)*lg(n)^k) for some k>=0\n	=> T(n)=Θ(n^logb(a)*lg(k+1)^n)\n\n  case3 (大于): f(n)=Ω(n^logb(a)+ε)  for some: ε>0\n       =>T(n)=Θ(f(n))\n   Ex:  T(n)=4*T(n/2)+n\n       step1: 先求n^logb(a)=n^2\n       step2: f(n)<n^2;case1\n       step3:  求出T(n)=Θ(n^2)\n\n\n','yoke','2017-12-10 07:26:24','2017-12-10 07:26:26',NULL,1,1);
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

-- Dump completed on 2017-12-10 17:04:59
