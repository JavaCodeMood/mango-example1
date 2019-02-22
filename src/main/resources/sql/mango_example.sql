/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80013
Source Host           : 127.0.0.1:3306
Source Database       : mango_example

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-26 20:03:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `uid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `money` int(11) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '张三', '7000');
INSERT INTO `account` VALUES ('2', '李四', '3500');
INSERT INTO `account` VALUES ('3', '小花', '500');
INSERT INTO `account` VALUES ('4', '小美', '2500');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '文章标题',
  `content` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '文章内容',
  `author` varchar(50) COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '作者',
  `update_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '你好', '应用服务的数据库写请求使用主库，数据库读请求使用从库时，我们使用主从数据源工厂MasterSlaveDataSourceFactory管理数据源', '刘豆豆', '2018-12-20 20:07:05');
INSERT INTO `article` VALUES ('2', '你好', '应用服务的数据库写请求使用主库，数据库读请求使用从库时，我们使用主从数据源工厂MasterSlaveDataSourceFactory管理数据源', '刘豆豆', '2018-12-20 20:08:51');
INSERT INTO `article` VALUES ('3', '你好', '应用服务的数据库写请求使用主库，数据库读请求使用从库时，我们使用主从数据源工厂MasterSlaveDataSourceFactory管理数据源', '刘豆豆', '2018-12-20 20:12:01');

-- ----------------------------
-- Table structure for article_copy
-- ----------------------------
DROP TABLE IF EXISTS `article_copy`;
CREATE TABLE `article_copy` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '文章标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '文章内容',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci DEFAULT NULL COMMENT '作者',
  `update_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

-- ----------------------------
-- Records of article_copy
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '1', '伤心往事', '没有了你，虽有万杯觥筹，只不过是提醒寂寞罢了');

-- ----------------------------
-- Table structure for fruit
-- ----------------------------
DROP TABLE IF EXISTS `fruit`;
CREATE TABLE `fruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '水果名称',
  `num` int(11) NOT NULL COMMENT '数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `address` varchar(50) DEFAULT NULL COMMENT '产地',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fruit
-- ----------------------------
INSERT INTO `fruit` VALUES ('1', '橘子', '2000', '4.80', '湖南长沙');
INSERT INTO `fruit` VALUES ('2', '苹果', '100', '5.80', '云南昆明');
INSERT INTO `fruit` VALUES ('3', '香蕉', '200', '3.60', '云南西双版纳');
INSERT INTO `fruit` VALUES ('4', '雪梨', '340', '8.80', '天山');
INSERT INTO `fruit` VALUES ('5', '葡萄', '130', '6.40', '新疆吐鲁番');
INSERT INTO `fruit` VALUES ('6', '苹果', '100', '5.80', '云南昆明');
INSERT INTO `fruit` VALUES ('7', '香蕉', '200', '3.60', '云南西双版纳');
INSERT INTO `fruit` VALUES ('8', '雪梨', '340', '8.80', '天山');
INSERT INTO `fruit` VALUES ('9', '葡萄', '130', '6.40', '新疆吐鲁番');
INSERT INTO `fruit` VALUES ('10', '苹果', '100', '5.80', '云南昆明');
INSERT INTO `fruit` VALUES ('11', '香蕉', '200', '3.60', '云南西双版纳');
INSERT INTO `fruit` VALUES ('12', '雪梨', '340', '8.80', '天山');
INSERT INTO `fruit` VALUES ('13', '葡萄', '130', '6.40', '新疆吐鲁番');
INSERT INTO `fruit` VALUES ('14', '苹果', '100', '5.80', '云南昆明');
INSERT INTO `fruit` VALUES ('15', '香蕉', '200', '3.60', '云南西双版纳');
INSERT INTO `fruit` VALUES ('16', '雪梨', '340', '8.80', '天山');
INSERT INTO `fruit` VALUES ('17', '葡萄', '130', '6.40', '新疆吐鲁番');
INSERT INTO `fruit` VALUES ('18', '苹果', '100', '5.80', '云南昆明');
INSERT INTO `fruit` VALUES ('19', '香蕉', '200', '3.60', '云南西双版纳');
INSERT INTO `fruit` VALUES ('20', '雪梨', '340', '8.80', '天山');
INSERT INTO `fruit` VALUES ('21', '葡萄', '130', '6.40', '新疆吐鲁番');

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
INSERT INTO `t_order_0` VALUES ('1219149634', '1', '100', '1');
INSERT INTO `t_order_0` VALUES ('4788179062', '2', '100', '1');

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
INSERT INTO `t_order_1` VALUES ('6707848922', '10086', '100', '1');
INSERT INTO `t_order_1` VALUES ('6913581526', '10020', '100', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `money` bigint(21) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_nickname
-- ----------------------------
DROP TABLE IF EXISTS `user_nickname`;
CREATE TABLE `user_nickname` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) DEFAULT NULL COMMENT '用户昵称首字符（一个字母或汉子）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=610 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_nickname
-- ----------------------------
INSERT INTO `user_nickname` VALUES ('53', '缘');
INSERT INTO `user_nickname` VALUES ('54', '起');
INSERT INTO `user_nickname` VALUES ('55', '诗');
INSERT INTO `user_nickname` VALUES ('56', '离');
INSERT INTO `user_nickname` VALUES ('57', '画');
INSERT INTO `user_nickname` VALUES ('58', '这');
INSERT INTO `user_nickname` VALUES ('59', '岁');
INSERT INTO `user_nickname` VALUES ('60', '月');
INSERT INTO `user_nickname` VALUES ('61', '记');
INSERT INTO `user_nickname` VALUES ('62', '忆');
INSERT INTO `user_nickname` VALUES ('63', '章');
INSERT INTO `user_nickname` VALUES ('64', '终');
INSERT INTO `user_nickname` VALUES ('65', '时');
INSERT INTO `user_nickname` VALUES ('66', '光');
INSERT INTO `user_nickname` VALUES ('67', '无');
INSERT INTO `user_nickname` VALUES ('68', '法');
INSERT INTO `user_nickname` VALUES ('69', '触');
INSERT INTO `user_nickname` VALUES ('70', '及');
INSERT INTO `user_nickname` VALUES ('71', '红');
INSERT INTO `user_nickname` VALUES ('72', '尘');
INSERT INTO `user_nickname` VALUES ('73', '曾');
INSERT INTO `user_nickname` VALUES ('74', '经');
INSERT INTO `user_nickname` VALUES ('75', '你');
INSERT INTO `user_nickname` VALUES ('76', '我');
INSERT INTO `user_nickname` VALUES ('77', '一');
INSERT INTO `user_nickname` VALUES ('78', '别');
INSERT INTO `user_nickname` VALUES ('79', '经');
INSERT INTO `user_nickname` VALUES ('80', '年');
INSERT INTO `user_nickname` VALUES ('81', '可');
INSERT INTO `user_nickname` VALUES ('82', '风');
INSERT INTO `user_nickname` VALUES ('83', '里');
INSERT INTO `user_nickname` VALUES ('84', '总');
INSERT INTO `user_nickname` VALUES ('85', '有');
INSERT INTO `user_nickname` VALUES ('86', '段');
INSERT INTO `user_nickname` VALUES ('87', '美');
INSERT INTO `user_nickname` VALUES ('88', '丽');
INSERT INTO `user_nickname` VALUES ('89', '会');
INSERT INTO `user_nickname` VALUES ('90', '与');
INSERT INTO `user_nickname` VALUES ('91', '不');
INSERT INTO `user_nickname` VALUES ('92', '期');
INSERT INTO `user_nickname` VALUES ('93', '而');
INSERT INTO `user_nickname` VALUES ('94', '遇');
INSERT INTO `user_nickname` VALUES ('95', '盏');
INSERT INTO `user_nickname` VALUES ('96', '琉');
INSERT INTO `user_nickname` VALUES ('97', '璃');
INSERT INTO `user_nickname` VALUES ('98', '半');
INSERT INTO `user_nickname` VALUES ('99', '杯');
INSERT INTO `user_nickname` VALUES ('100', '心');
INSERT INTO `user_nickname` VALUES ('101', '悦');
INSERT INTO `user_nickname` VALUES ('102', '端');
INSERT INTO `user_nickname` VALUES ('103', '然');
INSERT INTO `user_nickname` VALUES ('104', '着');
INSERT INTO `user_nickname` VALUES ('105', '那');
INSERT INTO `user_nickname` VALUES ('106', '份');
INSERT INTO `user_nickname` VALUES ('107', '醉');
INSERT INTO `user_nickname` VALUES ('108', '人');
INSERT INTO `user_nickname` VALUES ('109', '静');
INSERT INTO `user_nickname` VALUES ('110', '安');
INSERT INTO `user_nickname` VALUES ('111', '行');
INSERT INTO `user_nickname` VALUES ('112', '走');
INSERT INTO `user_nickname` VALUES ('113', '流');
INSERT INTO `user_nickname` VALUES ('114', '总');
INSERT INTO `user_nickname` VALUES ('115', '会');
INSERT INTO `user_nickname` VALUES ('116', '被');
INSERT INTO `user_nickname` VALUES ('117', '过');
INSERT INTO `user_nickname` VALUES ('118', '往');
INSERT INTO `user_nickname` VALUES ('119', '赋');
INSERT INTO `user_nickname` VALUES ('120', '予');
INSERT INTO `user_nickname` VALUES ('121', '清');
INSERT INTO `user_nickname` VALUES ('122', '喜');
INSERT INTO `user_nickname` VALUES ('123', '浪');
INSERT INTO `user_nickname` VALUES ('124', '漫');
INSERT INTO `user_nickname` VALUES ('125', '或');
INSERT INTO `user_nickname` VALUES ('126', '许');
INSERT INTO `user_nickname` VALUES ('127', '习');
INSERT INTO `user_nickname` VALUES ('128', '惯');
INSERT INTO `user_nickname` VALUES ('129', '了');
INSERT INTO `user_nickname` VALUES ('130', '着');
INSERT INTO `user_nickname` VALUES ('131', '布');
INSERT INTO `user_nickname` VALUES ('132', '衣');
INSERT INTO `user_nickname` VALUES ('133', '素');
INSERT INTO `user_nickname` VALUES ('134', '颜');
INSERT INTO `user_nickname` VALUES ('135', '让');
INSERT INTO `user_nickname` VALUES ('136', '清');
INSERT INTO `user_nickname` VALUES ('137', '心');
INSERT INTO `user_nickname` VALUES ('138', '若');
INSERT INTO `user_nickname` VALUES ('139', '雪');
INSERT INTO `user_nickname` VALUES ('140', '喜');
INSERT INTO `user_nickname` VALUES ('141', '张');
INSERT INTO `user_nickname` VALUES ('142', '扬');
INSERT INTO `user_nickname` VALUES ('143', '畏');
INSERT INTO `user_nickname` VALUES ('144', '喧');
INSERT INTO `user_nickname` VALUES ('145', '哗');
INSERT INTO `user_nickname` VALUES ('146', '守');
INSERT INTO `user_nickname` VALUES ('147', '怀');
INSERT INTO `user_nickname` VALUES ('148', '自');
INSERT INTO `user_nickname` VALUES ('149', '己');
INSERT INTO `user_nickname` VALUES ('150', '素');
INSERT INTO `user_nickname` VALUES ('151', '韵');
INSERT INTO `user_nickname` VALUES ('152', '安');
INSERT INTO `user_nickname` VALUES ('153', '静');
INSERT INTO `user_nickname` VALUES ('154', '中');
INSERT INTO `user_nickname` VALUES ('155', '半');
INSERT INTO `user_nickname` VALUES ('156', '亩');
INSERT INTO `user_nickname` VALUES ('157', '桃');
INSERT INTO `user_nickname` VALUES ('158', '源');
INSERT INTO `user_nickname` VALUES ('159', '修');
INSERT INTO `user_nickname` VALUES ('160', '篱');
INSERT INTO `user_nickname` VALUES ('161', '种');
INSERT INTO `user_nickname` VALUES ('162', '菊');
INSERT INTO `user_nickname` VALUES ('163', '喜');
INSERT INTO `user_nickname` VALUES ('164', '欢');
INSERT INTO `user_nickname` VALUES ('165', '山');
INSERT INTO `user_nickname` VALUES ('166', '水');
INSERT INTO `user_nickname` VALUES ('167', '相');
INSERT INTO `user_nickname` VALUES ('168', '依');
INSERT INTO `user_nickname` VALUES ('169', '流');
INSERT INTO `user_nickname` VALUES ('170', '水');
INSERT INTO `user_nickname` VALUES ('171', '对');
INSERT INTO `user_nickname` VALUES ('172', '话');
INSERT INTO `user_nickname` VALUES ('173', '让');
INSERT INTO `user_nickname` VALUES ('174', '文');
INSERT INTO `user_nickname` VALUES ('175', '字');
INSERT INTO `user_nickname` VALUES ('176', '墨');
INSERT INTO `user_nickname` VALUES ('177', '香');
INSERT INTO `user_nickname` VALUES ('178', '依');
INSERT INTO `user_nickname` VALUES ('179', '附');
INSERT INTO `user_nickname` VALUES ('180', '在');
INSERT INTO `user_nickname` VALUES ('181', '心');
INSERT INTO `user_nickname` VALUES ('182', '灵');
INSERT INTO `user_nickname` VALUES ('183', '每');
INSERT INTO `user_nickname` VALUES ('184', '角');
INSERT INTO `user_nickname` VALUES ('185', '落');
INSERT INTO `user_nickname` VALUES ('186', '闲');
INSERT INTO `user_nickname` VALUES ('187', '时');
INSERT INTO `user_nickname` VALUES ('188', '端');
INSERT INTO `user_nickname` VALUES ('189', '坐');
INSERT INTO `user_nickname` VALUES ('190', '光');
INSERT INTO `user_nickname` VALUES ('191', '隅');
INSERT INTO `user_nickname` VALUES ('192', '将');
INSERT INTO `user_nickname` VALUES ('193', '书');
INSERT INTO `user_nickname` VALUES ('194', '读');
INSERT INTO `user_nickname` VALUES ('195', '到');
INSERT INTO `user_nickname` VALUES ('196', '盏');
INSERT INTO `user_nickname` VALUES ('197', '茶');
INSERT INTO `user_nickname` VALUES ('198', '喝');
INSERT INTO `user_nickname` VALUES ('199', '到');
INSERT INTO `user_nickname` VALUES ('200', '味');
INSERT INTO `user_nickname` VALUES ('201', '故');
INSERT INTO `user_nickname` VALUES ('202', '事');
INSERT INTO `user_nickname` VALUES ('203', '看');
INSERT INTO `user_nickname` VALUES ('204', '到');
INSERT INTO `user_nickname` VALUES ('205', '泪');
INSERT INTO `user_nickname` VALUES ('206', '心');
INSERT INTO `user_nickname` VALUES ('207', '染');
INSERT INTO `user_nickname` VALUES ('208', '尘');
INSERT INTO `user_nickname` VALUES ('209', '香');
INSERT INTO `user_nickname` VALUES ('210', '须');
INSERT INTO `user_nickname` VALUES ('211', '多');
INSERT INTO `user_nickname` VALUES ('212', '少');
INSERT INTO `user_nickname` VALUES ('213', '柔');
INSERT INTO `user_nickname` VALUES ('214', '情');
INSERT INTO `user_nickname` VALUES ('215', '话');
INSERT INTO `user_nickname` VALUES ('216', '语');
INSERT INTO `user_nickname` VALUES ('217', '去');
INSERT INTO `user_nickname` VALUES ('218', '讲');
INSERT INTO `user_nickname` VALUES ('219', '只');
INSERT INTO `user_nickname` VALUES ('220', '要');
INSERT INTO `user_nickname` VALUES ('221', '能');
INSERT INTO `user_nickname` VALUES ('222', '够');
INSERT INTO `user_nickname` VALUES ('223', '念');
INSERT INTO `user_nickname` VALUES ('224', '起');
INSERT INTO `user_nickname` VALUES ('225', '便');
INSERT INTO `user_nickname` VALUES ('226', '温');
INSERT INTO `user_nickname` VALUES ('227', '暖');
INSERT INTO `user_nickname` VALUES ('228', '再');
INSERT INTO `user_nickname` VALUES ('229', '打');
INSERT INTO `user_nickname` VALUES ('230', '开');
INSERT INTO `user_nickname` VALUES ('231', '记');
INSERT INTO `user_nickname` VALUES ('232', '忆');
INSERT INTO `user_nickname` VALUES ('233', '栅');
INSERT INTO `user_nickname` VALUES ('234', '栏，取');
INSERT INTO `user_nickname` VALUES ('235', '壶');
INSERT INTO `user_nickname` VALUES ('236', '往');
INSERT INTO `user_nickname` VALUES ('237', '昔');
INSERT INTO `user_nickname` VALUES ('238', '疼');
INSERT INTO `user_nickname` VALUES ('239', '触');
INSERT INTO `user_nickname` VALUES ('240', '惜');
INSERT INTO `user_nickname` VALUES ('241', '挥');
INSERT INTO `user_nickname` VALUES ('242', '手');
INSERT INTO `user_nickname` VALUES ('243', '袖');
INSERT INTO `user_nickname` VALUES ('244', '风');
INSERT INTO `user_nickname` VALUES ('245', '里');
INSERT INTO `user_nickname` VALUES ('246', '滋');
INSERT INTO `user_nickname` VALUES ('247', '养');
INSERT INTO `user_nickname` VALUES ('248', '忧');
INSERT INTO `user_nickname` VALUES ('249', '伤');
INSERT INTO `user_nickname` VALUES ('250', '捻');
INSERT INTO `user_nickname` VALUES ('251', '缕');
INSERT INTO `user_nickname` VALUES ('252', '清');
INSERT INTO `user_nickname` VALUES ('253', '芬');
INSERT INTO `user_nickname` VALUES ('254', '三');
INSERT INTO `user_nickname` VALUES ('255', '千');
INSERT INTO `user_nickname` VALUES ('256', '浮');
INSERT INTO `user_nickname` VALUES ('257', '华');
INSERT INTO `user_nickname` VALUES ('258', '历');
INSERT INTO `user_nickname` VALUES ('259', '往');
INSERT INTO `user_nickname` VALUES ('260', '素');
INSERT INTO `user_nickname` VALUES ('261', '淡');
INSERT INTO `user_nickname` VALUES ('262', '清');
INSERT INTO `user_nickname` VALUES ('263', '雅');
INSERT INTO `user_nickname` VALUES ('264', '研');
INSERT INTO `user_nickname` VALUES ('265', '池');
INSERT INTO `user_nickname` VALUES ('266', '墨');
INSERT INTO `user_nickname` VALUES ('267', '香');
INSERT INTO `user_nickname` VALUES ('268', '植');
INSERT INTO `user_nickname` VALUES ('269', '于');
INSERT INTO `user_nickname` VALUES ('270', '眉');
INSERT INTO `user_nickname` VALUES ('271', '相');
INSERT INTO `user_nickname` VALUES ('272', '遇');
INSERT INTO `user_nickname` VALUES ('273', '如');
INSERT INTO `user_nickname` VALUES ('274', '梦');
INSERT INTO `user_nickname` VALUES ('275', '充');
INSERT INTO `user_nickname` VALUES ('276', '满');
INSERT INTO `user_nickname` VALUES ('277', '虔');
INSERT INTO `user_nickname` VALUES ('278', '诚');
INSERT INTO `user_nickname` VALUES ('279', '无');
INSERT INTO `user_nickname` VALUES ('280', '暇');
INSERT INTO `user_nickname` VALUES ('281', '打');
INSERT INTO `user_nickname` VALUES ('282', '开');
INSERT INTO `user_nickname` VALUES ('283', '文');
INSERT INTO `user_nickname` VALUES ('284', '字');
INSERT INTO `user_nickname` VALUES ('285', '苍');
INSERT INTO `user_nickname` VALUES ('286', '白');
INSERT INTO `user_nickname` VALUES ('287', '灵');
INSERT INTO `user_nickname` VALUES ('288', '动');
INSERT INTO `user_nickname` VALUES ('289', '心');
INSERT INTO `user_nickname` VALUES ('290', '事');
INSERT INTO `user_nickname` VALUES ('291', '穿');
INSERT INTO `user_nickname` VALUES ('292', '过');
INSERT INTO `user_nickname` VALUES ('293', '岁');
INSERT INTO `user_nickname` VALUES ('294', '月');
INSERT INTO `user_nickname` VALUES ('295', '轩');
INSERT INTO `user_nickname` VALUES ('296', '窗');
INSERT INTO `user_nickname` VALUES ('297', '迎');
INSERT INTO `user_nickname` VALUES ('298', '面');
INSERT INTO `user_nickname` VALUES ('299', '而');
INSERT INTO `user_nickname` VALUES ('300', '来');
INSERT INTO `user_nickname` VALUES ('301', '未');
INSERT INTO `user_nickname` VALUES ('302', '离');
INSERT INTO `user_nickname` VALUES ('303', '开');
INSERT INTO `user_nickname` VALUES ('304', '世');
INSERT INTO `user_nickname` VALUES ('305', '间');
INSERT INTO `user_nickname` VALUES ('306', '繁');
INSERT INTO `user_nickname` VALUES ('307', '华');
INSERT INTO `user_nickname` VALUES ('308', '葱');
INSERT INTO `user_nickname` VALUES ('309', '笼');
INSERT INTO `user_nickname` VALUES ('310', '容');
INSERT INTO `user_nickname` VALUES ('311', '易');
INSERT INTO `user_nickname` VALUES ('312', '沧');
INSERT INTO `user_nickname` VALUES ('313', '桑');
INSERT INTO `user_nickname` VALUES ('314', '让');
INSERT INTO `user_nickname` VALUES ('315', '所');
INSERT INTO `user_nickname` VALUES ('316', '有');
INSERT INTO `user_nickname` VALUES ('317', '如');
INSERT INTO `user_nickname` VALUES ('318', '逝');
INSERT INTO `user_nickname` VALUES ('319', '水');
INSERT INTO `user_nickname` VALUES ('320', '匆');
INSERT INTO `user_nickname` VALUES ('321', '遥');
INSERT INTO `user_nickname` VALUES ('322', '远');
INSERT INTO `user_nickname` VALUES ('323', '天');
INSERT INTO `user_nickname` VALUES ('324', '涯');
INSERT INTO `user_nickname` VALUES ('325', '河');
INSERT INTO `user_nickname` VALUES ('326', '江');
INSERT INTO `user_nickname` VALUES ('327', '海');
INSERT INTO `user_nickname` VALUES ('328', '湖');
INSERT INTO `user_nickname` VALUES ('329', '泊');
INSERT INTO `user_nickname` VALUES ('330', '淡');
INSERT INTO `user_nickname` VALUES ('331', '泊');
INSERT INTO `user_nickname` VALUES ('332', '宁');
INSERT INTO `user_nickname` VALUES ('333', '盈');
INSERT INTO `user_nickname` VALUES ('334', '诗');
INSERT INTO `user_nickname` VALUES ('335', '意');
INSERT INTO `user_nickname` VALUES ('336', '赴');
INSERT INTO `user_nickname` VALUES ('337', '许');
INSERT INTO `user_nickname` VALUES ('338', '下');
INSERT INTO `user_nickname` VALUES ('339', '盟');
INSERT INTO `user_nickname` VALUES ('340', '誓');
INSERT INTO `user_nickname` VALUES ('341', '离');
INSERT INTO `user_nickname` VALUES ('342', '开');
INSERT INTO `user_nickname` VALUES ('343', '叶');
INSERT INTO `user_nickname` VALUES ('344', '落');
INSERT INTO `user_nickname` VALUES ('345', '美');
INSERT INTO `user_nickname` VALUES ('346', '梦');
INSERT INTO `user_nickname` VALUES ('347', '想');
INSERT INTO `user_nickname` VALUES ('348', '云');
INSERT INTO `user_nickname` VALUES ('349', '水');
INSERT INTO `user_nickname` VALUES ('350', '长');
INSERT INTO `user_nickname` VALUES ('351', '韶');
INSERT INTO `user_nickname` VALUES ('352', '华');
INSERT INTO `user_nickname` VALUES ('353', '已');
INSERT INTO `user_nickname` VALUES ('354', '老');
INSERT INTO `user_nickname` VALUES ('355', '岁');
INSERT INTO `user_nickname` VALUES ('356', '月');
INSERT INTO `user_nickname` VALUES ('357', '早');
INSERT INTO `user_nickname` VALUES ('358', '已');
INSERT INTO `user_nickname` VALUES ('359', '沧');
INSERT INTO `user_nickname` VALUES ('360', '桑');
INSERT INTO `user_nickname` VALUES ('361', '习');
INSERT INTO `user_nickname` VALUES ('362', '惯');
INSERT INTO `user_nickname` VALUES ('363', '了');
INSERT INTO `user_nickname` VALUES ('364', '默');
INSERT INTO `user_nickname` VALUES ('365', '独');
INSERT INTO `user_nickname` VALUES ('366', '舞');
INSERT INTO `user_nickname` VALUES ('367', '忧');
INSERT INTO `user_nickname` VALUES ('368', '伤');
INSERT INTO `user_nickname` VALUES ('369', '然');
INSERT INTO `user_nickname` VALUES ('370', '眼');
INSERT INTO `user_nickname` VALUES ('371', '凝');
INSERT INTO `user_nickname` VALUES ('372', '眸');
INSERT INTO `user_nickname` VALUES ('373', '却');
INSERT INTO `user_nickname` VALUES ('374', '注');
INSERT INTO `user_nickname` VALUES ('375', '定');
INSERT INTO `user_nickname` VALUES ('376', '得');
INSERT INTO `user_nickname` VALUES ('377', '世');
INSERT INTO `user_nickname` VALUES ('378', '相');
INSERT INTO `user_nickname` VALUES ('379', '随');
INSERT INTO `user_nickname` VALUES ('380', '烟');
INSERT INTO `user_nickname` VALUES ('381', '花');
INSERT INTO `user_nickname` VALUES ('382', '绚');
INSERT INTO `user_nickname` VALUES ('383', '烂');
INSERT INTO `user_nickname` VALUES ('384', '忽');
INSERT INTO `user_nickname` VALUES ('385', '发');
INSERT INTO `user_nickname` VALUES ('386', '现');
INSERT INTO `user_nickname` VALUES ('387', '悄');
INSERT INTO `user_nickname` VALUES ('388', '然');
INSERT INTO `user_nickname` VALUES ('389', '呼');
INSERT INTO `user_nickname` VALUES ('390', '出');
INSERT INTO `user_nickname` VALUES ('391', '想');
INSERT INTO `user_nickname` VALUES ('392', '念');
INSERT INTO `user_nickname` VALUES ('393', '里');
INSERT INTO `user_nickname` VALUES ('394', '夏');
INSERT INTO `user_nickname` VALUES ('395', '调');
INSERT INTO `user_nickname` VALUES ('396', '谢');
INSERT INTO `user_nickname` VALUES ('397', '秋');
INSERT INTO `user_nickname` VALUES ('398', '浓');
INSERT INTO `user_nickname` VALUES ('399', '空');
INSERT INTO `user_nickname` VALUES ('400', '气');
INSERT INTO `user_nickname` VALUES ('401', '冬');
INSERT INTO `user_nickname` VALUES ('402', '雨');
INSERT INTO `user_nickname` VALUES ('403', '过');
INSERT INTO `user_nickname` VALUES ('404', '清');
INSERT INTO `user_nickname` VALUES ('405', '新');
INSERT INTO `user_nickname` VALUES ('406', '沾');
INSERT INTO `user_nickname` VALUES ('407', '染');
INSERT INTO `user_nickname` VALUES ('408', '沧');
INSERT INTO `user_nickname` VALUES ('409', '桑');
INSERT INTO `user_nickname` VALUES ('410', '凉');
INSERT INTO `user_nickname` VALUES ('411', '邂');
INSERT INTO `user_nickname` VALUES ('412', '逅');
INSERT INTO `user_nickname` VALUES ('413', '言');
INSERT INTO `user_nickname` VALUES ('414', '守');
INSERT INTO `user_nickname` VALUES ('415', '望');
INSERT INTO `user_nickname` VALUES ('416', '烟');
INSERT INTO `user_nickname` VALUES ('417', '轮');
INSERT INTO `user_nickname` VALUES ('418', '回');
INSERT INTO `user_nickname` VALUES ('419', '成');
INSERT INTO `user_nickname` VALUES ('420', '全');
INSERT INTO `user_nickname` VALUES ('421', '涯');
INSERT INTO `user_nickname` VALUES ('422', '相');
INSERT INTO `user_nickname` VALUES ('423', '依');
INSERT INTO `user_nickname` VALUES ('424', '总');
INSERT INTO `user_nickname` VALUES ('425', '会');
INSERT INTO `user_nickname` VALUES ('426', '随');
INSERT INTO `user_nickname` VALUES ('427', '风');
INSERT INTO `user_nickname` VALUES ('428', '那');
INSERT INTO `user_nickname` VALUES ('429', '些');
INSERT INTO `user_nickname` VALUES ('430', '忧');
INSERT INTO `user_nickname` VALUES ('431', '伤');
INSERT INTO `user_nickname` VALUES ('432', '叹');
INSERT INTO `user_nickname` VALUES ('433', '息');
INSERT INTO `user_nickname` VALUES ('434', '深');
INSERT INTO `user_nickname` VALUES ('435', '夜');
INSERT INTO `user_nickname` VALUES ('436', '依');
INSERT INTO `user_nickname` VALUES ('437', '然');
INSERT INTO `user_nickname` VALUES ('438', '会');
INSERT INTO `user_nickname` VALUES ('439', '被');
INSERT INTO `user_nickname` VALUES ('440', '突');
INSERT INTO `user_nickname` VALUES ('441', '如');
INSERT INTO `user_nickname` VALUES ('442', '喧');
INSERT INTO `user_nickname` VALUES ('443', '嚣');
INSERT INTO `user_nickname` VALUES ('444', '触');
INSERT INTO `user_nickname` VALUES ('445', '痛');
INSERT INTO `user_nickname` VALUES ('446', '星');
INSERT INTO `user_nickname` VALUES ('447', '铭');
INSERT INTO `user_nickname` VALUES ('448', '刻');
INSERT INTO `user_nickname` VALUES ('449', '沙');
INSERT INTO `user_nickname` VALUES ('450', '漏');
INSERT INTO `user_nickname` VALUES ('451', '渐');
INSERT INTO `user_nickname` VALUES ('452', '滤');
INSERT INTO `user_nickname` VALUES ('453', '最');
INSERT INTO `user_nickname` VALUES ('454', '初');
INSERT INTO `user_nickname` VALUES ('455', '繁');
INSERT INTO `user_nickname` VALUES ('456', '给');
INSERT INTO `user_nickname` VALUES ('457', '予');
INSERT INTO `user_nickname` VALUES ('458', '既');
INSERT INTO `user_nickname` VALUES ('459', '懂');
INSERT INTO `user_nickname` VALUES ('460', '得');
INSERT INTO `user_nickname` VALUES ('461', '何');
INSERT INTO `user_nickname` VALUES ('462', '须');
INSERT INTO `user_nickname` VALUES ('463', '言');
INSERT INTO `user_nickname` VALUES ('464', '永');
INSERT INTO `user_nickname` VALUES ('465', '留');
INSERT INTO `user_nickname` VALUES ('466', '心');
INSERT INTO `user_nickname` VALUES ('467', '间');
INSERT INTO `user_nickname` VALUES ('468', '感');
INSERT INTO `user_nickname` VALUES ('469', '谢');
INSERT INTO `user_nickname` VALUES ('470', '岁');
INSERT INTO `user_nickname` VALUES ('471', '月');
INSERT INTO `user_nickname` VALUES ('472', '赠');
INSERT INTO `user_nickname` VALUES ('473', '予');
INSERT INTO `user_nickname` VALUES ('474', '恩');
INSERT INTO `user_nickname` VALUES ('475', '宠，亦');
INSERT INTO `user_nickname` VALUES ('476', '感');
INSERT INTO `user_nickname` VALUES ('477', '谢');
INSERT INTO `user_nickname` VALUES ('478', '你');
INSERT INTO `user_nickname` VALUES ('479', '让');
INSERT INTO `user_nickname` VALUES ('480', '途');
INSERT INTO `user_nickname` VALUES ('481', '径');
INSERT INTO `user_nickname` VALUES ('482', '生');
INSERT INTO `user_nickname` VALUES ('483', '命');
INSERT INTO `user_nickname` VALUES ('484', '四');
INSERT INTO `user_nickname` VALUES ('485', '季');
INSERT INTO `user_nickname` VALUES ('486', '陪');
INSERT INTO `user_nickname` VALUES ('487', '程');
INSERT INTO `user_nickname` VALUES ('488', '遇');
INSERT INTO `user_nickname` VALUES ('489', '借');
INSERT INTO `user_nickname` VALUES ('490', '云');
INSERT INTO `user_nickname` VALUES ('491', '淡');
INSERT INTO `user_nickname` VALUES ('492', '风');
INSERT INTO `user_nickname` VALUES ('493', '轻');
INSERT INTO `user_nickname` VALUES ('494', '掬');
INSERT INTO `user_nickname` VALUES ('495', '捧');
INSERT INTO `user_nickname` VALUES ('496', '水');
INSERT INTO `user_nickname` VALUES ('497', '月');
INSERT INTO `user_nickname` VALUES ('498', '在');
INSERT INTO `user_nickname` VALUES ('499', '手');
INSERT INTO `user_nickname` VALUES ('500', '沾');
INSERT INTO `user_nickname` VALUES ('501', '岁');
INSERT INTO `user_nickname` VALUES ('502', '月');
INSERT INTO `user_nickname` VALUES ('503', '花');
INSERT INTO `user_nickname` VALUES ('504', '香');
INSERT INTO `user_nickname` VALUES ('505', '满');
INSERT INTO `user_nickname` VALUES ('506', '衣');
INSERT INTO `user_nickname` VALUES ('507', '慎');
INSERT INTO `user_nickname` VALUES ('508', '重');
INSERT INTO `user_nickname` VALUES ('509', '在');
INSERT INTO `user_nickname` VALUES ('510', '相');
INSERT INTO `user_nickname` VALUES ('511', '逢');
INSERT INTO `user_nickname` VALUES ('512', '渡');
INSERT INTO `user_nickname` VALUES ('513', '口');
INSERT INTO `user_nickname` VALUES ('514', '写');
INSERT INTO `user_nickname` VALUES ('515', '下');
INSERT INTO `user_nickname` VALUES ('516', '回');
INSERT INTO `user_nickname` VALUES ('517', '忆');
INSERT INTO `user_nickname` VALUES ('518', '精');
INSERT INTO `user_nickname` VALUES ('519', '彩');
INSERT INTO `user_nickname` VALUES ('520', '问');
INSERT INTO `user_nickname` VALUES ('521', '情');
INSERT INTO `user_nickname` VALUES ('522', '深');
INSERT INTO `user_nickname` VALUES ('523', '浅');
INSERT INTO `user_nickname` VALUES ('524', '遇');
INSERT INTO `user_nickname` VALUES ('525', '见');
INSERT INTO `user_nickname` VALUES ('526', '相');
INSERT INTO `user_nickname` VALUES ('527', '伴');
INSERT INTO `user_nickname` VALUES ('528', '理');
INSERT INTO `user_nickname` VALUES ('529', '由');
INSERT INTO `user_nickname` VALUES ('530', '日');
INSERT INTO `user_nickname` VALUES ('531', '落');
INSERT INTO `user_nickname` VALUES ('532', '烟');
INSERT INTO `user_nickname` VALUES ('533', '霞');
INSERT INTO `user_nickname` VALUES ('534', '菜');
INSERT INTO `user_nickname` VALUES ('535', '草');
INSERT INTO `user_nickname` VALUES ('536', '十');
INSERT INTO `user_nickname` VALUES ('537', '赵');
INSERT INTO `user_nickname` VALUES ('538', '刘');
INSERT INTO `user_nickname` VALUES ('539', '周');
INSERT INTO `user_nickname` VALUES ('540', '王');
INSERT INTO `user_nickname` VALUES ('541', '孙');
INSERT INTO `user_nickname` VALUES ('542', '宋');
INSERT INTO `user_nickname` VALUES ('543', '张');
INSERT INTO `user_nickname` VALUES ('544', '李');
INSERT INTO `user_nickname` VALUES ('545', '程');
INSERT INTO `user_nickname` VALUES ('546', '成');
INSERT INTO `user_nickname` VALUES ('547', '陈');
INSERT INTO `user_nickname` VALUES ('548', '趁');
INSERT INTO `user_nickname` VALUES ('549', '城');
INSERT INTO `user_nickname` VALUES ('550', '诚');
INSERT INTO `user_nickname` VALUES ('551', '晨');
INSERT INTO `user_nickname` VALUES ('552', '舟');
INSERT INTO `user_nickname` VALUES ('553', '周');
INSERT INTO `user_nickname` VALUES ('554', '洲');
INSERT INTO `user_nickname` VALUES ('555', '粥');
INSERT INTO `user_nickname` VALUES ('556', '轴');
INSERT INTO `user_nickname` VALUES ('557', '咒');
INSERT INTO `user_nickname` VALUES ('558', '皱');
INSERT INTO `user_nickname` VALUES ('559', '胖');
INSERT INTO `user_nickname` VALUES ('560', '小');
INSERT INTO `user_nickname` VALUES ('561', '笑');
INSERT INTO `user_nickname` VALUES ('562', '宵');
INSERT INTO `user_nickname` VALUES ('563', '晓');
INSERT INTO `user_nickname` VALUES ('564', '开');
INSERT INTO `user_nickname` VALUES ('565', '罗');
INSERT INTO `user_nickname` VALUES ('566', '何');
INSERT INTO `user_nickname` VALUES ('567', '风');
INSERT INTO `user_nickname` VALUES ('568', '峰');
INSERT INTO `user_nickname` VALUES ('569', '封');
INSERT INTO `user_nickname` VALUES ('570', '丰');
INSERT INTO `user_nickname` VALUES ('571', '枫');
INSERT INTO `user_nickname` VALUES ('572', '七');
INSERT INTO `user_nickname` VALUES ('573', '八');
INSERT INTO `user_nickname` VALUES ('574', '九');
INSERT INTO `user_nickname` VALUES ('575', '五');
INSERT INTO `user_nickname` VALUES ('576', '四');
INSERT INTO `user_nickname` VALUES ('577', '二');
INSERT INTO `user_nickname` VALUES ('578', '兔');
INSERT INTO `user_nickname` VALUES ('579', '土');
INSERT INTO `user_nickname` VALUES ('580', '雪');
INSERT INTO `user_nickname` VALUES ('581', '虚');
INSERT INTO `user_nickname` VALUES ('582', '若');
INSERT INTO `user_nickname` VALUES ('583', '弱');
INSERT INTO `user_nickname` VALUES ('584', '渃');
INSERT INTO `user_nickname` VALUES ('585', '如');
INSERT INTO `user_nickname` VALUES ('586', '霞');
INSERT INTO `user_nickname` VALUES ('587', '侠');
INSERT INTO `user_nickname` VALUES ('588', '可');
INSERT INTO `user_nickname` VALUES ('589', '青');
INSERT INTO `user_nickname` VALUES ('590', '丝');
INSERT INTO `user_nickname` VALUES ('591', '斯');
INSERT INTO `user_nickname` VALUES ('592', '思');
INSERT INTO `user_nickname` VALUES ('593', '似');
INSERT INTO `user_nickname` VALUES ('594', '屏');
INSERT INTO `user_nickname` VALUES ('595', '凭');
INSERT INTO `user_nickname` VALUES ('596', '瓶');
INSERT INTO `user_nickname` VALUES ('597', '萍');
INSERT INTO `user_nickname` VALUES ('598', '苹');
INSERT INTO `user_nickname` VALUES ('599', '拉');
INSERT INTO `user_nickname` VALUES ('600', '蜡');
INSERT INTO `user_nickname` VALUES ('601', '辣');
INSERT INTO `user_nickname` VALUES ('602', '夜');
INSERT INTO `user_nickname` VALUES ('603', '叶');
INSERT INTO `user_nickname` VALUES ('604', '钱');
INSERT INTO `user_nickname` VALUES ('605', '吴');
INSERT INTO `user_nickname` VALUES ('606', '楼');
INSERT INTO `user_nickname` VALUES ('607', '露');
INSERT INTO `user_nickname` VALUES ('608', '娄');
INSERT INTO `user_nickname` VALUES ('609', '求');
