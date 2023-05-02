package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.IBasicBbsDao;
import com.study.springboot.dto.BasicBbsDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicBbsServiceImpl implements BasicBbsService {
	@Autowired
	IBasicBbsDao dao;
	
	@Override
	public List<BasicBbsDto> getList() {

		log.info("서비스 getList logger");
		return dao.listDao();
	}
	@Override
	public BasicBbsDto getView(String id) {
		
		log.info("서비스 getView logger");
		return dao.viewDao(id);
	}
	@Override
	public int writePost(Map<String, String> map) {
		
		log.info("서비스 writePost logger");
		return dao.writeDao(map);
	}
	@Override
	public int deletePost(String id) {
		
		log.info("서비스 deletePost logger");
		return dao.deleteDao(id);
	}
	@Override
	public int countPost() {
		
		log.info("서비스 countPost logger");
		return dao.postCount();
	}
}
