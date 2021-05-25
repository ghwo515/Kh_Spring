package com.kh.first;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.first.dept.model.dto.DeptDto;
import com.kh.first.dept.model.service.DeptService;
import com.kh.first.emp.model.dto.EmpDto;
import com.kh.first.emp.model.service.EmpService;
import com.kh.first.info.model.dto.EmpInfo;
import com.kh.first.info.model.service.EmpInfoService;

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
	
	@Autowired
	private EmpInfoService empInfoService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String empList(Locale locale, Model model) {
		logger.info("emp List");

		List<EmpDto> emplist = empService.selectListEmp(1, 5);
		System.out.println(emplist);
		model.addAttribute("emplist", emplist);

		return "emplist";
	}

	@RequestMapping(value = "/deptlist", method = RequestMethod.GET)
	public String deptList(Locale locale, Model model) {
		logger.info("dept List");

		List<DeptDto> deptlist = deptService.selectListDept();
		System.out.println(deptlist);
		model.addAttribute("deptlist", deptlist);

		return "deptlist";
	}

	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String aaa(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/bbb", method = RequestMethod.GET)
	public String bbb(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "bbb";
	}

//	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	@RequestMapping("hello.do")
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("index"); 
		mv.addObject("message", "안녕"); 
		return mv;
	}
	
	@RequestMapping("index.do")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("aaa", "index.do"); 
		return mav;
	}
	@RequestMapping("/help/main.do")
	public String helpMain(ModelMap model) {
		//..
		model.addAttribute("bbb", "/help/main.do"); 
		return "help/main";
	}
	@RequestMapping("/search/game.do")
	public Map<String, Object> search( ) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		return model;
	}
	
	@RequestMapping("info/emp")
	public ModelAndView infoEmp(ModelAndView mv) {
		mv.setViewName("info/emp"); 
		// db 내용 읽어나와 주세요.
		List<EmpInfo> empInfo = null;
		empInfo = empInfoService.selectListEmpInfo();
		mv.addObject("message", empInfo); 
		return mv;
	}
	
	@RequestMapping(value="/emp/input", method=RequestMethod.GET)
	public ModelAndView empInput(ModelAndView mv, EmpDto dto ) {
		mv.setViewName("empInput"); 
		return mv;
	}
	
	@RequestMapping(value="/emp/insert", method=RequestMethod.POST)
	public ModelAndView empInsert(ModelAndView mv, EmpDto dto ) {
		System.out.println(dto);
		mv.setViewName("empInsert"); 
		return mv;
	}
}
