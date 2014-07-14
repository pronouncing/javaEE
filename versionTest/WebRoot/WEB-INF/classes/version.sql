


CREATE TABLE t_version(
	v_id 	   INT PRIMARY KEY  AUTO_INCREMENT, /*主键自动增长*/
	v_apkName VARCHAR(100),	/*APK名称*/
	v_apkUrl  VARCHAR(500),	/*APK下载地址*/
	v_verBug  VARCHAR(500), /*更新内容*/
	v_verCode  INT NOT NULL,/*serverCode  版本号*/
	v_verName  VARCHAR(100),/*serverName 版本名称*/
	v_dataTime DATETIME 
)ENGINE=INNODB;	
SELECT * FROM t_version
DROP TABLE t_version
TRUNCATE TABLE t_version
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','阿克苏政府新版本增加删除功能','2','1.1.2','2014-07-5');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','阿克苏政府新版本增加删除功能','3','1.2.5','2014-07-6');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','阿克苏政府新版本增加删除功能','4','1.3.8','2014-07-7');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','阿克苏政府新版本增加删除功能','5','1.4.2','2014-07-8');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','阿克苏政府新版本增加删除功能','6','1.5.5','2014-07-9');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','阿克苏政府新版本增加删除功能','7','1.6.8','2014-07-10');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','阿克苏政府新版本增加删除功能','8','1.7.2','2014-07-11');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','手机卫士Android版V5.2.3 正式版
1.内存占用减少30%，安装包大小减少17%；
2.诈骗电话拦截能力提高30%；
3.新增电视购物诈骗电话自动拦截；
4.提升可疑应用的清理能力，强化支付安全保障体系；
5.新增手机存储空间分析功能，解决手机空间不足问题；
6.清理加速升级云端识别方案，清理效果提升120%；
7.照片、短信删除了还能被找到！用隐私粉碎机，彻底粉碎！
8.支付保镖全新改版，全新防护体系重装上阵，360度无死角保护支付安全。 ','9','1.8.6','2014-07-11 23:14:01');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://lh.lihuapu.com/Menudemo.apk','手机卫士Android版V5.2.3 正式版
1.内存占用减少30%，安装包大小减少17%；
2.诈骗电话拦截能力提高30%；
3.新增电视购物诈骗电话自动拦截；
4.提升可疑应用的清理能力，强化支付安全保障体系；
5.新增手机存储空间分析功能，解决手机空间不足问题；
6.清理加速升级云端识别方案，清理效果提升120%；
7.照片、短信删除了还能被找到！用隐私粉碎机，彻底粉碎！
8.支付保镖全新改版，全新防护体系重装上阵，360度无死角保护支付安全。 ','9','1.8.6','2014-07-11 23:15:02');

INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('阿克苏政府','http://192.168.0.100:8080/infoandroid/jsonMenuDemoInfo.apk
','手机卫士Android版V5.2.3 正式版
1.内存占用减少30%，安装包大小减少17%；
2.诈骗电话拦截能力提高30%；
3.新增电视购物诈骗电话自动拦截；
4.提升可疑应用的清理能力，强化支付安全保障体系；
5.新增手机存储空间分析功能，解决手机空间不足问题；
6.清理加速升级云端识别方案，清理效果提升120%；
7.照片、短信删除了还能被找到！用隐私粉碎机，彻底粉碎！
8.支付保镖全新改版，全新防护体系重装上阵，360度无死角保护支付安全。 ','10','1.8.8','2014-07-13 15:06:05');



INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('乌鲁木齐政府','http://lh.lihuapu.com/Menudemo.apk','乌鲁木齐政府聊天','2','1.1.2','2014-07-8');
INSERT INTO t_version(v_apkName,v_apkUrl,v_verBug,v_verCode,v_verName,v_dataTime)VALUES('乌鲁木齐政府','http://lh.lihuapu.com/Menudemo.apk','乌鲁木齐政府广播','3','1.2.5','2014-07-11');


SELECT * FROM t_version ORDER BY v_dataTime DESC  LIMIT 1;
SELECT * FROM t_version WHERE v_apkName='阿克苏政府'  ORDER BY v_dataTime DESC  LIMIT 1;
SELECT * FROM t_version WHERE v_apkName='乌鲁木齐政府'  ORDER BY v_dataTime DESC  LIMIT 1;



