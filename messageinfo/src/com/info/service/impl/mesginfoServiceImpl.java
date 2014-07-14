package com.info.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.model.mesginfo;
import com.info.service.IMesginfoService;
import com.lovo.framework.model.Page;
import com.lovo.framework.persistence.IBaseDao;

@Service(value = "IMesginfoService")
@Transactional(readOnly = false)
public class mesginfoServiceImpl implements IMesginfoService {

  @Resource
  private IBaseDao dao;

  public void addMesginfo(mesginfo addmesginfo) throws Exception {
    dao.addEntity(addmesginfo);
  }

  public List<mesginfo> findAll() throws Exception {
    return dao.queryEntitys("from mesginfo m ", new Object[] {});
  }
  /**
   * ∑÷“≥œ‘ æ
   */
public Page getUserByPage(int pageNo, int pageSize, Map params) {
	return dao.queryEntityByPage(pageNo, pageSize, "from mesginfo v ",new Object[] {});
}

}
