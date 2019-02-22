# drop table staff;
# CREATE TABLE `staff` (
#           `id` int(11) unsigned NOT NULL  AUTO_INCREMENT,
#           `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '',
#           `gender` int(1) NOT NULL DEFAULT '0',
#           `img` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '头像',
#           `document_type` int(1) NOT NULL DEFAULT '0' COMMENT '证件类型',
#           `document_number` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '证件号',
#           `status` int(1) NOT NULL DEFAULT '0',
#           `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '创建人',
#           `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
#           `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '修改人',
#           `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
#           `delete_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '删除人',
#           `delete_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
#           PRIMARY KEY (`id`),
#           KEY `ix_doc_num` (`document_number`)
#         ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;
# insert into staff ('name','gender','document_type','document_number','status','create_by')
#             values ('luzhiqing',0,0,'522122199503207416',0,'system');
# insert into staff ('name','gender','document_type','document_number','status','create_by')
#             values ('zangsan',0,0,'522122199503207416',0,'system');
# insert into staff ('name','gender','document_type','document_number','status','create_by')
#             values ('lisi',0,0,'522122199503207416',0,'system');
# insert into staff ('name','gender','document_type','document_number','status','create_by')
#             values ('wangwu',0,0,'522122199503207416',0,'system');
# insert into staff ('name','gender','document_type','document_number','status','create_by')
#             values ('zhaoliu',0,0,'522122199503207416',0,'system');
# insert into staff ('name','gender','document_type','document_number','status','create_by')
#             values ('haungqi',0,0,'522122199503207416',0,'system');
# insert into staff ('name','gender','document_type','document_number','status','create_by')
#             values ('louba',0,0,'522122199503207416',0,'system');
#
#
