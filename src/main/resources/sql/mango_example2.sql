/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80013
Source Host           : 127.0.0.1:3306
Source Database       : mango_example2

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-26 20:04:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '文章标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '文章内容',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '作者',
  `update_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('2519962548', '5', '1000', '1');
INSERT INTO `t_order` VALUES ('3625170068', '8', '1000', '1');
INSERT INTO `t_order` VALUES ('7512165246', '2', '1000', '1');

-- ----------------------------
-- Table structure for t_order_0
-- ----------------------------
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_0
-- ----------------------------
INSERT INTO `t_order_0` VALUES ('1200695343982', '14', '1000', '1');
INSERT INTO `t_order_0` VALUES ('1205982135996', '11', '1000', '1');
INSERT INTO `t_order_0` VALUES ('5453022558', '5', '1000', '1');
INSERT INTO `t_order_0` VALUES ('5690820121', '2', '1000', '1');

-- ----------------------------
-- Table structure for t_order_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_1
-- ----------------------------
INSERT INTO `t_order_1` VALUES ('0284668870', '30005', '1000', '1');
INSERT INTO `t_order_1` VALUES ('1211339913979', '30011', '1000', '1');
INSERT INTO `t_order_1` VALUES ('1211761423312', '30008', '1000', '1');
INSERT INTO `t_order_1` VALUES ('1552835824', '30002', '1000', '1');
