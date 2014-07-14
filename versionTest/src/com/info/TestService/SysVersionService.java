package com.info.TestService;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.info.model.Version;
import com.info.service.IVersionService;
import com.lovo.framework.model.Page;


@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring*.xml" })
public class SysVersionService {
	@Resource
	private IVersionService sms;
	 // 查询所有
  @Test
  @Rollback(value = true)

  public void selectVersion() throws Exception{
	System.out.println("===========================");
	List<Version> listVersion = sms.findVersion();
	/**
	 * HQL写法查询方式
	 */
	for (Version version : listVersion) {
			System.out.println("APP应用名称	"+version.getApkName()+"	APK下载地址	"+version.getApkUrl()+"	新版本跟新内容	"+version.getVerBug()+"版本	"+version.getVerCode()+"版本号	"+version.getVerName()+"版本时间		"+version.getDataTime());
	}
	/**
	 * Sql写法查询方式
	 */
	/*Sql写法
	 * //测试回调方法的查询1条数据根据时间倒序查询
	for (Iterator it = listVersion.iterator(); it.hasNext();) {
		Object[] obj= (Object[]) it.next();
		System.out.println(obj[1]+"  "+obj[2]+"	"+obj[3]+"	"+obj[4]+"	"+obj[5]);
	}*/
  }
  
//分页查询
/*  @Test
  public void pageSelect() throws Exception {
	  Page page= sms.getUserByPage(1, 1, null);
    System.out.println(page+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	List<Version> list = page.getData();
	for(int i = 0;i < list.size();i++){
		System.out.println("		"+list.get(i).getVerCode()+"		"+list.get(i).getVerName()+"		"+list.get(i).getDataTime());
	}
    System.out.println(page+"============================================================");
  }*/
}
