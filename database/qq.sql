/*
Navicat MySQL Data Transfer

Source Server         : qq
Source Server Type    : MySQL
Source Server Version : 80016
Source Host           : localhost:3306
Source Schema         : qqmysql

Target Server Type    : MySQL
Target Server Version : 80016
File Encoding         : 65001

Date: 12/05/2022 16:46:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for anam
-- ----------------------------
DROP TABLE IF EXISTS `anam`;
CREATE TABLE `anam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qq` int(11) NOT NULL,
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Staid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of anam
-- ----------------------------

-- ----------------------------
-- Table structure for animalyearinfo
-- ----------------------------
DROP TABLE IF EXISTS `animalyearinfo`;
CREATE TABLE `animalyearinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `animalyear` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of animalyearinfo
-- ----------------------------
INSERT INTO `animalyearinfo` VALUES (1, '龙');
INSERT INTO `animalyearinfo` VALUES (2, '虎');
INSERT INTO `animalyearinfo` VALUES (3, '兔');
INSERT INTO `animalyearinfo` VALUES (4, '鼠');
INSERT INTO `animalyearinfo` VALUES (5, '狗');
INSERT INTO `animalyearinfo` VALUES (6, '牛');
INSERT INTO `animalyearinfo` VALUES (7, '马');
INSERT INTO `animalyearinfo` VALUES (8, '蛇');
INSERT INTO `animalyearinfo` VALUES (9, '猪');
INSERT INTO `animalyearinfo` VALUES (10, '猴');
INSERT INTO `animalyearinfo` VALUES (11, '鸡');
INSERT INTO `animalyearinfo` VALUES (12, '羊');

-- ----------------------------
-- Table structure for bloodtypeinfo
-- ----------------------------
DROP TABLE IF EXISTS `bloodtypeinfo`;
CREATE TABLE `bloodtypeinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bloodtype` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bloodtypeinfo
-- ----------------------------
INSERT INTO `bloodtypeinfo` VALUES (1, '1');
INSERT INTO `bloodtypeinfo` VALUES (2, 'A型');
INSERT INTO `bloodtypeinfo` VALUES (3, 'B型');
INSERT INTO `bloodtypeinfo` VALUES (4, 'AB型');
INSERT INTO `bloodtypeinfo` VALUES (5, 'O型');

-- ----------------------------
-- Table structure for friendshippolicyinfo
-- ----------------------------
DROP TABLE IF EXISTS `friendshippolicyinfo`;
CREATE TABLE `friendshippolicyinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `friendshippolicy` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friendshippolicyinfo
-- ----------------------------
INSERT INTO `friendshippolicyinfo` VALUES (1, '1');
INSERT INTO `friendshippolicyinfo` VALUES (2, '允许任何人加我为好友');
INSERT INTO `friendshippolicyinfo` VALUES (3, '需要身份验证才能把我加为好友');
INSERT INTO `friendshippolicyinfo` VALUES (4, '不允许任何人加我为好友');

-- ----------------------------
-- Table structure for friendsinfo
-- ----------------------------
DROP TABLE IF EXISTS `friendsinfo`;
CREATE TABLE `friendsinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hostid` int(11) NOT NULL,
  `friendid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friendsinfo
-- ----------------------------
INSERT INTO `friendsinfo` VALUES (1, 10000, 10002);

-- ----------------------------
-- Table structure for messagesinfo
-- ----------------------------
DROP TABLE IF EXISTS `messagesinfo`;
CREATE TABLE `messagesinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromuserid` int(11) NOT NULL,
  `touserid` int(11) NOT NULL,
  `message` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `messagetypeid` int(11) NOT NULL,
  `messagestate` int(11) NOT NULL,
  `messagedate` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `messagetypeid`(`messagetypeid` ASC) USING BTREE,
  CONSTRAINT `messagesinfo_ibfk_1` FOREIGN KEY (`messagetypeid`) REFERENCES `messagetypeinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messagesinfo
-- ----------------------------

-- ----------------------------
-- Table structure for messagetypeinfo
-- ----------------------------
DROP TABLE IF EXISTS `messagetypeinfo`;
CREATE TABLE `messagetypeinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `messagetype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messagetypeinfo
-- ----------------------------
INSERT INTO `messagetypeinfo` VALUES (1, '聊天消息');
INSERT INTO `messagetypeinfo` VALUES (2, '抖动窗口消息');
INSERT INTO `messagetypeinfo` VALUES (3, '系统消息');

-- ----------------------------
-- Table structure for questioninfo
-- ----------------------------
DROP TABLE IF EXISTS `questioninfo`;
CREATE TABLE `questioninfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questioninfo
-- ----------------------------
INSERT INTO `questioninfo` VALUES (1, '你母亲的姓名是什么？');
INSERT INTO `questioninfo` VALUES (2, '你父亲的姓名是什么？');
INSERT INTO `questioninfo` VALUES (3, '你高中的班主任姓什么？');
INSERT INTO `questioninfo` VALUES (4, '你的男(女)朋友是谁？');
INSERT INTO `questioninfo` VALUES (5, '你尔今的配偶是谁？');
INSERT INTO `questioninfo` VALUES (6, '你高三的数学老师是谁？');
INSERT INTO `questioninfo` VALUES (7, '你母亲的生日是多少？');
INSERT INTO `questioninfo` VALUES (8, '你父亲的生日是多少？');
INSERT INTO `questioninfo` VALUES (9, '你最讨厌什么样的人？');
INSERT INTO `questioninfo` VALUES (10, '你最喜欢做的事是什么？');

-- ----------------------------
-- Table structure for starinfo
-- ----------------------------
DROP TABLE IF EXISTS `starinfo`;
CREATE TABLE `starinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `star` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of starinfo
-- ----------------------------
INSERT INTO `starinfo` VALUES (1, '1');
INSERT INTO `starinfo` VALUES (2, '白羊座');
INSERT INTO `starinfo` VALUES (3, '双鱼座');
INSERT INTO `starinfo` VALUES (4, '双子座');
INSERT INTO `starinfo` VALUES (5, '金牛座');
INSERT INTO `starinfo` VALUES (6, '天蝎座');
INSERT INTO `starinfo` VALUES (7, '处女座');
INSERT INTO `starinfo` VALUES (8, '射手座');
INSERT INTO `starinfo` VALUES (9, '狮子座');
INSERT INTO `starinfo` VALUES (10, '巨蝎座');
INSERT INTO `starinfo` VALUES (11, '天秤座');
INSERT INTO `starinfo` VALUES (12, '水瓶座');
INSERT INTO `starinfo` VALUES (13, '魔羯座');

-- ----------------------------
-- Table structure for stateinfo
-- ----------------------------
DROP TABLE IF EXISTS `stateinfo`;
CREATE TABLE `stateinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stateinfo
-- ----------------------------
INSERT INTO `stateinfo` VALUES (1, '下线');
INSERT INTO `stateinfo` VALUES (2, '在线');
INSERT INTO `stateinfo` VALUES (3, '工作中');
INSERT INTO `stateinfo` VALUES (4, 'Q我吧');
INSERT INTO `stateinfo` VALUES (5, '隐身');
INSERT INTO `stateinfo` VALUES (6, '离开');
INSERT INTO `stateinfo` VALUES (7, '忙碌');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL  AUTO_INCREMENT,
  `loginpwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci ,
  `friendshippolicyid` int(11) NOT NULL DEFAULT 1,
  `nickname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci ,
  `faceid` int(11) NOT NULL DEFAULT 0,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci ,
  `age` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci ,
  `bloodtypeid` int(11) NULL DEFAULT 1,
  `starid` int(11) NULL DEFAULT 1,
  `animalyearid` int(11) NULL DEFAULT 1,
  `address` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci ,
  `stateid` int(11) NULL DEFAULT 1,
  `questionid` int(11) NULL DEFAULT NULL,
  `answer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `friendshippolicyid`(`friendshippolicyid` ASC) USING BTREE,
  INDEX `bloodtypeid`(`bloodtypeid` ASC) USING BTREE,
  INDEX `starid`(`starid` ASC) USING BTREE,
  INDEX `animalyearid`(`animalyearid` ASC) USING BTREE,
  INDEX `stateid`(`stateid` ASC) USING BTREE,
  INDEX `questionid`(`questionid` ASC) USING BTREE,
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`friendshippolicyid`) REFERENCES `friendshippolicyinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userinfo_ibfk_2` FOREIGN KEY (`bloodtypeid`) REFERENCES `bloodtypeinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userinfo_ibfk_3` FOREIGN KEY (`starid`) REFERENCES `starinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userinfo_ibfk_4` FOREIGN KEY (`animalyearid`) REFERENCES `animalyearinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userinfo_ibfk_5` FOREIGN KEY (`stateid`) REFERENCES `stateinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userinfo_ibfk_6` FOREIGN KEY (`questionid`) REFERENCES `questioninfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (10000, '813813', 1, '蝶恋花', 49, '男', 15, '董', 1, 3, 1, '六里坪', 1, 3, '813');
INSERT INTO `userinfo` VALUES (10001, '520520', 1, '蝶之舞', 1, '女', 17, '郑', 2, 1, 6, '中南海', 1, 5, '王');

SET FOREIGN_KEY_CHECKS = 1;
