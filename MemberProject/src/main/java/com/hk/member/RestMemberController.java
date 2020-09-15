package com.hk.member;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.member.service.MemberService;
import com.hk.member.vo.Member;

@RestController	// Rest : 화면은 없고 데이터만 보내줌...
@RequestMapping(value = "/member/rest", produces = "text/plain;charset=UTF-8")	// Class 위에 @RequestMapping을 쓰면 여기 url을 기준으로 메소드 위에 있는 @GetMapping의 url을 이어붙임... text/plain : 아무 타입 없이 text 그대로...
public class RestMemberController {
	
	   private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);

	   @Autowired
	   MemberService memberService;
	   
	   @GetMapping("/list")
	   public String memberRestList(Model model) {
	      logger.info("/member/rest/list ----------");
	      return "이건 서버에서 보내준 /member/rest/list";
	   }
	   
	   @GetMapping(path = "/listJson", produces = MediaType.APPLICATION_JSON_VALUE)	// json : xml 축약형 (text가 너무 길어서 좀더 짧게...)
	   public List<Member> memberRestListJson(Model model) {
	      logger.info("/member/rest/listJson ----------");
	      return memberService.memberList();
	   }   
	   
	   @GetMapping(path="/addJson" , produces = MediaType.APPLICATION_JSON_VALUE)
	   public List<Member> memberRestAddJSon(@RequestParam("name") String name , @RequestParam("pwd") String pwd) { 
	      logger.info("-----------------");
	      logger.info("Client에서 보내온 값은 === " + name + ":::" + pwd);
	      
	      return memberService.memberList();
	   }
	   
	   @GetMapping(path = "/listXml", produces = MediaType.APPLICATION_XML_VALUE)
	   public List<Member> memberRestListXml(Model model) {
	      logger.info("/member/rest/listXml ----------");
	      return memberService.memberList();
	   } 

}
