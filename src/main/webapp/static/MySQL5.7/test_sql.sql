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

 Date: 12/03/2019 14:49:36
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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
-- Table structure for tbl_blog_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_blog_type`;
CREATE TABLE `tbl_blog_type`  (
  `type_id` int(11) UNSIGNED NOT NULL,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
-- Table structure for tbl_user_power
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_power`;
CREATE TABLE `tbl_user_power`  (
  `power_id` int(11) UNSIGNED NOT NULL,
  `power_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`power_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
