package com.info.action;

import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.info.commons.MyResponse;
import com.info.model.Version;
import com.info.service.IVersionService;
import com.lovo.framework.model.Page;
@Controller
public class VersionAction {
	public static final Logger log = LoggerFactory.getLogger(VersionAction.class);
	  @Resource
	  private ObjectMapper om;
	  @Resource
	  private IVersionService VersionService;
	  
	  
	// ��ҳ
		@RequestMapping(value = "select/{pno}", method = RequestMethod.GET)
		public void getUserByPage(@PathVariable("pno") int pageNo,
				@RequestParam(value = "ps", defaultValue = "1") int pageSize,
				HttpServletResponse response) throws Exception {

			response.setCharacterEncoding("utf-8");

			MyResponse resp = new MyResponse();

			Page page = VersionService.getUserByPage(pageNo, pageSize, null);
			System.out.println(page
					+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			resp.setData(page);

			// ����ѭ���ų���Ҫ���ֶ�
			// SimpleFilterProvider filter = new
			// SimpleFilterProvider().setFailOnUnknownId(false);
			// filter.addFilter("ShortMsgUser",
			// SimpleBeanPropertyFilter.filterOutAllExcept("id,name,desc"));
			// filter.addFilter("ShortMsgUser",
			// SimpleBeanPropertyFilter.serializeAllExcept("shortMsgUserGroups"));
			// om.setFilters(filter);
			om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			
			System.out.println(om.writeValueAsString(resp));
			om.writeValue(response.getOutputStream(), resp);
		}
	  
	  /** 1.��ѯ�汾�� */
		@RequestMapping(value = "findAllmesginfo", method = RequestMethod.GET)
		public void findAll(HttpServletResponse response)
				throws Exception {
			response.setCharacterEncoding("utf-8");
			MyResponse resp = new MyResponse();

			// ��ѯ�汾��
			List<Version> list = VersionService.findVersion();
//			yyyyMMddhhmmssSSS  yyyy-MM-dd HH:mm:ss  yyyy/MM/dd HH:mm:ss
			om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm.ss"));
			om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			/**
			 * HQL��ѯ��ʽ
			 */
			System.out.println("	APK���ƣ�	"+list.get(0).getApkName()+"	APK����URL��ַ��	"+list.get(0).getApkUrl()+"	�°汾��������	"+list.get(0).getVerBug()+"�汾��	"+list.get(0).getVerCode()+"	�汾�ţ�=	"+list.get(0).getVerName()+"	�汾ʱ��		"+list.get(0).getDataTime());
			/**
			 * Sql��ѯ��ʽ
			 */
			/*for (Iterator it = list.iterator(); it.hasNext();) {
				Object[] obj = (Object[]) it.next();
				System.out.println("APK���ƣ�	"+obj[1]+"APK����URL��ַ��	"+obj[2]+"�汾��	"+obj[3]+"�汾�ţ�=	"+obj[4]+"	�汾ʱ��	"+obj[5]);
				
			}*/
			resp.setData(list);
			
			System.out.println(om.writeValueAsString(resp));
			om.writeValue(response.getOutputStream(), resp);
		}
}
