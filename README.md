# 钰网——改变生活
这是我的个人项目

```mysql
use changedb;
############################## 用户登录表 ##############################
CREATE TABLE userlogin(
                          login_id NVARCHAR(11)    COMMENT '登录ID 用于关联用户账号' ,
                          login_accoun NVARCHAR(11)    COMMENT '用户账号 用户的登录账号（一般为手机号）' ,
                          login_password NVARCHAR(20)    COMMENT '用户密码 用户的登录密码' ,
                          PRIMARY KEY (login_id)
) COMMENT = '用户登录 ';
insert into userlogin(login_id, login_accoun, login_password) values('admin','admin','123456');
insert into userlogin(login_id, login_accoun, login_password) values('aaa','upzhu','123456');
insert into userlogin(login_id, login_accoun, login_password) values('bbb','users','123456');


############################## 用户信息表 ##############################
CREATE TABLE userinfo(
                         info_id INT  AUTO_INCREMENT  COMMENT '信息主键' ,
                         info_name NVARCHAR(10)    COMMENT '用户姓名' ,
                         info_gender NVARCHAR(1)    COMMENT '性别' ,
                         info_birthday DATETIME    COMMENT '出生日期' ,
                         info_email NVARCHAR(20)    COMMENT '邮箱' ,
                         info_address NVARCHAR(20)    COMMENT '联系地址' ,
                         info_age INT    COMMENT '年龄' ,
                         info_img NVARCHAR(100) COMMENT '头像',
                         info_desc NVARCHAR(300)    COMMENT '个人简介' ,
                         login_uid NVARCHAR(11) COMMENT '关联用户账号密码表 关联用户登录表',
                         PRIMARY KEY (info_id)
) COMMENT = '用户信息 ';
insert into userinfo(info_name,info_img,login_uid) values('爱的就是你','/static/images/1.png','bbb');
insert into userinfo(info_name,info_img,login_uid) values('爱man','/static/images/1.png','aaa');


############################## 权限身份表 ##############################
CREATE TABLE status(
                       status_id INT  AUTO_INCREMENT  COMMENT '身份编号' ,
                       status_name NVARCHAR(10)  COMMENT '身份' ,
                       status_description nvarchar(20)  comment '身份备注',
                       PRIMARY KEY (status_id)
) COMMENT = '权限身份表';
insert into status(status_name,status_description) values ('管理员','一个管理者');
insert into status(status_name,status_description) values('审核员','一个审核的审核员');


############################# 用户身份表 ###################################
create table identity(
        identity_id INT  AUTO_INCREMENT  COMMENT '身份编号' ,
        identity_name NVARCHAR(10)  COMMENT '身份',
        primary key (identity_id)
)COMMENT = '用户身份表';
insert into identity(identity_name) values ('VIP用户');
insert into identity(identity_name) values ('UP主');
insert into identity(identity_name) values ('用户');


############################## 用户身份关联表 #############################
create table login_identity(
    identity_ids INT  COMMENT '用户身份' ,
    user_ids NVARCHAR(11)  COMMENT '用户编码' ,
    PRIMARY KEY (identity_ids,user_ids)
)COMMENT = '用户身份关联表 ';
insert into login_identity(identity_ids, user_ids) values(1,'bbb');
insert into login_identity(identity_ids, user_ids) values(2,'aaa');





############################## 权限身份关联表 ##############################
CREATE TABLE user_status(
                              status_ids INT  COMMENT '用户身份' ,
                              user_ids NVARCHAR(11)  COMMENT '用户编码' ,
                              PRIMARY KEY (status_ids,user_ids)
) COMMENT = '权限身份关联表 ';
insert into user_status(status_ids, user_ids) values(1,'admin');





############################## 权限地址表 ##############################
create table menu(
    menu_id nvarchar(20),
    menu_name nvarchar(20),
    menu_pid int(11),
    menu_url nvarchar(100),
    PRIMARY KEY(menu_id)
) comment = '地址表';
insert into menu values('1','用户管理',0,'#');
insert into menu values('2','视频管理',0,'#');
insert into menu values('3','角色管理',0,'#');
insert into menu values('1.1','用户信息',1,'/user/inUser');
insert into menu values('1.2','管理员信息',1,'/admin/inAdmin');
insert into menu values('3.1','角色信息',3,'/role/inRole');




############################## 身份地址关联表 ##############################
create table status_menu(
        s_id int(11),
        m_id nvarchar(20),
        PRIMARY KEY (s_id,m_id)
)comment = '身份地址表';
insert into status_menu values(1,'1');
insert into status_menu values(1,'2');
insert into status_menu values(1,'3');
insert into status_menu values(1,'1.1');
insert into status_menu values(1,'1.2');
insert into status_menu values(1,'3.1');
insert into status_menu values();




############################## 视频类别表 ##############################
CREATE TABLE videotype(
                           type_id INT    COMMENT '类别序号' ,
                           type_name NVARCHAR(10)    COMMENT '类别名' ,
                           PRIMARY KEY (type_id)
) COMMENT = '视频类别表 ';
insert into videotype(type_name) values('动漫');


############################## 视频表 ##############################
CREATE TABLE video(
                      video_id NVARCHAR(11) NOT NULL   COMMENT '视频编号' ,
                      video_name NVARCHAR(20)    COMMENT '视频名称' ,
                      video_releasetime DATETIME    COMMENT '创建时间' ,
                      video_rublisher NVARCHAR(11)    COMMENT '视频发布者' ,
                      video_introduction NVARCHAR(512)    COMMENT '视频简介' ,
                      video_address NVARCHAR(64)    COMMENT '视频地址' ,
                      video_audit NVARCHAR(1)    COMMENT '视频审核' ,
                      PRIMARY KEY (video_id)
                      #FOREIGN KEY(video_rublisher) references userlogin(login_id)
) COMMENT = '视频类别表';



############################## 视频类型关联表 ##############################
CREATE TABLE video_types(
                           vt_id INT  AUTO_INCREMENT  COMMENT '连接编号' ,
                           vt_video NVARCHAR(32)    COMMENT '关联电影' ,
                           vt_type INT    COMMENT '关联类别表' ,
                           PRIMARY KEY (vt_id)
                         #  FOREIGN KEY(vt_video) references video(video_id),
                          # FOREIGN KEY(vt_type) references videotype(type_id)
) COMMENT = '电影连接表';

```

