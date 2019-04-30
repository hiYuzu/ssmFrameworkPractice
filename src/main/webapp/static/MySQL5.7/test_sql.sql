/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : test_sql

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 30/04/2019 11:30:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for data_login
-- ----------------------------
DROP TABLE IF EXISTS `data_login`;
CREATE TABLE `data_login`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT 'tbl_user外键',
  `remote_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `real_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实IP地址（防代理）',
  `opt_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_dl_ui`(`user_id`) USING BTREE,
  CONSTRAINT `fk_dl_ui` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data_login
-- ----------------------------
INSERT INTO `data_login` VALUES (1, 1, '127.0.0.1', '127.0.0.1', '2019-03-12 14:31:49');
INSERT INTO `data_login` VALUES (2, 1, '127.0.0.1', '127.0.0.1', '2019-03-12 14:32:37');
INSERT INTO `data_login` VALUES (3, 1, '127.0.0.1', '127.0.0.1', '2019-04-17 11:20:44');
INSERT INTO `data_login` VALUES (4, 1, '127.0.0.1', '127.0.0.1', '2019-04-17 11:21:09');
INSERT INTO `data_login` VALUES (5, 1, '127.0.0.1', '127.0.0.1', '2019-04-17 11:37:19');
INSERT INTO `data_login` VALUES (6, 1, '127.0.0.1', '127.0.0.1', '2019-04-17 11:52:43');
INSERT INTO `data_login` VALUES (7, 1, '127.0.0.1', '127.0.0.1', '2019-04-17 11:53:55');
INSERT INTO `data_login` VALUES (8, 1, '127.0.0.1', '127.0.0.1', '2019-04-17 14:01:22');
INSERT INTO `data_login` VALUES (9, 1, '127.0.0.1', '127.0.0.1', '2019-04-17 14:08:05');
INSERT INTO `data_login` VALUES (10, 1, '127.0.0.1', '127.0.0.1', '2019-04-17 14:16:35');
INSERT INTO `data_login` VALUES (11, 1, '127.0.0.1', '127.0.0.1', '2019-04-28 08:28:33');

-- ----------------------------
-- Table structure for tbl_blog
-- ----------------------------
DROP TABLE IF EXISTS `tbl_blog`;
CREATE TABLE `tbl_blog`  (
  `blog_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_id` int(11) UNSIGNED NOT NULL,
  `user_id` int(11) UNSIGNED NOT NULL,
  `blog_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `blog_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `blog_time` datetime(0) NOT NULL,
  `opt_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`blog_id`) USING BTREE,
  INDEX `fk_tb_tid`(`type_id`) USING BTREE,
  INDEX `fk_tb_uid`(`user_id`) USING BTREE,
  CONSTRAINT `fk_tb_tid` FOREIGN KEY (`type_id`) REFERENCES `tbl_blog_type` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_uid` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_blog
-- ----------------------------
INSERT INTO `tbl_blog` VALUES (1, 4, 1, '测试题目', '测试正文', '2018-12-19 08:19:11', '2018-12-19 08:19:14');

-- ----------------------------
-- Table structure for tbl_blog_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_blog_type`;
CREATE TABLE `tbl_blog_type`  (
  `type_id` int(11) UNSIGNED NOT NULL,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_blog_type
-- ----------------------------
INSERT INTO `tbl_blog_type` VALUES (1, '前台');
INSERT INTO `tbl_blog_type` VALUES (2, '后台');
INSERT INTO `tbl_blog_type` VALUES (3, '数据库');
INSERT INTO `tbl_blog_type` VALUES (4, '笔记');
INSERT INTO `tbl_blog_type` VALUES (5, '心得');

-- ----------------------------
-- Table structure for tbl_map
-- ----------------------------
DROP TABLE IF EXISTS `tbl_map`;
CREATE TABLE `tbl_map`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增',
  `device_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `lng` double(12, 6) NULL DEFAULT NULL COMMENT '坐标纬度',
  `lat` double(12, 6) NULL DEFAULT NULL COMMENT '坐标经度',
  `temp` int(11) NULL DEFAULT NULL COMMENT '温度',
  `hum` int(11) NULL DEFAULT NULL COMMENT '湿度',
  `accele_x` double(6, 3) NULL DEFAULT NULL COMMENT 'x轴加速度',
  `accele_y` double(6, 3) NULL DEFAULT NULL COMMENT 'y轴加速度',
  `accele_z` double(6, 3) NULL DEFAULT NULL COMMENT 'z轴加速度',
  `opt_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_map
-- ----------------------------
INSERT INTO `tbl_map` VALUES (1, '天津理工大学', 117.148000, 39.066000, 11, 64, 0.000, 0.000, 0.000, '2019-03-05 09:54:07');
INSERT INTO `tbl_map` VALUES (2, '裕兴酒家1', 117.213199, 39.153417, 25, 53, 0.000, 0.000, 9.810, '2019-04-17 11:41:41');
INSERT INTO `tbl_map` VALUES (3, '裕兴酒家2', 117.219726, 39.159348, 23, 52, 0.000, 0.000, 9.800, '2019-04-17 11:41:41');
INSERT INTO `tbl_map` VALUES (4, '裕兴酒家3', 117.219630, 39.159319, 25, 53, 0.000, 0.000, 9.950, '2019-04-17 11:41:41');
INSERT INTO `tbl_map` VALUES (5, '裕兴酒家4', 117.219866, 39.159386, 26, 55, 0.000, 0.000, 9.770, '2019-04-17 11:41:41');
INSERT INTO `tbl_map` VALUES (6, '裕兴酒家5', 117.219759, 39.159323, 24, 54, 0.000, 0.000, 9.700, '2019-04-17 11:41:42');
INSERT INTO `tbl_map` VALUES (7, '裕兴酒家6', 117.219893, 39.159377, 26, 52, 0.000, 0.000, 9.900, '2019-04-17 11:41:42');

-- ----------------------------
-- Table structure for tbl_sender
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sender`;
CREATE TABLE `tbl_sender`  (
  `sender_id` smallint(2) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sender_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sender_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sender_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `opt_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`sender_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_sender
-- ----------------------------
INSERT INTO `tbl_sender` VALUES (1, '你的名字', '你的联系方式', '你的留言...', '2018-11-05 13:28:40');
INSERT INTO `tbl_sender` VALUES (2, '你的名字', '你的联系方式', '你的留言...', '2018-11-05 13:28:43');
INSERT INTO `tbl_sender` VALUES (3, '你的名字', '你的联系方式', '你的留言...', '2018-11-26 16:02:34');
INSERT INTO `tbl_sender` VALUES (4, '你的名字', '你的联系方式', '你的留言...', '2018-11-26 16:02:24');
INSERT INTO `tbl_sender` VALUES (5, '赵晓阳', '17695982286', '你好,我是赵晓阳', '2018-11-05 13:28:52');
INSERT INTO `tbl_sender` VALUES (6, '18526877526', 'pomelo.yuzu1997@gmail.com', 'hello\nmy name is zhao\nthank you\ni love you\nbye~', '2018-11-05 13:28:56');
INSERT INTO `tbl_sender` VALUES (7, '你的名字', '你的电话', '你好\n我是赵\n谢谢你\n再见', '2018-11-26 16:02:12');
INSERT INTO `tbl_sender` VALUES (8, '你的名字', '你的联系方式', '你的留言...', '2018-11-05 13:29:04');
INSERT INTO `tbl_sender` VALUES (9, '你的名字', '你的联系方式', '你的留言...', '2018-11-05 13:29:07');
INSERT INTO `tbl_sender` VALUES (10, '你的名字', '你的联系方式', '你的留言...', '2018-11-05 11:42:08');
INSERT INTO `tbl_sender` VALUES (11, '测试', 'pomelo.yuzu1997@gmail.com', '这是一条测试数据\n2018/11/7 9:05', '2018-11-07 09:08:44');
INSERT INTO `tbl_sender` VALUES (13, 'zxy', '0536-7756368', 'this is a test data.\nthank you.', '2018-11-07 09:25:55');
INSERT INTO `tbl_sender` VALUES (14, '1', '1', '1', '2018-11-07 09:49:52');
INSERT INTO `tbl_sender` VALUES (15, '你的名字', '你的联系方式', '你的留言...', '2018-11-15 14:56:53');
INSERT INTO `tbl_sender` VALUES (16, '赵晓阳', '20181116', 'test\nv18.11.16', '2018-11-16 16:04:29');
INSERT INTO `tbl_sender` VALUES (17, '测试', '联系方式', '留言20181126', '2018-11-26 14:28:04');
INSERT INTO `tbl_sender` VALUES (18, '你的名字', '你的联系方式', '你的留言...', '2018-12-03 14:57:08');
INSERT INTO `tbl_sender` VALUES (19, '你的名字', '你的联系方式', '你的留言...', '2018-12-19 08:54:12');
INSERT INTO `tbl_sender` VALUES (20, '你的名字', '你的联系方式', '你的留言...', '2018-12-19 09:07:20');
INSERT INTO `tbl_sender` VALUES (21, '1', '1', '1', '2019-03-05 08:33:58');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `user_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `power_id` int(11) UNSIGNED NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '2',
  `user_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_age` int(11) UNSIGNED NULL DEFAULT NULL,
  `user_tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `opt_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `fk_tu_pid`(`power_id`) USING BTREE,
  CONSTRAINT `fk_tu_pid` FOREIGN KEY (`power_id`) REFERENCES `tbl_user_power` (`power_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (1, 1, 'pomelo', '男', 21, '17695982286', 'pomelo@163.com', 'a3a5fb13a9f9cae4971aac86b81ac2dd3712dd', '2018-12-19 08:05:18');

-- ----------------------------
-- Table structure for tbl_user_power
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_power`;
CREATE TABLE `tbl_user_power`  (
  `power_id` int(11) UNSIGNED NOT NULL,
  `power_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`power_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user_power
-- ----------------------------
INSERT INTO `tbl_user_power` VALUES (1, '管理员');
INSERT INTO `tbl_user_power` VALUES (2, '普通用户');

SET FOREIGN_KEY_CHECKS = 1;
