package com.poscoict.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscoict.email.repository.EmailRepository;
import com.poscoict.vo.EmailVo;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmailRepository emailrepositroy; 
	
	@ResponseBody
	@RequestMapping("")
	public String index() {
		List<EmailVo> list = emailrepositroy.finadAll();
		System.out.println(emailrepositroy.toString());
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(EmailVo vo) {
		emailrepositroy.insert(vo);
		return "redirect:/";
	}
}
