package com.info.service;

import java.util.List;
import java.util.Map;

import com.info.model.Version;
import com.lovo.framework.model.Page;


public interface IVersionService {
	  // 分页
	public Page getUserByPage(int pageNo, int pageSize,Map params);
	  // 查询所有
//	  public List<Version> findAll() throws Exception;
	 public List<Version> findVersion() throws Exception;
}
