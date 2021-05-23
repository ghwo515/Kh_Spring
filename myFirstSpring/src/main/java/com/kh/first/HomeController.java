package com.kh.first;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.first.dept.model.dto.DeptDto;
import com.kh.first.dept.model.service.DeptService;
import com.kh.first.emp.model.dto.EmpDto;
import com.kh.first.emp.model.service.EmpService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EmpService empService;
	
	@Autowired
	private DeptService deptService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String empList(Locale locale, Model model) {
		logger.info("emp List");
		
		List<EmpDto> emplist = empService.selectListEmp(1, 5);
		System.out.println(emplist);
		model.addAttribute("emplist", emplist );
		
		return "emplist";
	}
	
	@RequestMapping(value = "/deptlist", method = RequestMethod.GET)
	public String deptList(Locale locale, Model model) {
		logger.info("dept List");
		
		List<DeptDto> deptlist = deptService.selectListDept();
		System.out.println(deptlist);
		model.addAttribute("deptlist", deptlist );
		
		return "deptlist";
	}
	
	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String aaa(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/bbb", method = RequestMethod.GET)
	public String bbb(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "bbb";
	}
}