package com.jen.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Annotation for class as controller
@Controller

public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		} 
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("count", count);
		return "counter.jsp";
	}
	@RequestMapping("/double")
	public String doubleCounter(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count += 2;
		session.setAttribute("count", count);
		return "double.jsp";
	}
	@RequestMapping("/reset")
	public String reset(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		session.setAttribute("count", 0);
		model.addAttribute("count", count);
		return "index.jsp";
	}
}

