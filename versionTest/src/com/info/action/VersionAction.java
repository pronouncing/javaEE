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
	  
	  
	// 分页
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

			// 跳出循环排除不要的字段
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
	  
	  /** 1.查询版本号 */
		@RequestMapping(value = "findAllmesginfo", method = RequestMethod.GET)
		public void findAll(HttpServletResponse response)
				throws Exception {
			response.setCharacterEncoding("utf-8");
			MyResponse resp = new MyResponse();

			// 查询版本号
			List<Version> list = VersionService.findVersion();
//			yyyyMMddhhmmssSSS  yyyy-MM-dd HH:mm:ss  yyyy/MM/dd HH:mm:ss
			om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm.ss"));
			om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			/**
			 * HQL查询方式
			 */
			System.out.println("	APK名称：	"+list.get(0).getApkName()+"	APK下载URL地址：	"+list.get(0).getApkUrl()+"	新版本跟新内容	"+list.get(0).getVerBug()+"版本：	"+list.get(0).getVerCode()+"	版本号：=	"+list.get(0).getVerName()+"	版本时间		"+list.get(0).getDataTime());
			/**
			 * Sql查询方式
			 */
			/*for (Iterator it = list.iterator(); it.hasNext();) {
				Object[] obj = (Object[]) it.next();
				System.out.println("APK名称：	"+obj[1]+"APK下载URL地址：	"+obj[2]+"版本：	"+obj[3]+"版本号：=	"+obj[4]+"	版本时间	"+obj[5]);
				
			}*/
			resp.setData(list);
			
			System.out.println(om.writeValueAsString(resp));
			om.writeValue(response.getOutputStream(), resp);
		}
}
