package com.info.service;

import java.util.List;
import java.util.Map;

import com.info.model.Version;
import com.lovo.framework.model.Page;


public interface IVersionService {
	  // ��ҳ
	public Page getUserByPage(int pageNo, int pageSize,Map params);
	  // ��ѯ����
//	  public List<Version> findAll() throws Exception;
	 public List<Version> findVersion() throws Exception;
}
