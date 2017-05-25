package com.jx372.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// request mapping (type + method 단독 매핑)
@Controller
@RequestMapping("/user")
public class UserController {

	@ResponseBody
	@RequestMapping("/joinform") // /user/joinform
	public String joingform() {
		return "UserController:joinform";
	}

	@ResponseBody
	@RequestMapping("/join") // /user/joinform
	public String doJoin() {
		return "UserController:dojoin";
	}
	
	//여러개의 URL을 한 메소드에 매핑 (잘 안 쓴다.)
	@ResponseBody
	@RequestMapping( {"/join", "/dojoin"} ) // /user/joinform
	public String doJoin2() {
		return "UserController:dojoin";
	}
	
	//2개이상의 값을 mapping할때 value와 method를 알려주어야한다
	@RequestMapping(value="/login", method=RequestMethod.GET) //action이 모두 method로 바뀜
	public String login(){
		return "/WEB-INF/views/login.jsp";
	}
	//2개 이상의 prompt 처리 가능한 메소드 
	@RequestMapping(value={"/login","/l"}, method=RequestMethod.GET) //action이 모두 method로 바뀜
	public String login2(){
		return "/WEB-INF/views/login.jsp";
	}
//	
//	@ResponseBody
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(String email, String password){
//		return "UserController:login(String, String)";
//	}
	
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
		//@RequestParam(value="email", required=true, defaultValue="") String email,
		//@RequestParam(value="password", required=true, defaultValue="") String password,
		@ModelAttribute UserVo userVo){ //promt에게 변수를 따로 받았었지만 getter, setter가 설정된 객체가 있다면 객체를 이용해 한방에 받을 수 있다.
		System.out.println(userVo);
		//return "UserController:login(String, String)";
		return "redirect:/main";
	}
}
