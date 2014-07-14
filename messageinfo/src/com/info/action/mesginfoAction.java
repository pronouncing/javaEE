package com.info.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.info.model.mesginfo;
import com.info.service.IMesginfoService;
import com.info.commons.MyResponse;
import com.lovo.framework.model.Page;

@Controller
public class mesginfoAction {
	public static final Logger log = LoggerFactory.getLogger(mesginfo.class);
	@Resource
	private ObjectMapper om;
	@Resource
	private IMesginfoService MesginfoService;

	// 添加留言
	@RequestMapping(value = "addmsinfo", method = RequestMethod.POST)
	public void addmesginfo(@ModelAttribute mesginfo addmsinfo,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		MyResponse resp = new MyResponse();

		try {
			MesginfoService.addMesginfo(addmsinfo);
		} catch (Exception e) {
			log.error("addmsinfo error, exception is:{}", e);
			resp.setErrorCode();
		}
		resp.setData(addmsinfo.getId());
		om.writeValue(response.getOutputStream(), resp);
	}

	/** 5.获取留言板所有信息 */
	@RequestMapping(value = "findAllmesginfo", method = RequestMethod.GET)
	public void findAll(HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("utf-8");
		MyResponse resp = new MyResponse();

		// 查询留言板信息
		List<mesginfo> list = MesginfoService.findAll();

		om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		om.configure(Feature.FAIL_ON_EMPTY_BEANS, false);

		resp.setData(list);
		System.out.println(om.writeValueAsString(resp));
		om.writeValue(response.getOutputStream(), resp);
	}
	
	// 分页
	@RequestMapping(value = "Mesginfo/{pno}", method = RequestMethod.GET)
	public void getUserByPage(@PathVariable("pno") int pageNo,
			@RequestParam(value = "ps", defaultValue = "2") int pageSize,
			HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("utf-8");

		MyResponse resp = new MyResponse();

		Page page = MesginfoService.getUserByPage(pageNo, pageSize, null);
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

		om.writeValue(response.getOutputStream(), resp);
	}
}
