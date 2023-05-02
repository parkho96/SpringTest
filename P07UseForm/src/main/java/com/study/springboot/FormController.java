package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FormController {
	@RequestMapping("/")
	public String root() {
		return "form";
	}
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest httpServletRequest, Model model) {
		String age=httpServletRequest.getParameter("age");
		String name=httpServletRequest.getParameter("name");
		
		model.addAttribute("age",age);
		model.addAttribute("name",name);
		
		return "test1";
	}
	
// 	ModelAndView 방식 
//	@RequestMapping("/test1")
//	public ModelAndView test1(HttpServletRequest httpServletRequest) {
//		String age=httpServletRequest.getParameter("age");
//		String name=httpServletRequest.getParameter("name");
//		
//		ModelAndView mv = new ModelAndView();
//		
//		mv.addObject("age",age);
//		mv.addObject("name",name);
//		mv.setViewName("test1");
//		
//		return mv;
//	}
	
	
	@RequestMapping("/test2")
	public String test2(@RequestParam("age") String age,
						@RequestParam("name") String name,
						Model model) {
		model.addAttribute("age",age);
		model.addAttribute("name",name);
		
		return "test1";		
	}
	

// 	ModelAndView 방식 
//	@RequestMapping("/test2")
//	public ModelAndView test2(@RequestParam("age") String age,
//							  @RequestParam("name") String name)
//	{
//		ModelAndView mv = new ModelAndView();
//
//		mv.addObject("name", name); 
//		mv.addObject("age", age); 
//		mv.setViewName("test1");
//		
//		return mv;
//	}
	
	
	@RequestMapping("/test3/{personname}/{personage}")
	public String getPathInfo(@PathVariable String personname,
							@PathVariable String personage,
							Model model) {
		model.addAttribute("age",personage);
		model.addAttribute("name",personname);
		
		return "test1";		
	}
	
//	@RequestMapping("/test4")
	@RequestMapping(value="/test4",method=RequestMethod.GET)
	public String test41(PersonDTO person,Model model) {
		model.addAttribute("person",person);
		System.out.println("get");
		return "test2";
	}
	@RequestMapping(value="/test4",method=RequestMethod.POST)
	public String test42(PersonDTO person,Model model) {
		model.addAttribute("person",person);
		System.out.println("post");
		return "test2";
	}

}










