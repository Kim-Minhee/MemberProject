package com.hk.member;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hk.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	// 필드
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;
	
	@Autowired
	ServletContext sc;	// servlet은 아니지만, 정보가 필요하니까 갖다씀
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
//	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	@GetMapping("/member/list")
	public String memberList(Model model) {
		// Controller 역할
		// 1. URL 설정 ( @RequestMapping, @GetMapping, @PostMapping )
		// 2. DB 관련 작업
		// 		- Service
		// 		- Repository
		// 3. 비지니스 로직 (덧셈, 뺄셈 .... 뭐든...)
		// 4. 사용자가 입력한 정보 가져오기 ( request.getParameter("name") )
		// 5. 보관소에 값 저장 ( sc, session, request -> model )
		// 6. JSP 호출 "memberList" -> 메소드명과 일치 ( 규칙은 "WEB-INF/spring/appServlet/servlet-context.xml"에 있음)
		
		
		logger.info("MemberController_memberList()");
		
//		model.addAttribute("member1", "홍길동");
//		model.addAttribute("member2", "김길동");
//		model.addAttribute("email", "@test.com");
//		model.addAttribute("MemberService_memberList", memberService.memberList());
		model.addAttribute("members", memberService.memberList());
		
		return "memberList";
	}
	
	   @RequestMapping(value = "/upload", method = RequestMethod.POST , headers = "content-type=multipart/*")
//	   @PostMapping("/upload")
	   public String upload(@RequestParam("file") MultipartFile multipartFile,Model model) {
	      logger.info("### upload");
	      logger.info("실제 파일이름은 ? " + multipartFile.getOriginalFilename());
	      File targetFile = new File(sc.getRealPath("/resources/fileupload/") + multipartFile.getOriginalFilename());
	      logger.info("파일 저장위치는 :  " + targetFile);
	      try {
	         InputStream fileStream = multipartFile.getInputStream();
	         FileUtils.copyInputStreamToFile(fileStream, targetFile);
	      } catch (IOException e) {
	         FileUtils.deleteQuietly(targetFile);
	         e.printStackTrace();
	      }
	      
	      // 실제 디렉토리와 URL은 다르다.. 
	      // URL은 http://localhost:9999/resources/fileupload/실제파일명
	      // model에 담아서 jsp에서 img로 출력 
	      
	      model.addAttribute("imgSrc", "/resources/fileupload/" + multipartFile.getOriginalFilename());
	      return "upload";
	   }
	
}
