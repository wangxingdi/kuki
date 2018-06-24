/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50150
Source Host           : localhost:3306
Source Database       : kuki

Target Server Type    : MYSQL
Target Server Version : 50150
File Encoding         : 65001

Date: 2018-06-24 23:37:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kuki_basic_menu
-- ----------------------------
DROP TABLE IF EXISTS `kuki_basic_menu`;
CREATE TABLE `kuki_basic_menu` (
  `menu_id` varchar(32) NOT NULL COMMENT '主键',
  `parent_id` varchar(32) NOT NULL COMMENT '父级主键',
  `menu_code` varchar(32) DEFAULT NULL COMMENT '菜单代码',
  `menu_name` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `sequence` int(3) DEFAULT NULL COMMENT '排序',
  `status` varchar(1) DEFAULT NULL COMMENT '状态：1-启用；0-停用',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kuki_basic_menu
-- ----------------------------

-- ----------------------------
-- Table structure for kuki_basic_param
-- ----------------------------
DROP TABLE IF EXISTS `kuki_basic_param`;
CREATE TABLE `kuki_basic_param` (
  `param_id` varchar(32) NOT NULL COMMENT '主键',
  `module` varchar(16) DEFAULT NULL COMMENT '模块',
  `param_name` varchar(32) DEFAULT NULL COMMENT '参数名称',
  `param_value` varchar(8) DEFAULT NULL COMMENT '参数值',
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
-- Records of kuki_basic_param
-- ----------------------------

-- ----------------------------
-- Table structure for kuki_basic_role
-- ----------------------------
DROP TABLE IF EXISTS `kuki_basic_role`;
CREATE TABLE `kuki_basic_role` (
  `role_id` varchar(32) NOT NULL COMMENT '主键',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(128) DEFAULT NULL COMMENT '角色描述',
  `status` varchar(1) DEFAULT NULL COMMENT '状态:0-停用;1-启用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of kuki_basic_role
-- ----------------------------

-- ----------------------------
-- Table structure for kuki_basic_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `kuki_basic_role_menu`;
CREATE TABLE `kuki_basic_role_menu` (
  `role_id` varchar(32) NOT NULL COMMENT '角色主键',
  `menu_id` varchar(32) NOT NULL COMMENT '菜单主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kuki_basic_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for kuki_basic_role_user
-- ----------------------------
DROP TABLE IF EXISTS `kuki_basic_role_user`;
CREATE TABLE `kuki_basic_role_user` (
  `role_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kuki_basic_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for kuki_basic_user
-- ----------------------------
DROP TABLE IF EXISTS `kuki_basic_user`;
CREATE TABLE `kuki_basic_user` (
  `user_id` varchar(32) NOT NULL COMMENT '主键',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(32) DEFAULT NULL COMMENT '密码',
  `email` varchar(32) DEFAULT NULL COMMENT '电子邮箱',
  `status` varchar(1) DEFAULT NULL COMMENT '状态：1-正常；0-锁定',
  `mobile` varchar(16) DEFAULT NULL COMMENT '联系方式',
  `telephone` varchar(16) DEFAULT NULL,
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `index_id` (`user_id`),
  UNIQUE KEY `index_username` (`username`),
  KEY `index_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of kuki_basic_user
-- ----------------------------
