/*
Navicat MySQL Data Transfer

Source Server         : xcsadsffdsfad
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : j19051

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2019-08-02 13:53:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'java基础');
INSERT INTO `category` VALUES ('2', '面向对象设计模拟');
INSERT INTO `category` VALUES ('3', '设计原则');
INSERT INTO `category` VALUES ('4', 'spring');
INSERT INTO `category` VALUES ('5', '论语');
INSERT INTO `category` VALUES ('6', '大学');
INSERT INTO `category` VALUES ('7', '周易');

-- ----------------------------
-- Table structure for `clazz`
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `major` char(20) NOT NULL,
  `begin_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('2', '小二班', '情歌', '2019-07-26');
INSERT INTO `clazz` VALUES ('7', 'java班', '二B专业', '2019-07-26');
INSERT INTO `clazz` VALUES ('11', '嵌入式班', '驱动开发', '2019-07-29');
INSERT INTO `clazz` VALUES ('13', '周易班', '国学', '2019-07-30');
INSERT INTO `clazz` VALUES ('15', 'J2EE', 'java高级工程师', '2019-07-30');

-- ----------------------------
-- Table structure for `examination`
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `clazz_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `subject_num` int(11) NOT NULL DEFAULT '20',
  `begin_time` datetime NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  `category` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES ('1', 'mysql数据库', '7', '1', '20', '2019-07-26 13:41:44', '2', ' {1,3,5}');
INSERT INTO `examination` VALUES ('2', 'bootstramp', '7', '1', '25', '2019-07-12 13:44:42', '2', ' {2,4}');
INSERT INTO `examination` VALUES ('3', '周易', '2', '1', '20', '2019-07-18 09:25:32', '2', '{5}');
INSERT INTO `examination` VALUES ('4', '佛学', '2', '1', '20', '2019-07-11 09:26:01', '2', '{5}');
INSERT INTO `examination` VALUES ('5', 'spring测试', '2', '1', '20', '2019-07-30 14:25:17', '2', '{5}');
INSERT INTO `examination` VALUES ('6', '论语', '2', '2', '40', '2019-07-30 14:27:32', '2', '{5}');
INSERT INTO `examination` VALUES ('7', '大学', '2', '2', '25', '2019-07-30 14:31:41', '1', '{5}');
INSERT INTO `examination` VALUES ('8', 'h5', '13', '1', '25', '2019-07-30 14:39:44', '1', ' {1,3,5}');
INSERT INTO `examination` VALUES ('9', 'spring测试', '7', '1', '20', '2019-08-01 10:02:21', '2', '{1,2,7}');
INSERT INTO `examination` VALUES ('10', 'javaEE', '7', '1', '20', '2019-08-01 10:23:19', '2', '{1,2,7}');
INSERT INTO `examination` VALUES ('11', '心里考试', '7', '1', '20', '2019-08-07 13:37:16', '1', '{1,2,7}');

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL,
  `examination_id` int(11) DEFAULT NULL,
  `examination_name` char(20) DEFAULT NULL,
  `score` float(11,0) DEFAULT NULL,
  `times` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '3', '1', 'mysql数据库', '63', '1');
INSERT INTO `grade` VALUES ('2', '3', '2', 'bootstramp', '70', '1');
INSERT INTO `grade` VALUES ('4', '3', '10', 'javaEE', '25', '1');
INSERT INTO `grade` VALUES ('5', '3', '10', 'javaEE', '50', '2');
INSERT INTO `grade` VALUES ('6', '3', '10', 'javaEE', '20', '3');
INSERT INTO `grade` VALUES ('7', '4', '10', 'javaEE', '25', '2');
INSERT INTO `grade` VALUES ('8', '3', '10', 'javaEE', '5', '4');
INSERT INTO `grade` VALUES ('9', '8', '11', '心里考试', '10', '1');
INSERT INTO `grade` VALUES ('10', '8', '11', '心里考试', '15', '2');

-- ----------------------------
-- Table structure for `stu`
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` char(20) NOT NULL,
  `name` char(20) NOT NULL,
  `sex` char(3) NOT NULL,
  `pwd` char(16) NOT NULL,
  `clazz_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('1', '007', '小明', '女', '123456', '2');
INSERT INTO `stu` VALUES ('2', '008', '小华', '男', '123456', '2');
INSERT INTO `stu` VALUES ('3', '2564781', 'wangg', '男', '123456', '7');
INSERT INTO `stu` VALUES ('4', '9528882', '周文王', '男', '123456', '2');
INSERT INTO `stu` VALUES ('5', '9528883', '列宁', '男', '123456', '2');
INSERT INTO `stu` VALUES ('6', '123456', '光荣', '女', '123456', '7');
INSERT INTO `stu` VALUES ('7', '9528885', '红麟', '男', '123456', '7');
INSERT INTO `stu` VALUES ('8', '9528886', '侯哥哥', '男', '123456', '7');
INSERT INTO `stu` VALUES ('9', '9528887', 'xx5', '男', '123456', '7');
INSERT INTO `stu` VALUES ('10', '9528888', 'xx6', '男', '123456', '7');

-- ----------------------------
-- Table structure for `subject`
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `itema` varchar(255) NOT NULL,
  `itemb` varchar(255) NOT NULL,
  `itemc` varchar(255) NOT NULL,
  `itemd` varchar(255) NOT NULL,
  `answer` char(3) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '道家根据什么', '心', '天', '地', '自然', 'D', '2');
INSERT INTO `subject` VALUES ('2', '佛家根据什么', '心', '道', '天地', '神仙', 'A', '2');
INSERT INTO `subject` VALUES ('3', 'dsfds', 'dfsfd', 'dfsdfs', 'dsfdfs', 'd', 'B', '2');
INSERT INTO `subject` VALUES ('4', 'dsf', 'df', 'dsf', 'fd', 'fd', 'c', '2');
INSERT INTO `subject` VALUES ('5', 'fda', 'df', 'fds', 'dfs', 'df', 'B', '2');
INSERT INTO `subject` VALUES ('6', 'ddf', 'dfdf', 'dffd', 'dfdf', 'dfdf', 'A', '2');
INSERT INTO `subject` VALUES ('7', 'df', 'df', 'dffd', 'dfdf', 'df', 'A', '1');
INSERT INTO `subject` VALUES ('8', 'dfafd', 'df', 'dfd', 'df', 'df', 'A', '1');
INSERT INTO `subject` VALUES ('9', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '1');
INSERT INTO `subject` VALUES ('10', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '1');
INSERT INTO `subject` VALUES ('11', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('12', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('13', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('14', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('15', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('16', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('17', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('18', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('19', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('20', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('21', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('22', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '7');
INSERT INTO `subject` VALUES ('23', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '7');
INSERT INTO `subject` VALUES ('24', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('25', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('26', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('27', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '7');
INSERT INTO `subject` VALUES ('28', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('29', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '7');
INSERT INTO `subject` VALUES ('30', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('31', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '7');
INSERT INTO `subject` VALUES ('32', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('33', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('34', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('35', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('36', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('37', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');
INSERT INTO `subject` VALUES ('38', '古代中国是什么意思', '国家', '国家的中心', '文化中心', '中原', 'C', '2');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` char(20) NOT NULL,
  `name` char(20) NOT NULL,
  `sex` char(3) NOT NULL,
  `pwd` char(16) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '9527', '明明', '男', '123456');
INSERT INTO `teacher` VALUES ('2', '9528', '王老师', '男', '123456');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(200) DEFAULT NULL,
  `password` char(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
