/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.28 : Database - yuxiuhui
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yuxiuhui` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `yuxiuhui`;

/*Table structure for table `base_member` */

DROP TABLE IF EXISTS `base_member`;

CREATE TABLE `base_member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信openid',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='会员';

/*Data for the table `base_member` */

insert  into `base_member`(`id`,`openid`,`nickname`,`avatar_url`,`gender`,`real_name`,`mobile`,`login_name`,`password`,`create_time`) values 
(68,'oHJGh5VMiOYpoJV9k4Ket3BH6p-E','Rainy','https://thirdwx.qlogo.cn/mmopen/vi_32/pEF7YibYkTO3SMcvariaUxfibpruKvhqiaI9WUjQwrM76KEkgjKhjJvib77KSjzUZP8nrSEAwKKlib9XmuicQLaQydPKg/132','1','林勤铭','20181002873',NULL,NULL,'2022-04-13 19:31:02'),
(69,NULL,'gege','http://localhost:10001/img/avatar.png','1','林勤铭','20181002873','GDUFS','123','2022-04-13 19:34:07');

/*Table structure for table `cms_article` */

DROP TABLE IF EXISTS `cms_article`;

CREATE TABLE `cms_article` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '摘要',
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片地址',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '内容',
  `type` tinyint DEFAULT '1' COMMENT '文章类型：1文本图片，2视频',
  `video_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '视频地址',
  `vid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '腾讯视屏vid',
  `column_id` int DEFAULT NULL COMMENT '栏目id',
  `publish_date` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='文章';

/*Data for the table `cms_article` */

insert  into `cms_article`(`id`,`title`,`summary`,`pic_url`,`content`,`type`,`video_url`,`vid`,`column_id`,`publish_date`) values 
(113,'国企专场招聘会举行 60家企业广外揽才','近日，2022年广东外语外贸大学国有企业专场招聘会在我校南校区人造草田径场举行。','http://localhost:10001/fileupload/20220414/2dfe4a1b-c658-4136-af25-0cff6454f6c2.jpeg','<p style=\"text-indent: 0px; \"><span style=\"text-indent: 37.3333px;\">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span><span style=\"color: rgb(85, 85, 85); font-family: 宋体; font-size: 18.6667px; text-indent: 37.3333px;\">本次招聘会由我校联合广州人才集团举办，吸引了中交广州航道局、建发集团、广药集团、广州轻工集团、中化广东等60家国有企业到场揽才，提供1776个就业岗位，涵盖房产建筑、IT互联网、教育、金融、服务业等类别。</span></p><p><span style=\"color: rgb(85, 85, 85); font-family: 宋体; font-size: 18.6667px; text-indent: 37.3333px;\"><span style=\"color: rgb(85, 85, 85); font-family: 宋体; font-size: 18.6667px; text-indent: 37.3333px;\">&nbsp; 学校一直以来高度重视毕业生就业工作，本次招聘会旨在促进国有企业与我校毕业生供需对接，进一步推动实现毕业生就业和国有企业人才结构优化的“双赢”局面，是学校积极落实“稳就业”工作的重要举措，同时也是我校坚持“走出去”与“请进来”相结合，深入企业走访调研，为毕业生开拓更多就业岗位和机会的“书记校长访企拓岗促就业专项行动”第一站。校党委书记、校长石佑启和副书记唐锐到现场指导并与用人单位代表亲切交流，细心地询问用人单位招聘情况，并积极向用人单位推荐我校毕业生。石佑启表示，希望双方能够多维度、深层次地开展合作，搭建合作平台，也欢迎用人单位到学校参观交流。</span></span></p><p><span style=\"color: rgb(85, 85, 85); font-family: 宋体; font-size: 18.6667px; text-indent: 37.3333px;\"><span style=\"color: rgb(85, 85, 85); font-family: 宋体; font-size: 18.6667px; text-indent: 37.3333px;\">&nbsp; 截至目前，我校针对2022届毕业生已举办线上招聘会7场，用人单位专场宣讲会260余场。学校就业信息网以及“广外就业微信公众号”已累计发布招聘信息1500余条，提供就业岗位超过2万个。接下来，学校将继续拓宽就业渠道，多措并举，搭建更多就业平台，促进毕业生更充分更高质量就业。</span></span></p>',1,NULL,NULL,NULL,'2022-04-14 17:35:50'),
(114,'校党委专题学习习近平总书记重要文章《毫不动摇 坚持和加强党的全面领导》','4月11日下午，我校在北校区行政楼第一会议室召开党委常委会，集中学习习近平总书记重要文章《毫不动摇坚持和加强党的全面领导》。','http://localhost:10001/fileupload/20220414/42cd27b1-415a-4440-be8f-c6cbe7611559.jpg','<p><span style=\"color: rgb(85, 85, 85); font-family: 宋体; font-size: 18.6667px; text-indent: 37.3333px;\">&nbsp;&nbsp;校党委书记、校长石佑启主持会议。校领导，党办、纪检监察室、组织部、统战部、宣传部、教师工作部、保卫部、学生工作部、研究生工作部、国际学院等相关单位负责人参加会议。</span></p><p style=\"padding: 0px; border-width: 0px; border-style: initial; border-color: initial; margin-top: 0px; margin-bottom: 0px; font-size: 18.6667px; line-height: 33.6px; text-indent: 37.3333px; color: rgb(85, 85, 85); font-family: 宋体; white-space: normal;\">石佑启指出，党的十九届六中全会通过的《关于党的百年奋斗重大成就和历史经验的决议》，总结出党百年奋斗的第一条宝贵经验，就是坚持党的领导。党是我们各项事业的领导核心，坚持中国共产党领导，坚持党的领导核心地位，是一切工作的前提。进入新时代，面对百年未有之大变局，面对艰巨繁重的改革发展任务，只有坚持和加强党的全面领导，才能始终保持政治定力，才能成功应对重大挑战、抵御重大风险、克服重大阻力、解决重大矛盾。石佑启就如何落实推进学校党的全面领导工作提出三点意见：一是要提高站位，深刻认识坚持和加强党的全面领导的极端重要性；二是要统筹落实，完善健全党的全面领导制度体系；三是要担当作为，推进党的全面领导落实落细见成效。</p><p class=\"vsbcontent_end\" style=\"padding: 0px; border-width: 0px; border-style: initial; border-color: initial; margin-top: 0px; margin-bottom: 0px; font-size: 18.6667px; line-height: 33.6px; text-indent: 37.3333px; color: rgb(85, 85, 85); font-family: 宋体; white-space: normal;\">党办、校办主任谢伟光对习近平总书记重要文章《毫不动摇坚持和加强党的全面领导》进行学习梳理，并从根本制度层面、领导核心层面、行动方向层面进行分析解读。他表示，踏上新征程，我们必须坚持和加强党的全面领导，充分发挥党委总揽全局、协调各方的领导核心作用，为学校建设国际化特色鲜明的高水平大学提供坚强的保障。</p><p><br/></p>',1,NULL,NULL,NULL,'2022-04-14 17:38:17'),
(115,'美丽的广外','欢迎参观我们的小区','http://localhost:10001/fileupload/20220414/9551d25f-ad20-45c4-b972-9f33bc0c75d7.jpg','<p>明德尚行，学贯中西</p>',2,'http://localhost:10001/fileupload/20220414/d431f3eb-2020-4da6-822d-52879e247773.mp4',NULL,NULL,'2022-04-14 18:37:00');

/*Table structure for table `cms_comment` */

DROP TABLE IF EXISTS `cms_comment`;

CREATE TABLE `cms_comment` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int DEFAULT NULL COMMENT '会员id',
  `article_id` int DEFAULT NULL COMMENT '文章id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '评论',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='评论';

/*Data for the table `cms_comment` */

insert  into `cms_comment`(`id`,`member_id`,`article_id`,`content`,`create_time`) values 
(22,67,105,'文章不错，值得学习','2021-02-17 18:09:04'),
(23,67,106,'文章很好','2021-02-17 21:23:41'),
(24,67,106,'你好你好','2021-02-17 21:44:39'),
(25,68,115,'壮哉我广外！','2022-04-14 18:51:06'),
(26,68,114,'坚持党的领导','2022-04-16 19:20:23');

/*Table structure for table `cms_liked` */

DROP TABLE IF EXISTS `cms_liked`;

CREATE TABLE `cms_liked` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int DEFAULT NULL COMMENT '会员id',
  `article_id` int DEFAULT NULL COMMENT '文章id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='点赞';

/*Data for the table `cms_liked` */

insert  into `cms_liked`(`id`,`member_id`,`article_id`,`create_time`) values 
(111,67,106,'2021-08-06 22:06:18'),
(112,68,115,'2022-04-14 18:47:19'),
(113,68,114,'2022-04-16 19:20:27');

/*Table structure for table `p_advert` */

DROP TABLE IF EXISTS `p_advert`;

CREATE TABLE `p_advert` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片地址',
  `enable` tinyint DEFAULT NULL COMMENT '是否启用，0：禁用，1：启用',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接',
  `sort` int DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='广告';

/*Data for the table `p_advert` */

insert  into `p_advert`(`id`,`pic_url`,`enable`,`link`,`sort`,`create_time`) values 
(8,'http://localhost:10001/fileupload/20220414/9355cd62-356f-4bd8-a2c9-fdf6a6d6cc63.jpeg',1,'',1,'2022-04-14 10:42:49'),
(9,'http://localhost:10001/fileupload/20220414/9ccffd8c-fc87-4b19-9d29-4d08ab421bb4.jpeg',1,'',2,'2022-04-14 10:43:09'),
(10,'http://localhost:10001/fileupload/20220414/0ad98e51-9812-43c6-99e6-983b79716c10.jpeg',1,'',3,'2022-04-14 10:43:24');

/*Table structure for table `p_building` */

DROP TABLE IF EXISTS `p_building`;

CREATE TABLE `p_building` (
  `id` int NOT NULL AUTO_INCREMENT,
  `building_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '楼宇名称',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='楼宇';

/*Data for the table `p_building` */

insert  into `p_building`(`id`,`building_name`,`remarks`,`create_time`) values 
(6,'广外1栋',NULL,'2022-04-13 19:43:09'),
(7,'广外2栋',NULL,'2022-04-13 19:43:18'),
(8,'广外13栋','男生宿舍','2022-04-13 19:43:33');

/*Table structure for table `p_car` */

DROP TABLE IF EXISTS `p_car`;

CREATE TABLE `p_car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int DEFAULT NULL COMMENT '用户id',
  `car_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '车牌号',
  `brand` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '汽车品牌',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='车俩';

/*Data for the table `p_car` */

insert  into `p_car`(`id`,`member_id`,`car_no`,`brand`,`create_time`) values 
(2,68,'苏A12345','玛莎拉蒂','2022-04-13 19:47:13');

/*Table structure for table `p_house` */

DROP TABLE IF EXISTS `p_house`;

CREATE TABLE `p_house` (
  `id` int NOT NULL AUTO_INCREMENT,
  `building_id` int DEFAULT NULL COMMENT '楼宇id',
  `house_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '房屋编号',
  `member_id` int DEFAULT NULL COMMENT '会员id',
  `house_type` tinyint DEFAULT NULL COMMENT '户型',
  `area` float(10,2) DEFAULT NULL COMMENT '面积',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='房屋';

/*Data for the table `p_house` */

insert  into `p_house`(`id`,`building_id`,`house_no`,`member_id`,`house_type`,`area`,`remark`,`create_time`) values 
(5,8,'A102',68,4,100.00,'广外学生','2022-04-13 19:45:50');

/*Table structure for table `p_parking` */

DROP TABLE IF EXISTS `p_parking`;

CREATE TABLE `p_parking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parking_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '车位编号',
  `car_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '车牌号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='车位';

/*Data for the table `p_parking` */

insert  into `p_parking`(`id`,`parking_no`,`car_no`,`create_time`) values 
(1,'H000001','苏A12345','2021-11-13 20:28:06'),
(2,'H000001','苏A12345','2021-11-13 20:27:55'),
(3,'H000002','苏A88888','2021-11-13 20:38:53');

/*Table structure for table `p_pay` */

DROP TABLE IF EXISTS `p_pay`;

CREATE TABLE `p_pay` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int DEFAULT NULL COMMENT '会员id',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `type` tinyint DEFAULT NULL COMMENT '类型',
  `create_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='缴费';

/*Data for the table `p_pay` */

insert  into `p_pay`(`id`,`member_id`,`amount`,`type`,`create_time`) values 
(4,69,123.00,1,'2022-04-13 20:17:04'),
(5,68,123.00,0,'2022-04-14 10:39:00'),
(6,68,321.00,1,'2022-04-14 10:39:28');

/*Table structure for table `r_repair` */

DROP TABLE IF EXISTS `r_repair`;

CREATE TABLE `r_repair` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int DEFAULT NULL COMMENT '用户id',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '地点',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '问题描述',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='报修';

/*Data for the table `r_repair` */

insert  into `r_repair`(`id`,`member_id`,`real_name`,`mobile`,`address`,`content`,`status`,`remark`,`create_time`) values 
(3,68,'林勤铭','20181002873','广外13栋337','空调不够凉快',1,NULL,'2022-04-14 14:50:05');

/*Table structure for table `r_repair_pic` */

DROP TABLE IF EXISTS `r_repair_pic`;

CREATE TABLE `r_repair_pic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `repair_id` int DEFAULT NULL,
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='报修图片';

/*Data for the table `r_repair_pic` */

insert  into `r_repair_pic`(`id`,`repair_id`,`pic_url`) values 
(1,1,'http://localhost:10001/img/goods-1.jpg'),
(2,2,'http://localhost:10001/img/goods-2.jpg'),
(3,3,'http://localhost:10001/fileupload/20220414/d7ff1dd7-c6a7-45bf-9f1b-14400f14d197.jpg'),
(4,3,'http://localhost:10001/fileupload/20220414/aef922fc-4a90-4080-86a1-43c56065b92b.jpg');

/*Table structure for table `sys_message` */

DROP TABLE IF EXISTS `sys_message`;

CREATE TABLE `sys_message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '内容',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `status` int DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='消息';

/*Data for the table `sys_message` */

insert  into `sys_message`(`id`,`title`,`content`,`user_id`,`status`,`create_time`) values 
(29,'疫情防控','请到F栋测核酸',68,1,'2022-04-13 19:51:30');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `status` tinyint DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='管理员';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`email`,`mobile`,`status`,`create_time`) values 
(2,'GDUFS','202cb962ac59075b964b07152d234b70','1508673591@qq.com','20181002873',1,'2022-04-13 19:36:38');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
