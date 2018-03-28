package com.spring.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class FirstSpringMVCController {

	@RequestMapping("/hi")
	public String sayHello() {
		return "abc";
	}
	@RequestMapping("/message")
	public String sendMessage(Model m) {
		m.addAttribute("mymessage", "hiii from model message");
		return "Kitchen";
		
	}
	@RequestMapping("/sm")
	public ModelAndView sendMsg(ModelAndView mv)
	{
		mv.addObject("msg1", "welcome to sm model&view");
		mv.setViewName("canteen");
		return mv;
		
	}
}
