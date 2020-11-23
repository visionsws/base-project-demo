-- ----------------------------
-- Table structure for sa_subject
-- ----------------------------
DROP TABLE IF EXISTS `sa_subject`;
CREATE TABLE `sa_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `pic` varchar(500) DEFAULT NULL COMMENT '专题主图',
  `product_count` int(11) DEFAULT NULL COMMENT '关联产品数量',
  `recommend_status` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `collect_count` int(11) DEFAULT NULL,
  `read_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  `album_pics` varchar(1000) DEFAULT NULL COMMENT '画册图片用逗号分割',
  `description` varchar(1000) DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `content` text,
  `forward_count` int(11) DEFAULT NULL COMMENT '转发数',
  `category_name` varchar(200) DEFAULT NULL COMMENT '专题分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='专题表';

-- ----------------------------
-- Records of sa_subject
-- ----------------------------
INSERT INTO `sa_subject` VALUES ('1', '1', 'polo衬衫的也时尚', null, null, null, '2018-11-11 13:26:55', null, null, null, null, null, null, null, null, '服装专题');
INSERT INTO `sa_subject` VALUES ('2', '2', '大牌手机低价秒', null, null, null, '2018-11-12 13:27:00', null, null, null, null, null, null, null, null, '手机专题');
INSERT INTO `sa_subject` VALUES ('3', '2', '晓龙845新品上市', null, null, null, '2018-11-13 13:27:05', null, null, null, null, null, null, null, null, '手机专题');
INSERT INTO `sa_subject` VALUES ('4', '1', '夏天应该穿什么', null, null, null, '2018-11-01 13:27:09', null, null, null, null, null, null, null, null, '服装专题');
INSERT INTO `sa_subject` VALUES ('5', '1', '夏季精选', null, null, null, '2018-11-06 13:27:18', null, null, null, null, null, null, null, null, '服装专题');
INSERT INTO `sa_subject` VALUES ('6', '2', '品牌手机降价', null, null, null, '2018-11-07 13:27:21', null, null, null, null, null, null, null, null, '手机专题');

-- ----------------------------
-- Table structure for sa_subject_category
-- ----------------------------
DROP TABLE IF EXISTS `sa_subject_category`;
CREATE TABLE `sa_subject_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
  `subject_count` int(11) DEFAULT NULL COMMENT '专题数量',
  `show_status` int(2) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='专题分类表';

-- ----------------------------
-- Records of sa_subject_category
-- ----------------------------
INSERT INTO `sa_subject_category` VALUES ('1', '服装专题', null, null, null, null);
INSERT INTO `sa_subject_category` VALUES ('2', '手机专题', null, null, null, null);

-- ----------------------------
-- Table structure for sa_subject_comment
-- ----------------------------
DROP TABLE IF EXISTS `sa_subject_comment`;
CREATE TABLE `sa_subject_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `show_status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题评论表';

-- ----------------------------
-- Records of sa_subject_comment
-- ----------------------------

-- ----------------------------
-- Table structure for sa_subject_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `sa_subject_product_relation`;
CREATE TABLE `sa_subject_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='专题商品关系表';

-- ----------------------------
-- Records of sa_subject_product_relation
-- ----------------------------
INSERT INTO `sa_subject_product_relation` VALUES ('1', '1', '12');
INSERT INTO `sa_subject_product_relation` VALUES ('2', '1', '13');
INSERT INTO `sa_subject_product_relation` VALUES ('3', '1', '14');
INSERT INTO `sa_subject_product_relation` VALUES ('4', '1', '18');
INSERT INTO `sa_subject_product_relation` VALUES ('5', '1', '7');
INSERT INTO `sa_subject_product_relation` VALUES ('6', '2', '7');
INSERT INTO `sa_subject_product_relation` VALUES ('7', '1', '22');
INSERT INTO `sa_subject_product_relation` VALUES ('29', '1', '23');
INSERT INTO `sa_subject_product_relation` VALUES ('30', '4', '23');
INSERT INTO `sa_subject_product_relation` VALUES ('31', '5', '23');
INSERT INTO `sa_subject_product_relation` VALUES ('41', '2', '26');
INSERT INTO `sa_subject_product_relation` VALUES ('42', '3', '26');
INSERT INTO `sa_subject_product_relation` VALUES ('43', '6', '26');
