package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.Transaction1Dao;
import com.study.springboot.dao.Transaction2Dao;

@Service
public class DepositServiceImpl implements IDepositService {

	@Autowired
	Transaction1Dao trans1;
	@Autowired
	Transaction2Dao trans2;
	
	@Override
	public int deposit(String accountid, int money, String error) {
		try {
			trans1.deposit(accountid, money);
			if(error.equals("1")) {int n=10/0;}
			trans2.deposit(accountid, money);
			
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
