package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		log.info("컨트롤러 root");
		return "Security";
//		return "login";
	}
	
	
	@RequestMapping("/guest/welcome")
	public String welcomeGuest() {
		log.info("컨트롤러 welcomeGuest");
		System.out.println("guest");
		return "guest/welcomeGuest";
	}
	
	
	@RequestMapping("/member/welcome")
	public String welcomeMember() {

		log.info("컨트롤러 welcomeMember");
		System.out.println("member");
		return "member/welcomeMember";
	}
	
	
	@RequestMapping("/admin/welcome")
	public String welcomeAdmin() {

		log.info("컨트롤러 welcomeAdmin");
		System.out.println("admin");
		return "admin/welcomeAdmin";
	}
}
