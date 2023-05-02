package com.study.springboot.controller;

import java.util.HashMap;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.IBasicBbsDao;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

//	private Logger log1 = LoggerFactory.getLogger(getClass());
	
	@Autowired
	IBasicBbsDao dao;
	
	@RequestMapping("/")
	public String root() {
//		log1.info("info logger");
		log.info("lombok logger");
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlist(Model model) {
//		log1.info("info list logger");
		log.info("lombok list logger");
		model.addAttribute("list",dao.listDao());
		int total=dao.postCount();
		System.out.println("count:"+total);
		return "list";
	}
	
	@RequestMapping("/write")
	public String writeForm() {
//		log1.info("info writeForm logger");
		log.info("lombok writeForm logger");
		return "writeForm";
	}
	
	@RequestMapping("/writing")
	public String write(HttpServletRequest req,Model model) {

//		log1.info("info writing logger");
		log.info("lombok writing logger");
		String wri = req.getParameter("writer");
		String tit = req.getParameter("title");
		String con = req.getParameter("content");
		Map<String,String> map = new HashMap<>();
		map.put("writer", wri);
		map.put("title", tit);
		map.put("content", con);
		int res = dao.writeDao(map);
		System.out.println("write:"+res);
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String detailView(HttpServletRequest req,Model model) {

//		log1.info("info view logger");
		log.info("lombok view logger");
		
		String uId=req.getParameter("id");
		model.addAttribute("dto",dao.viewDao(uId));
		return "view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req,Model model) {
//		log1.info("info delete logger");
		log.info("lombok delete logger");
		
		
		dao.deleteDao(req.getParameter("id"));
		return "redirect:list";
	}
}