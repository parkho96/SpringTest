package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/")
	public String root() throws Exception{
		return "/login";
	}
	@RequestMapping("/guest/welcome")
	public String welcomeGuest() {
		System.out.println("컨트롤러 guest");
		return "guest/welcomeGuest";
	}
	@RequestMapping("/member/welcome")
	public String welcomeMember() {
		System.out.println("컨트롤러 member");
		return "member/welcomeMember";
	}
	@RequestMapping("/admin/welcome")
	public String welcomeAdmin() {
		System.out.println("컨트롤러 admin");
		return "admin/welcomeAdmin";
	}
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("컨트롤러 login form");
		return "security/loginForm";
	}
	@RequestMapping("/loginError")
	public String loginError(){
		System.out.println("컨트롤러 login error");
		return "security/loginError";
	}
    @RequestMapping("/forward")
    public @ResponseBody String forward() {
    	System.out.println("컨트롤러 forward");
    	return "here";
    }
}










