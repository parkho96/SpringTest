package com.study.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.IBasicBbsDao;
import com.study.springboot.service.BasicBbsService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

	
	@Autowired
	BasicBbsService service;
	
	@RequestMapping("/")
	public String root() {
		log.info("컨트롤러 start logger");
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlist(Model model) {

		log.info("컨트롤러 userlist");
		model.addAttribute("list",service.getList());
		int total=service.countPost();
		System.out.println("count:"+total);
		return "list";
	}
	
	@RequestMapping("/write")
	public String writeForm() {
		log.info("컨트롤러 writeForm");
		return "writeForm";
	}
	
	@RequestMapping("/writing")
	public String write(HttpServletRequest req,Model model) {
		log.info("컨트롤러 writing");
		String wri = req.getParameter("writer");
		String tit = req.getParameter("title");
		String con = req.getParameter("content");
		Map<String,String> map = new HashMap<>();
		map.put("writer", wri);
		map.put("title", tit);
		map.put("content", con);
		int res = service.writePost(map);
		System.out.println("write:"+res);
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String detailView(HttpServletRequest req,Model model) {
		log.info("컨트롤러 view");
		String uId=req.getParameter("id");
		model.addAttribute("dto",service.getView(uId));
		return "view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req,Model model) {
		log.info("호진 delete");
		service.deletePost(req.getParameter("id"));
		return "redirect:list";
	}
}