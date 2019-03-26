/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : jfun

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-03-26 16:20:22
*/

SET FOREIGN_KEY_CHECKS=0;

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
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
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
  `id` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `resource_type` enum('menu','button') DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '\0', '用户管理', '0', '0/', 'user:list', 'menu', 'userInfo/userList');
INSERT INTO `sys_permission` VALUES ('2', '\0', '用户添加', '1', '0/1', 'user:add', 'button', 'userInfo/userAdd');
INSERT INTO `sys_permission` VALUES ('3', '\0', '用户删除', '1', '0/1', 'user:del', 'button', 'userInfo/userDel');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '\0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('2', '\0', 'VIP会员', 'vip');
INSERT INTO `sys_role` VALUES ('3', '', 'test', 'test');

-- ----------------------------
-- Table structure for sys_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_menus`;
CREATE TABLE `sys_roles_menus` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`menu_id`,`role_id`) USING BTREE,
  KEY `FKcngg2qadojhi3a651a5adkvbq` (`role_id`) USING BTREE,
  CONSTRAINT `sys_roles_menus_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `sys_roles_menus_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
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
INSERT INTO `sys_roles_menus` VALUES ('2', '6');
INSERT INTO `sys_roles_menus` VALUES ('2', '10');
INSERT INTO `sys_roles_menus` VALUES ('2', '11');
INSERT INTO `sys_roles_menus` VALUES ('2', '12');
INSERT INTO `sys_roles_menus` VALUES ('2', '13');
INSERT INTO `sys_roles_menus` VALUES ('2', '15');
INSERT INTO `sys_roles_menus` VALUES ('2', '16');
INSERT INTO `sys_roles_menus` VALUES ('2', '17');
INSERT INTO `sys_roles_menus` VALUES ('2', '21');
INSERT INTO `sys_roles_menus` VALUES ('2', '22');
INSERT INTO `sys_roles_menus` VALUES ('2', '23');
INSERT INTO `sys_roles_menus` VALUES ('2', '24');
INSERT INTO `sys_roles_menus` VALUES ('2', '27');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`),
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '787824374@qq.com', 'https://s2.ax1x.com/2019/03/23/AGO1q1.jpg', '2019-03-23 00:00:00');
INSERT INTO `sys_user` VALUES ('2', '管理员2', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '787824374@qq.com', 'https://s2.ax1x.com/2019/03/23/AGO1q1.jpg', '2019-03-23 00:00:00');
INSERT INTO `sys_user` VALUES ('3', '管理员3', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '787824374@qq.com', 'https://s2.ax1x.com/2019/03/23/AGO1q1.jpg', '2019-03-23 00:00:00');
INSERT INTO `sys_user` VALUES ('4', '管理员4', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '787824374@qq.com', 'https://s2.ax1x.com/2019/03/23/AGO1q1.jpg', '2019-03-06 00:00:00');
INSERT INTO `sys_user` VALUES ('5', '管理员5', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '787824374@qq.com', 'https://s2.ax1x.com/2019/03/23/AGO1q1.jpg', '2019-03-05 00:00:00');
INSERT INTO `sys_user` VALUES ('6', '管理员6', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '787824374@qq.com', 'https://s2.ax1x.com/2019/03/23/AGO1q1.jpg', '2019-03-09 00:00:00');
INSERT INTO `sys_user` VALUES ('31', 'miv', '5be3f223513680f64ea5ddcc9fab15e3', 'efc5315f0fff3e107c49d170d641dcec', '1', 'miv@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:15:59');
INSERT INTO `sys_user` VALUES ('30', 'xxx', '620dbcd7525d5143cf1bed1a4861390b', '0b0adf8f1985836833e9d6664d7ecfba', '1', 'aaab@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:09:14');
INSERT INTO `sys_user` VALUES ('32', '我是你爸爸', '017de82410cc9e4bdf155fe2cd85d575', '46f4c123ac76229637f50fa285908585', '1', 'wsnbb@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:19:20');
INSERT INTO `sys_user` VALUES ('33', 'aaaa2', 'a425307ba6285883eb34a9d51242483b', '1532ba053203d98a57869b7afcf13d161', '1', '23aaaa@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:20:22');
INSERT INTO `sys_user` VALUES ('34', 'avas', '5441d7fc737ece050057894273315878', 'fc43b70f31614e43416b5288012400c0', '1', 'adfsa@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:21:21');
INSERT INTO `sys_user` VALUES ('35', 'aqqq', 'a2fee07d09ef206e014ff66d96102d5a', '696833f4f2cfb27044ad5cad6e9c22a4', '1', 'aaqq@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:25:06');
INSERT INTO `sys_user` VALUES ('36', 'asd12', 'd2e4001ca20ffa179e598d82f5065730', '58460b909f14e3ed5f97721d19fca2e6', '1', 'asd12@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:26:37');
INSERT INTO `sys_user` VALUES ('37', 'baaaaa', '185d23628bd9c3cbb1542e1516dd50e0', '07cd81c461298b1750a7fa5a7869a6e5', '2', 'baaaa@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:27:23');
INSERT INTO `sys_user` VALUES ('38', 'abababa', '5d18e68d9443534a84f61f2a64687e5c', '6c2435db469a1df376d4e0f594c3877d', '1', 'bababa@qq.com', 'https://i.loli.net/2018/12/06/5c08894d8de21.jpg', '2019-03-26 15:28:10');

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
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('31', '1');
INSERT INTO `sys_user_role` VALUES ('30', '1');
INSERT INTO `sys_user_role` VALUES ('32', '1');
INSERT INTO `sys_user_role` VALUES ('33', '1');
INSERT INTO `sys_user_role` VALUES ('34', '1');
INSERT INTO `sys_user_role` VALUES ('35', '1');
INSERT INTO `sys_user_role` VALUES ('36', '1');
INSERT INTO `sys_user_role` VALUES ('37', '1');
INSERT INTO `sys_user_role` VALUES ('38', '1');
