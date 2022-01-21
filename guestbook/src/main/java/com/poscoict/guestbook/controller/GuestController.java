package com.poscoict.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscoict.guestbook.repository.Guest_dao;
import com.poscoict.guestbook.vo.GuestbookVO;

@Controller
public class GuestController {

	@Autowired
	private Guest_dao guest_dao;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVO> list = guest_dao.select();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(GuestbookVO vo,Model model) {
		System.out.println(vo.getName());
		guest_dao.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable(value="no",required = true) String no,Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(GuestbookVO vo,Model model) {
		System.out.println(vo.getName());
		guest_dao.delete(vo);
		return "redirect:/";
	}
}
