package com.info.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.ConnectionEvent;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.info.model.Version;
import com.info.service.IVersionService;
import com.lovo.framework.model.Page;
import com.lovo.framework.persistence.IBaseDao;


@Service(value = "IVersionService")
@Transactional(readOnly = false)
public class VersionServiceImpl implements IVersionService{
	@Resource
	  private IBaseDao dao;
	public List<Version> findVersion() throws Exception {
		return dao.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				/**
				 * HQLд��
				 */
				int m = 0;
				int n = 1;
				String x = "����������";
				String sql = "from Version m where m.apkName=? order by dataTime desc";
				Query query = session.createQuery(sql);
				query.setParameter(0, x);
				query.setFirstResult(m);// ��ʼ��¼
				query.setMaxResults(n);// ������¼
				return query.list();
				
				/**
				 * SQLд��
				 */
				
				/*//����ʱ�䵹�����в�ѯAPPӦ�ó���=����������APP����ʾ1��
				String sql = "SELECT * FROM t_version  WHERE v_apkName='����������'  ORDER BY v_dataTime DESC limit 1";
				Query query = session.createSQLQuery(sql);	
				return query.list();*/
				
				
			}
		});
		}
	public Page getUserByPage(int pageNo, int pageSize, Map params) {
		
		return dao.queryEntityByPage(pageNo, pageSize, "from Version v order by dataTime desc",new Object[] {});
	}

}
