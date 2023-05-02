package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.Transaction1Dao;
import com.study.springboot.dao.Transaction2Dao;

@Service
public class DepositServiceImpl{

	@Autowired
	Transaction1Dao trans1;
	@Autowired
	Transaction2Dao trans2;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int deposit(String accountid, int money, String error) {
		try {
			transactionTemplate.execute(
					new TransactionCallbackWithoutResult() {				
				@Override
				protected void doInTransactionWithoutResult(
						TransactionStatus status) {
					trans1.deposit(accountid, money);
					if(error.equals("1")) {int n=10/0;}
					trans2.deposit(accountid, money);
				}
			});
			return 1;
		} catch (Exception e) {
			System.out.println("transaction rollback");
			return 0;
		}
	}

}
