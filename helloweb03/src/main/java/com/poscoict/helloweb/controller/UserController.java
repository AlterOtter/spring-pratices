package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscoict.helloweb.vo.UserVo;

/*
 * 
 * @RequestMapping 클래스(타입) + 메소드(핸들러)
 *
 * 
 * 
 * */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/user/joinform.jsp";
	}
	
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo.getName());
		return "redirect:/";
	}
	
	
	/*
	 * 
	 * 만일 n 이라는 이름의 파라미터가 없는 경우
	 * 400 bad request 에러가 발생한다.
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		System.out.println("name :"+ name);
		return "UserController.update("+name+")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(
			@RequestParam(value="n",required=true,defaultValue="") String name,
			@RequestParam(value="a",required=true,defaultValue="0") String age) {
		System.out.println("name :"+ name);
		
		  
		return "UserController.update2("+name+")";
	}
	
	@ResponseBody
	@RequestMapping("/board/{no}")
	public String view(@PathVariable("no") Long no) {
		System.out.println(no);
		return "UserController.view";
	}
}
