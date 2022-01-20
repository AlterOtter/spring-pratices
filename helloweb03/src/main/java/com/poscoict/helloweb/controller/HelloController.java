package com.poscoict.helloweb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

	@RequestMapping("/hello/{id}")
	public String hello(@PathVariable String id) {
		System.out.println(id);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println("name : "+name);
		return "/WEB-INF/views/hello2.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id",id);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String hello4(String id,Model model) {
		model.addAttribute("id",id);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello5")
	public String hello5(String id,Model model) {
		model.addAttribute("id",id);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello6")
	public String hello6() {
		return "redirect:/hello.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello7")
	public String hello7() {
		return "<h1>Hello World !!</h1>";
	}
	
	@RequestMapping("/hello7")
	public void hello8(HttpServletRequest req,HttpServletResponse res ) throws IOException {
		res.sendRedirect("/helloweb03/hello");
	}
}
