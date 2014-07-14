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
  //添加
  @Test
  @Rollback(value = false)
  public void addMesginfo() throws Exception {
    // 数据源Service测试
    mesginfo m =new mesginfo();
    // 数据源名称
    m.setMessage("555");
    // 保存
    sms.addMesginfo(m);
    System.out.println("添加成功！");
  }
  
//查询所有
  @Test
  @Rollback(value = true)
  public void selectMesginfo() throws Exception {
    // 留言板Service测试
    System.out.println("=============");
    List<mesginfo> listMesginfo = sms.findAll();
    
    for (mesginfo mesginfo : listMesginfo) {
      System.out.println(mesginfo.getMessage()+" "+mesginfo.getMessageinfo());
    }
    System.out.println("查询成功");
  }
  
  // 分页查询
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
