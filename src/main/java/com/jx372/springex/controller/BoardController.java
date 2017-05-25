package com.jx372.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/write")
	public String write(
		/*	@RequestParam("name") String name)*/
			// 파라미터가 없을때의 처리를 위해 기본값 설정 
			@RequestParam(value="n", required=true, defaultValue="" ) String name,
			@RequestParam(value="age", required=true, defaultValue="10") int age
			){
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		return "BoardController:write";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(//RequestParam값 생략가능, 파라미터 변수이름과 같다면 하지만, 권장은 명시적으로 해주어라
			//@RequestParam("name") String name)
			@RequestParam String name){
		System.out.println("name:"+name);
		return "BoardController:write";
	}
	
	//URL말고 패스변수를 만들기
	@ResponseBody
	@RequestMapping( "/view/{no}" ) //지정된 변수타입 외에 다른형이 들어갔을때 막을 수 없다.
	public String view(@PathVariable("no") Long no){
		return "BoardController:view("+ no +")";
	}
}
