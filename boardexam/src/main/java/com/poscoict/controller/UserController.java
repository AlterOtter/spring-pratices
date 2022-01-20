package com.poscoict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.poscoict.vo.UserVO;


@Controller
public class UserController {
	
	@PostMapping("/board")
	public String Test(UserVO user) {
		
		
		return "/WEB-INF/views/index.jsp";
	}
}
