package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 *@RequestMapping 클래스(타입) 단독 매핑 
 * 
 * */
@RequestMapping("/guestbook/")
@Controller 
public class GuestbookController {
	
	@RequestMapping
	@ResponseBody
	public String list() {
		return "GuestbookController.list()";
	}
	
	@RequestMapping
	@ResponseBody
	public String delete() {
		return "GuestbookController.delete()";
	}
}
