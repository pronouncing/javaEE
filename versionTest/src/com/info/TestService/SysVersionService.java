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
	 // ��ѯ����
  @Test
  @Rollback(value = true)

  public void selectVersion() throws Exception{
	System.out.println("===========================");
	List<Version> listVersion = sms.findVersion();
	/**
	 * HQLд����ѯ��ʽ
	 */
	for (Version version : listVersion) {
			System.out.println("APPӦ������	"+version.getApkName()+"	APK���ص�ַ	"+version.getApkUrl()+"	�°汾��������	"+version.getVerBug()+"�汾	"+version.getVerCode()+"�汾��	"+version.getVerName()+"�汾ʱ��		"+version.getDataTime());
	}
	/**
	 * Sqlд����ѯ��ʽ
	 */
	/*Sqlд��
	 * //���Իص������Ĳ�ѯ1�����ݸ���ʱ�䵹���ѯ
	for (Iterator it = listVersion.iterator(); it.hasNext();) {
		Object[] obj= (Object[]) it.next();
		System.out.println(obj[1]+"  "+obj[2]+"	"+obj[3]+"	"+obj[4]+"	"+obj[5]);
	}*/
  }
  
//��ҳ��ѯ
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
