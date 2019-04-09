/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : jfun

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-04-09 13:52:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gen_config
-- ----------------------------
DROP TABLE IF EXISTS `gen_config`;
CREATE TABLE `gen_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `cover` bit(1) DEFAULT NULL COMMENT '是否覆盖',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `pack` varchar(255) DEFAULT NULL COMMENT '至于哪个包下',
  `path` varchar(255) DEFAULT NULL COMMENT '前端代码生成的路径',
  `api_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gen_config
-- ----------------------------
INSERT INTO `gen_config` VALUES ('1', 'miv', '\0', 'eladmin-system', 'cn.xiejx.jfun', 'E:\\workspace\\my-workspace\\eladmin-qt\\src\\views\\system\\test', 'E:\\workspace\\my-workspace\\eladmin-qt\\src\\api');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------

-- ----------------------------
-- Table structure for quartz_job
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job`;
CREATE TABLE `quartz_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bean_name` varchar(255) DEFAULT NULL COMMENT 'Spring Bean名称',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron 表达式',
  `is_pause` bit(1) DEFAULT NULL COMMENT '状态：1暂停、0启用',
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `method_name` varchar(255) DEFAULT NULL COMMENT '方法名称',
  `params` varchar(255) DEFAULT NULL COMMENT '参数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `update_time` datetime DEFAULT NULL COMMENT '创建或更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quartz_job
-- ----------------------------
INSERT INTO `quartz_job` VALUES ('2', 'testTask', '0/10 * * * * ? *', '', '测试1', 'run1', 'test', '带参测试，多参使用json', '2019-04-01 17:19:30');
INSERT INTO `quartz_job` VALUES ('3', 'testTask', '0/5 * * * * ? *', '', '测试', 'run', '', '不带参测试', '2019-01-14 09:59:19');

-- ----------------------------
-- Table structure for quartz_log
-- ----------------------------
DROP TABLE IF EXISTS `quartz_log`;
CREATE TABLE `quartz_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `baen_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `cron_expression` varchar(255) DEFAULT NULL,
  `exception_detail` text,
  `is_success` bit(1) DEFAULT NULL,
  `job_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=575 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quartz_log
-- ----------------------------
INSERT INTO `quartz_log` VALUES ('1', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '3');
INSERT INTO `quartz_log` VALUES ('2', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test123', '4');
INSERT INTO `quartz_log` VALUES ('3', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('4', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '199');
INSERT INTO `quartz_log` VALUES ('5', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '9416');
INSERT INTO `quartz_log` VALUES ('6', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '10309');
INSERT INTO `quartz_log` VALUES ('7', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1351');
INSERT INTO `quartz_log` VALUES ('8', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '653');
INSERT INTO `quartz_log` VALUES ('9', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '17899');
INSERT INTO `quartz_log` VALUES ('10', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('11', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('12', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '4');
INSERT INTO `quartz_log` VALUES ('13', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('14', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('15', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('16', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('17', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('18', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('19', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('20', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('21', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('22', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('23', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('24', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('25', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('26', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('27', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('28', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('29', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('30', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('31', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('32', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('33', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('34', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('35', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('36', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('37', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('38', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('39', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('40', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('41', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('42', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('43', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('44', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('45', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('46', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('47', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('48', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('49', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('50', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('51', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('52', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('53', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('54', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('55', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('56', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('57', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('58', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('59', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('60', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('61', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('62', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('63', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('64', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('65', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('66', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('67', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('68', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('69', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('70', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('71', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('72', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('73', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('74', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('75', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('76', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('77', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('78', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('79', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('80', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('81', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('82', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('83', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('84', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('85', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('86', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('87', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('88', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('89', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('90', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('91', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('92', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('93', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('94', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('95', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('96', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('97', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('98', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('99', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('100', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('101', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('102', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('103', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('104', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('105', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('106', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('107', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('108', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('109', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('110', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('111', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('112', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('113', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('114', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('115', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('116', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('117', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('118', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('119', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('120', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('121', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('122', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('123', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('124', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('125', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('126', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('127', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('128', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('129', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('130', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('131', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('132', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('133', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('134', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('135', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '2');
INSERT INTO `quartz_log` VALUES ('136', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('137', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('138', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('139', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('140', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('141', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('142', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('143', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('144', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('145', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('146', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('147', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('148', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('149', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('150', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('151', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('152', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('153', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('154', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('155', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('156', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('157', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('158', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('159', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('160', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('161', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('162', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('163', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('164', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('165', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('166', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('167', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('168', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('169', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('170', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('171', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('172', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('173', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('174', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('175', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('176', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('177', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('178', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('179', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('180', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('181', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('182', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('183', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('184', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('185', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('186', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('187', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('188', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('189', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('190', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '3');
INSERT INTO `quartz_log` VALUES ('191', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('192', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('193', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('194', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('195', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('196', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('197', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('198', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('199', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('200', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('201', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('202', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '2');
INSERT INTO `quartz_log` VALUES ('203', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('204', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('205', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('206', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('207', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('208', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('209', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('210', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('211', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('212', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('213', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('214', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('215', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('216', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('217', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('218', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('219', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('220', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('221', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('222', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('223', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('224', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('225', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('226', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('227', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('228', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('229', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('230', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('231', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('232', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('233', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('234', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('235', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('236', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('237', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('238', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('239', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('240', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('241', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('242', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('243', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('244', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('245', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('246', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('247', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('248', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('249', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('250', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('251', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('252', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('253', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('254', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('255', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('256', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('257', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('258', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('259', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('260', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('261', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('262', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('263', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('264', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('265', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('266', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('267', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('268', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('269', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('270', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('271', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('272', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('273', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('274', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('275', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('276', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('277', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('278', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('279', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('280', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('281', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('282', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('283', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('284', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('285', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '4');
INSERT INTO `quartz_log` VALUES ('286', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('287', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('288', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('289', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('290', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('291', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('292', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('293', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('294', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('295', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('296', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('297', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('298', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('299', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('300', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('301', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('302', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('303', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('304', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('305', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('306', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('307', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('308', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('309', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('310', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('311', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('312', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('313', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('314', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('315', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('316', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('317', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('318', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('319', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('320', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('321', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('322', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('323', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('324', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('325', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('326', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('327', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('328', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('329', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('330', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('331', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('332', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('333', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('334', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('335', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('336', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('337', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('338', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('339', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('340', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('341', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('342', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('343', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('344', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('345', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('346', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('347', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '4');
INSERT INTO `quartz_log` VALUES ('348', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('349', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('350', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('351', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('352', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('353', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('354', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('355', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('356', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('357', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('358', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('359', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('360', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('361', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('362', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('363', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('364', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('365', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('366', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('367', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('368', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('369', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('370', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('371', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('372', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('373', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('374', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('375', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('376', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('377', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '7');
INSERT INTO `quartz_log` VALUES ('378', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('379', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('380', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('381', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('382', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('383', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('384', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('385', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('386', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('387', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('388', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('389', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('390', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('391', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('392', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('393', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('394', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('395', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('396', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('397', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('398', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('399', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('400', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('401', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('402', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('403', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('404', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('405', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('406', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('407', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('408', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('409', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('410', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('411', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('412', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('413', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('414', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('415', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('416', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('417', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('418', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('419', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('420', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('421', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('422', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('423', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('424', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('425', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('426', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('427', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('428', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('429', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('430', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('431', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('432', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('433', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('434', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('435', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('436', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('437', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('438', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('439', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('440', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('441', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('442', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('443', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('444', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('445', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('446', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('447', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('448', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('449', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('450', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('451', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('452', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('453', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('454', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('455', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('456', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('457', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('458', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('459', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('460', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('461', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('462', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('463', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('464', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('465', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('466', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('467', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('468', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('469', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('470', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('471', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('472', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('473', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('474', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('475', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('476', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('477', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('478', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('479', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('480', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('481', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('482', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('483', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('484', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('485', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('486', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('487', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('488', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('489', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('490', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('491', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('492', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('493', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('494', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '2');
INSERT INTO `quartz_log` VALUES ('495', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('496', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('497', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('498', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('499', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('500', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('501', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('502', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('503', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '2');
INSERT INTO `quartz_log` VALUES ('504', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('505', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('506', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('507', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('508', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('509', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('510', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('511', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('512', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('513', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('514', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('515', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('516', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('517', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '2');
INSERT INTO `quartz_log` VALUES ('518', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('519', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('520', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('521', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('522', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('523', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('524', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('525', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('526', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('527', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('528', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('529', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('530', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('531', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('532', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('533', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('534', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('535', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('536', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('537', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('538', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('539', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('540', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '1');
INSERT INTO `quartz_log` VALUES ('541', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('542', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('543', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('544', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('545', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('546', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('547', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('548', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('549', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('550', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('551', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('552', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('553', 'testTask', null, '0/5 * * * * ? *', null, '', '测试', 'run', '', '0');
INSERT INTO `quartz_log` VALUES ('554', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('555', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('556', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('557', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('558', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('559', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('560', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('561', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('562', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('563', 'testTask', null, '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('564', 'testTask', '2019-04-04 09:29:40', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '2');
INSERT INTO `quartz_log` VALUES ('565', 'testTask', '2019-04-04 09:29:50', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '1');
INSERT INTO `quartz_log` VALUES ('566', 'testTask', '2019-04-04 09:30:00', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('567', 'testTask', '2019-04-04 09:30:10', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('568', 'testTask', '2019-04-04 09:30:20', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('569', 'testTask', '2019-04-04 09:30:30', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('570', 'testTask', '2019-04-04 09:30:40', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('571', 'testTask', '2019-04-04 09:30:50', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('572', 'testTask', '2019-04-04 09:31:00', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('573', 'testTask', '2019-04-04 09:31:10', '0/10 * * * * ? *', null, '', '测试1', 'run1', 'test', '0');
INSERT INTO `quartz_log` VALUES ('574', 'testTask', '2019-04-04 09:31:20', '0/10 * * * * ? *', null, '\0', '测试1', 'run1', 'test', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `i_frame` bit(1) DEFAULT NULL COMMENT '是否外链',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) DEFAULT NULL COMMENT '组件',
  `pid` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `sort` bigint(20) NOT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `path` varchar(255) DEFAULT NULL COMMENT '链接地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '2018-12-18 15:11:29', '\0', '系统管理', null, '0', '1', 'system', 'system');
INSERT INTO `sys_menu` VALUES ('2', '2018-12-18 15:14:44', '\0', '用户管理', 'system/user/index', '1', '2', 'peoples', 'user');
INSERT INTO `sys_menu` VALUES ('3', '2018-12-18 15:16:07', '\0', '角色管理', 'system/role/index', '1', '3', 'role', 'role');
INSERT INTO `sys_menu` VALUES ('4', '2018-12-18 15:16:45', '\0', '权限管理', 'system/permission/index', '1', '4', 'permission', 'permission');
INSERT INTO `sys_menu` VALUES ('5', '2018-12-18 15:17:28', '\0', '菜单管理', 'system/menu/index', '1', '5', 'menu', 'menu');
INSERT INTO `sys_menu` VALUES ('6', '2018-12-18 15:17:48', '\0', '系统监控', null, '0', '10', 'monitor', 'monitor');
INSERT INTO `sys_menu` VALUES ('7', '2018-12-18 15:18:26', '\0', '操作日志', 'monitor/log/index', '6', '11', 'log', 'logs');
INSERT INTO `sys_menu` VALUES ('8', '2018-12-18 15:19:01', '\0', '系统缓存', 'monitor/redis/index', '6', '13', 'redis', 'redis');
INSERT INTO `sys_menu` VALUES ('9', '2018-12-18 15:19:34', '', 'SQL监控', null, '6', '14', 'sqlMonitor', 'http://api.auauz.net/druid');
INSERT INTO `sys_menu` VALUES ('10', '2018-12-19 13:38:16', '\0', '组件管理', null, '0', '50', 'zujian', 'components');
INSERT INTO `sys_menu` VALUES ('11', '2018-12-19 13:38:49', '\0', '图标库', 'components/IconSelect', '10', '51', 'icon', 'icon');
INSERT INTO `sys_menu` VALUES ('12', '2018-12-24 20:37:35', '\0', '实时控制台', 'monitor/log/msg', '6', '15', 'codeConsole', 'msg');
INSERT INTO `sys_menu` VALUES ('13', '2018-12-27 10:11:26', '\0', '三方工具', '', '0', '30', 'tools', 'tools');
INSERT INTO `sys_menu` VALUES ('14', '2018-12-27 10:13:09', '\0', '邮件工具', 'tools/email/index', '13', '31', 'email', 'email');
INSERT INTO `sys_menu` VALUES ('15', '2018-12-27 11:58:25', '\0', '富文本', 'components/Editor', '10', '52', 'fwb', 'tinymce');
INSERT INTO `sys_menu` VALUES ('16', '2018-12-28 09:36:53', '\0', 'SM.MS图床', 'tools/picture/index', '13', '32', 'image', 'pictures');
INSERT INTO `sys_menu` VALUES ('17', '2018-12-28 15:09:49', '', '项目地址', '', '0', '0', 'github', 'https://github.com/elunez/eladmin');
INSERT INTO `sys_menu` VALUES ('18', '2018-12-31 11:12:15', '\0', '七牛云存储', 'tools/qiniu/index', '13', '33', 'qiniu', 'qiniu');
INSERT INTO `sys_menu` VALUES ('19', '2018-12-31 14:52:38', '\0', '支付宝工具', 'tools/aliPay/index', '13', '34', 'alipay', 'aliPay');
INSERT INTO `sys_menu` VALUES ('21', '2019-01-04 16:22:03', '\0', '多级菜单', '', '0', '900', 'menu', 'nested');
INSERT INTO `sys_menu` VALUES ('22', '2019-01-04 16:23:29', '\0', '二级菜单1', 'nested/menu1/index', '21', '999', 'menu', 'menu1');
INSERT INTO `sys_menu` VALUES ('23', '2019-01-04 16:23:57', '\0', '二级菜单2', 'nested/menu2/index', '21', '999', 'menu', 'menu2');
INSERT INTO `sys_menu` VALUES ('24', '2019-01-04 16:24:48', '\0', '三级菜单1', 'nested/menu1/menu1-1', '22', '999', 'menu', 'menu1-1');
INSERT INTO `sys_menu` VALUES ('27', '2019-01-07 17:27:32', '\0', '三级菜单2', 'nested/menu1/menu1-2', '22', '999', 'menu', 'menu1-2');
INSERT INTO `sys_menu` VALUES ('28', '2019-01-07 20:34:40', '\0', '定时任务', 'system/timing/index', '1', '6', 'timing', 'timing');
INSERT INTO `sys_menu` VALUES ('30', '2019-01-11 15:45:55', '\0', '代码生成', 'generator/index', '1', '8', 'dev', 'generator');
INSERT INTO `sys_menu` VALUES ('32', '2019-01-13 13:49:03', '\0', '异常日志', 'monitor/log/errorLog', '6', '12', 'error', 'errorLog');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '用户管理', '0', 'USER_ALL', '2019-03-28 11:15:49');
INSERT INTO `sys_permission` VALUES ('2', '用户添加', '1', 'USER_ADD', '2019-03-28 11:15:51');
INSERT INTO `sys_permission` VALUES ('3', '用户删除', '1', 'USER_DEL', '2019-03-28 11:15:53');
INSERT INTO `sys_permission` VALUES ('4', '用户编辑', '1', 'USER_EDIT', '2019-03-28 11:15:54');
INSERT INTO `sys_permission` VALUES ('5', '角色管理', '0', 'ROLE_ALL', '2019-03-28 11:15:56');
INSERT INTO `sys_permission` VALUES ('6', '角色添加', '5', 'ROLE_ADD', '2019-03-29 10:00:51');
INSERT INTO `sys_permission` VALUES ('7', '角色编辑', '5', 'ROLE_EDIT', '2019-03-29 10:01:13');
INSERT INTO `sys_permission` VALUES ('8', '角色删除', '5', 'ROLE_DEL', '2019-03-29 10:01:36');
INSERT INTO `sys_permission` VALUES ('9', '用户查询', '1', 'USER_VIEW', '2019-03-29 10:05:41');
INSERT INTO `sys_permission` VALUES ('10', '角色查看', '5', 'ROLE_VIEW', '2019-03-29 10:10:20');
INSERT INTO `sys_permission` VALUES ('11', '权限管理', '0', 'PERMISSION_ALL', '2019-03-29 13:03:06');
INSERT INTO `sys_permission` VALUES ('12', '权限查看', '11', 'PERMISSION_VIEW', '2019-03-29 13:04:42');
INSERT INTO `sys_permission` VALUES ('13', '权限添加', '11', 'PERMISSION_ADD', '2019-03-29 13:04:45');
INSERT INTO `sys_permission` VALUES ('14', '权限编辑', '11', 'PERMISSION_EDIT', '2019-03-29 13:04:47');
INSERT INTO `sys_permission` VALUES ('15', '权限删除', '11', 'PERMISSION_DEL', '2019-03-29 13:04:48');
INSERT INTO `sys_permission` VALUES ('20', '菜单查询', '19', 'MENU_VIEW', '2019-03-29 15:35:44');
INSERT INTO `sys_permission` VALUES ('19', '菜单管理', '0', 'MENU_ALL', '2019-03-29 15:35:20');
INSERT INTO `sys_permission` VALUES ('21', '菜单编辑', '19', 'MENU_EDIT', '2019-03-29 15:36:06');
INSERT INTO `sys_permission` VALUES ('22', '菜单删除', '19', 'MENU_DEL', '2019-03-29 15:36:36');
INSERT INTO `sys_permission` VALUES ('23', '菜单添加', '19', 'MENU_ADD', '2019-03-29 15:36:56');
INSERT INTO `sys_permission` VALUES ('25', '定时任务', '0', 'JOB_ALL', '2019-04-01 16:34:50');
INSERT INTO `sys_permission` VALUES ('26', '定时任务添加', '25', 'JOB_ADD', '2019-04-01 16:35:50');
INSERT INTO `sys_permission` VALUES ('27', '定时任务修改', '25', 'JOB_EDIT', '2019-04-01 16:36:07');
INSERT INTO `sys_permission` VALUES ('28', '定时任务查询', '25', 'JOB_VIEW', '2019-04-01 16:36:25');
INSERT INTO `sys_permission` VALUES ('29', '定时任务删除', '25', 'JOB_DEL', '2019-04-01 16:36:39');
INSERT INTO `sys_permission` VALUES ('30', '代码生成', '0', 'GENERATOR_CODE', '2019-04-08 11:48:35');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '2019-03-28 15:27:48');
INSERT INTO `sys_role` VALUES ('2', 'VIP会员23', 'vip12', '2019-03-28 15:27:50');
INSERT INTO `sys_role` VALUES ('12', 'AAA', 'AAA', '2019-03-29 10:24:36');

-- ----------------------------
-- Table structure for sys_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_menus`;
CREATE TABLE `sys_roles_menus` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`menu_id`,`role_id`) USING BTREE,
  KEY `FKcngg2qadojhi3a651a5adkvbq` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_roles_menus
-- ----------------------------
INSERT INTO `sys_roles_menus` VALUES ('1', '1');
INSERT INTO `sys_roles_menus` VALUES ('1', '2');
INSERT INTO `sys_roles_menus` VALUES ('1', '3');
INSERT INTO `sys_roles_menus` VALUES ('1', '4');
INSERT INTO `sys_roles_menus` VALUES ('1', '5');
INSERT INTO `sys_roles_menus` VALUES ('1', '6');
INSERT INTO `sys_roles_menus` VALUES ('1', '7');
INSERT INTO `sys_roles_menus` VALUES ('1', '8');
INSERT INTO `sys_roles_menus` VALUES ('1', '9');
INSERT INTO `sys_roles_menus` VALUES ('1', '10');
INSERT INTO `sys_roles_menus` VALUES ('1', '11');
INSERT INTO `sys_roles_menus` VALUES ('1', '12');
INSERT INTO `sys_roles_menus` VALUES ('1', '13');
INSERT INTO `sys_roles_menus` VALUES ('1', '14');
INSERT INTO `sys_roles_menus` VALUES ('1', '15');
INSERT INTO `sys_roles_menus` VALUES ('1', '16');
INSERT INTO `sys_roles_menus` VALUES ('1', '17');
INSERT INTO `sys_roles_menus` VALUES ('1', '18');
INSERT INTO `sys_roles_menus` VALUES ('1', '19');
INSERT INTO `sys_roles_menus` VALUES ('1', '21');
INSERT INTO `sys_roles_menus` VALUES ('1', '22');
INSERT INTO `sys_roles_menus` VALUES ('1', '23');
INSERT INTO `sys_roles_menus` VALUES ('1', '24');
INSERT INTO `sys_roles_menus` VALUES ('1', '27');
INSERT INTO `sys_roles_menus` VALUES ('1', '28');
INSERT INTO `sys_roles_menus` VALUES ('1', '30');
INSERT INTO `sys_roles_menus` VALUES ('1', '32');
INSERT INTO `sys_roles_menus` VALUES ('2', '1');
INSERT INTO `sys_roles_menus` VALUES ('2', '2');
INSERT INTO `sys_roles_menus` VALUES ('2', '3');
INSERT INTO `sys_roles_menus` VALUES ('2', '4');
INSERT INTO `sys_roles_menus` VALUES ('2', '5');
INSERT INTO `sys_roles_menus` VALUES ('2', '6');
INSERT INTO `sys_roles_menus` VALUES ('2', '7');
INSERT INTO `sys_roles_menus` VALUES ('2', '8');
INSERT INTO `sys_roles_menus` VALUES ('2', '9');
INSERT INTO `sys_roles_menus` VALUES ('2', '12');
INSERT INTO `sys_roles_menus` VALUES ('2', '28');
INSERT INTO `sys_roles_menus` VALUES ('2', '30');
INSERT INTO `sys_roles_menus` VALUES ('2', '32');
INSERT INTO `sys_roles_menus` VALUES ('11', '1');
INSERT INTO `sys_roles_menus` VALUES ('11', '2');
INSERT INTO `sys_roles_menus` VALUES ('11', '3');
INSERT INTO `sys_roles_menus` VALUES ('11', '4');
INSERT INTO `sys_roles_menus` VALUES ('11', '5');
INSERT INTO `sys_roles_menus` VALUES ('11', '6');
INSERT INTO `sys_roles_menus` VALUES ('11', '7');
INSERT INTO `sys_roles_menus` VALUES ('11', '8');
INSERT INTO `sys_roles_menus` VALUES ('11', '9');
INSERT INTO `sys_roles_menus` VALUES ('11', '10');
INSERT INTO `sys_roles_menus` VALUES ('11', '11');
INSERT INTO `sys_roles_menus` VALUES ('11', '12');
INSERT INTO `sys_roles_menus` VALUES ('11', '13');
INSERT INTO `sys_roles_menus` VALUES ('11', '14');
INSERT INTO `sys_roles_menus` VALUES ('11', '15');
INSERT INTO `sys_roles_menus` VALUES ('11', '16');
INSERT INTO `sys_roles_menus` VALUES ('11', '18');
INSERT INTO `sys_roles_menus` VALUES ('11', '19');
INSERT INTO `sys_roles_menus` VALUES ('11', '28');
INSERT INTO `sys_roles_menus` VALUES ('11', '30');
INSERT INTO `sys_roles_menus` VALUES ('11', '32');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('23', '1');
INSERT INTO `sys_role_permission` VALUES ('29', '1');
INSERT INTO `sys_role_permission` VALUES ('8', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '1');
INSERT INTO `sys_role_permission` VALUES ('28', '1');
INSERT INTO `sys_role_permission` VALUES ('20', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '2');
INSERT INTO `sys_role_permission` VALUES ('2', '2');
INSERT INTO `sys_role_permission` VALUES ('9', '1');
INSERT INTO `sys_role_permission` VALUES ('25', '1');
INSERT INTO `sys_role_permission` VALUES ('19', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('26', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('13', '1');
INSERT INTO `sys_role_permission` VALUES ('27', '1');
INSERT INTO `sys_role_permission` VALUES ('12', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '1');
INSERT INTO `sys_role_permission` VALUES ('15', '1');
INSERT INTO `sys_role_permission` VALUES ('21', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '1');
INSERT INTO `sys_role_permission` VALUES ('30', '1');
INSERT INTO `sys_role_permission` VALUES ('22', '1');
INSERT INTO `sys_role_permission` VALUES ('11', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('43', 'admin', '44c071210f82b42b1dda7bf3dcad348d', '2bbf27adcf3c259df147643d6fe70a23', '1', '787824374@qq.com', 'https://s2.ax1x.com/2019/03/23/AGO1q1.jpg', '2019-03-27 10:15:54');
INSERT INTO `sys_user` VALUES ('39', 'qqq', 'ba256b383020d3ccaa3c92e76499c45b', '79d485fa7dfab115fcf9f9eb56a9fc07', '1', 'nihao@qq.com', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1956623052,720822838&fm=26&gp=0.jpg', '2019-03-27 10:15:54');
INSERT INTO `sys_user` VALUES ('1', 'miv', '44c071210f82b42b1dda7bf3dcad348d', '2bbf27adcf3c259df147643d6fe70a23', '1', 'miv@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-27 11:44:03');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `uid` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
  KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('39', '2');
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('39', '1');
INSERT INTO `sys_user_role` VALUES ('42', '1');

-- ----------------------------
-- Table structure for test_student
-- ----------------------------
DROP TABLE IF EXISTS `test_student`;
CREATE TABLE `test_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(12) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_student
-- ----------------------------
INSERT INTO `test_student` VALUES ('1', 'aa', '12', 'asds');
