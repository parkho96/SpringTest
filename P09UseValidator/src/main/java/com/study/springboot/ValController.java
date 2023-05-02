package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValController {
	@RequestMapping("/")
	public String root() {
		return "insertForm";
	}
	
	@RequestMapping("/done")
	public String insert(@ModelAttribute("dto") ContentDTO contentDto,
			BindingResult result) {
		System.out.println(contentDto);
		String page="donePage";
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDto, result);
		if(result.hasErrors()) {
			page="insertForm";
		}
		return page;		
	}
	
	
	@RequestMapping("/done2")
	public String insert(@ModelAttribute("dto2") ContentDTO2 contentDto2, BindingResult result)
	{
		ContentValidator cv = new ContentValidator();
		cv.validate(cv, result);
		if(result.hasErrors())
		{
			return "donePage";
		}
		return "insertForm";
		
	}
}
