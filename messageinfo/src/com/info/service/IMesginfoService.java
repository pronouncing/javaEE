package com.info.service;

import java.util.List;
import java.util.Map;

import com.info.model.mesginfo;
import com.lovo.framework.model.Page;

public interface IMesginfoService {
  //��ӷ���
  public void addMesginfo(mesginfo addmesginfo) throws Exception;
  // ��ѯ����
  public List<mesginfo> findAll() throws Exception;
  // ��ҳ
	public Page getUserByPage(int pageNo, int pageSize,Map params);
}
