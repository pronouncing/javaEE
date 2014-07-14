package com.info.service;

import java.util.List;
import java.util.Map;

import com.info.model.mesginfo;
import com.lovo.framework.model.Page;

public interface IMesginfoService {
  //添加方法
  public void addMesginfo(mesginfo addmesginfo) throws Exception;
  // 查询所有
  public List<mesginfo> findAll() throws Exception;
  // 分页
	public Page getUserByPage(int pageNo, int pageSize,Map params);
}
