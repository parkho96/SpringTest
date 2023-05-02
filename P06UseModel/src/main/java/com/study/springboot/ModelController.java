package com.study.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Model and view";
	}

	@RequestMapping("/test1")
	public String test(Model model) {
		// Model 객체를 이용 view에 data 전달
		// 데이터만 설정 가능
		model.addAttribute("name", "홍길동");
//		model.addAttribute("name");
		return "test1";
	}

	@RequestMapping("/mv")
	public ModelAndView test2() {
		// 데이터와 뷰를 동시에 설정이 가능
		ModelAndView mv = new ModelAndView();

		List<String> list = new ArrayList<>();

		list.add("나");
		list.add("너");
		list.add("우리");

		mv.addObject("lists", list);
		mv.addObject("ObjectTest", "테스트입니다.");
		mv.addObject("name", "홍길동");
		mv.setViewName("myView");
		return mv;
	}

// 	model 방식으로 전환 
//	@RequestMapping("/mv")
// 	public String test2(Model model) {
//    	// 데이터와 뷰를 동시에 설정이 가능
//       
//        List<String> list = new ArrayList<>();
//         
//        list.add("나");
//        list.add("너");
//        list.add("우리");
//         
//        model.addAttribute("lists", list);      		
//        model.addAttribute("ObjectTest", "테스트입니다.");
//        model.addAttribute("name", "홍길동");			
//       
//        return "myView";                                     
//    }
}
