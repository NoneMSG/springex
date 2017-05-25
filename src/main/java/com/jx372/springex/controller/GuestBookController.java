package com.jx372.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//request mapping (type 단독매핑)
@Controller
@RequestMapping("/guestbook/*")
public class GuestBookController {
	
	@ResponseBody
	@RequestMapping //Method 이름으로 deafult mapping 한다.. /guestbook/list
	public String list(){
		return "GuestbookController:list()";
	}
}
