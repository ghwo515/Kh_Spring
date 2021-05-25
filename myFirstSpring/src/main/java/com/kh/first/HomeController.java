package com.kh.first;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.first.dept.model.service.DeptService;
import com.kh.first.emp.model.dto.EmpDto;
import com.kh.first.emp.model.service.EmpService;
import com.kh.first.info.model.dto.EmpInfoDto;
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

		return "index";
	}

	@RequestMapping(value = "/list")
	public String empList(Locale locale, Model model, ModelAndView mv) {
		logger.info("emp List");

//		EmpService empSrv = new EmpService();
//		empSrv.empCount();
//		
		List<EmpDto> emplist = empService.selectListEmp(2, 5);
		System.out.println(emplist);
		model.addAttribute("emplist", emplist);

		return "emplist";
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
		String hello = "안녕";
		mv.addObject("message", hello);
		return mv;
	}

	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("aaa", "index.do");
		return mav;
	}

	@RequestMapping("/help/main.do")
	public String helpMain(ModelMap model) { 
		// …
		model.addAttribute("bbb", "/help/main.do");
		return "help/main";
	}
	@RequestMapping("/help/main")
	public Map<String, Object> helpMain2() { 
		HashMap<String, Object> model = new HashMap<String, Object>();
		return model;
	}
	
	@RequestMapping("/info/emp")
	public ModelAndView infoEmp(ModelAndView mv) {
		mv.setViewName("info/emp");
		// db 내용 읽어나와 주세요.
		List<EmpInfoDto> empInfo = empInfoService.selectListEmpInfo(1, 10);
		mv.addObject("infoEmp", empInfo);
		return mv;
	}
	@RequestMapping(value="/emp/input", method = RequestMethod.GET)
	public ModelAndView empInput(ModelAndView mv) {
		mv.setViewName("empInput");
		return mv;
	}
	@RequestMapping(value="/emp/insert", method = RequestMethod.POST)
	public ModelAndView empInsert(ModelAndView mv
			, HttpServletRequest request
			, @RequestParam(name="deptno", defaultValue="1", required = false) String dno 
			, @RequestParam(name="deptnoaa", defaultValue="3") String defaultdno 
//			, EmpDto dto
			, EmpInfoDto infodto) {
		System.out.println("request getParameter:" + request.getParameter("ename"));
		System.out.println("dno:"+dno);  
		System.out.println("defaultdno:"+defaultdno);   
//		System.out.println("dto:" + dto.toString());
		System.out.println("infoDto:" + infodto.toString());
		mv.setViewName("empInsert");
		return mv;
	}
	@RequestMapping(value="/emp/insert2", method = RequestMethod.POST)
	public ModelAndView empInsert(ModelAndView mv
			, HttpServletRequest request
			, @RequestParam(name="upfile") MultipartFile report
			, EmpDto dto) {
		System.out.println("request getParameter:" + request.getParameter("ename"));
		System.out.println("dto:" + dto.toString());
		if(report !=null && !report.equals("")) {
			saveFile(report, request); 
			System.out.println("저장된파일명:"+ report.getOriginalFilename());
		}
		
		int result = empService.insertEmp(dto);
		if(result>0) {
			mv.addObject("message", "등록성공");
		}else {
			mv.addObject("message", "등록실패");
		}
		mv.setViewName("empInsertResult");
		return mv;
	}
	
	
	private void saveFile(MultipartFile report, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\uploadFiles";
		System.out.println("savePath:"+ savePath);
		File folder = new File(savePath);
		if (!folder.exists()) {
			System.out.println("폴더없음");
			if(folder.mkdirs()) { // 폴더가 없다면 생성한다.
				System.out.println("폴더생성 성공");
			}
		}
		String filePath = null;
		try {
			// 파일 저장
			System.out.println(report.getOriginalFilename() + "을 저장합니다.");
			System.out.println("저장 경로 : " + savePath);
			filePath = folder + "/" + report.getOriginalFilename();
			report.transferTo(new File(filePath)); // 파일을 저장한다 
			System.out.println("파일 명 : " + report.getOriginalFilename()); 
			System.out.println("파일 경로 : " + filePath); System.out.println("파일 전송이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("파일 전송 에러 : " + e.getMessage());
		}
	}

	private void removeFile(String board_file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles";
		String filePath = savePath + "/" + board_file;
		try { //잘못 지울 경우를 대비해 try-catch를 묶어준다
			// 파일 저장
			System.out.println(board_file + "을 삭제합니다.");
			System.out.println("기존 저장 경로 : " + savePath);
			File delFile = new File(filePath); //filePath의 주소를 delFile에 넣어준
			delFile.delete(); // 파일을 지운다
			System.out.println("파일 삭제가 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("파일 삭제 에러 : " + e.getMessage()); 
			//geMessage는 마지막에 에러난 멧세지만 보여준다 
		}
	}
}
