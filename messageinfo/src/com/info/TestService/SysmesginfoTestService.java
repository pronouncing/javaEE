package com.info.TestService;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.info.model.mesginfo;
import com.info.service.IMesginfoService;
import com.lovo.framework.model.Page;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring*.xml" })

public class SysmesginfoTestService {
  @Resource
  private IMesginfoService sms;
  //���
  @Test
  @Rollback(value = false)
  public void addMesginfo() throws Exception {
    // ����ԴService����
    mesginfo m =new mesginfo();
    // ����Դ����
    m.setMessage("555");
    // ����
    sms.addMesginfo(m);
    System.out.println("��ӳɹ���");
  }
  
//��ѯ����
  @Test
  @Rollback(value = true)
  public void selectMesginfo() throws Exception {
    // ���԰�Service����
    System.out.println("=============");
    List<mesginfo> listMesginfo = sms.findAll();
    
    for (mesginfo mesginfo : listMesginfo) {
      System.out.println(mesginfo.getMessage()+" "+mesginfo.getMessageinfo());
    }
    System.out.println("��ѯ�ɹ�");
  }
  
  // ��ҳ��ѯ
  @Test
  public void pageSelect() throws Exception {
	  Page page= sms.getUserByPage(1, 3, null);
    System.out.println(page+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	List<mesginfo> list = page.getData();
	for(int i = 0;i < list.size();i++){
//		System.out.println(list.get(i));
		System.out.println(list.get(i).getId());
		System.out.println(list.get(i).getMessage());
		System.out.println(list.get(i).getMessageinfo());
	}
    System.out.println(page+"============================================================");
}
  
}
