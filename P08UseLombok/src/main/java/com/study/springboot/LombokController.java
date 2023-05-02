package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LombokController {
	@RequestMapping("/")
	public String root() {
		return "form";
	}
	
	@RequestMapping("/test1")
	public String test1(@ModelAttribute("person") PersonDTO person
				,Model model) {
		//model.addAttribute("person",person);
		System.out.println(person.toString());
		return "test1";
	}
	
//	@RequestMapping("/test2")
//	public String test2(HttpServletRequest hsr, Model model)
//	{
//		String age = hsr.getParameter("age");
//		String name = hsr.getParameter("name");
//		model.addAttribute("age", age); 
//		model.addAttribute("name", name); 
//		return "test1";
//	}
	
//	@RequestMapping("/test2")
//	public String test2(@RequestParam("age") String age,
//						@RequestParam("name") String name,
//						Model model)
//	{
//		model.addAttribute("age", age); 
//		model.addAttribute("name", name); 
//		return "test1";
//	}

	
//	@RequestMapping(value = "/test2", method = RequestMethod.GET)
//	public String test2(PersonDTO person, Model model)
//	{
//		model.addAttribute("person", person); 
//		return "test1";
//	}
	
	
	
}
