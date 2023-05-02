package com.study.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.service.IDepositService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

	@Autowired
	IDepositService deposit;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "transaction";
	}
	
	@RequestMapping("/deposit")
	public String deposit() {
		return "deposit";
	}
	
	@RequestMapping("/deposit_process")
	public String deposit_process(
			@RequestParam("accountid") String accountid
			,@RequestParam("amount") String amount
			,@RequestParam("error") String error
			,Model model) {
		int res = deposit.deposit(accountid, Integer.parseInt(amount)
				, error);
		model.addAttribute("accountid",accountid);
		model.addAttribute("amount",amount);
		if(res==1) {
			return "deposit_end";
		}else {
			return "deposit_error";
		}
	}
	
}











