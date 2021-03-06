package com.jx372.springex.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	
	@RequestMapping( "/hello" )
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2(@RequestParam("n") String name){
		ModelAndView mav = new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;
		
	}
	
	@RequestMapping("/hello3")
	public String hello3(
			Model model, //model 객체를 만들어서 method에 넣어준다.
			@RequestParam("n") String name){
			model.addAttribute("name",name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	/* 기술이 침투 했기 때문에 비추천*/
	@RequestMapping("/hello4")
	public void hello4(HttpServletRequest request, Writer out){
		String name = request.getParameter("name");
		try {
			out.write(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
