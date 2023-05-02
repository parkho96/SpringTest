package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		if(ContentDTO.class.isAssignableFrom(clazz)||ContentDTO2.class.isAssignableFrom(clazz))
		{
			return true;
		}
		return false;
	}
	

	@Override
	public void validate(Object target, Errors errors) {
		
		
		
		if (target instanceof ContentDTO) 
		{
			ContentDTO dto = (ContentDTO)target;

			String writerP=dto.getWriter();
			if(writerP==null||writerP.trim().isEmpty()) {
				System.out.println("Writer is null or Empty");
				errors.rejectValue("writer", "null error");
			}
			
			String contentP=dto.getContent();
			if(contentP==null||contentP.trim().isEmpty()) {
				System.out.println("content is null or empty");
				errors.rejectValue("content", "null error");
			}
			
		}
		else if (target instanceof ContentDTO2) 
		{
			ContentDTO2 dto = (ContentDTO2)target;
		

			String writerP=dto.getWriter();
			if(writerP==null||writerP.trim().isEmpty()) {
				System.out.println("Writer is null or Empty");
				errors.rejectValue("writer", "null error");
			}
			
			String contentP=dto.getContent();
			if(contentP==null||contentP.trim().isEmpty()) {
				System.out.println("content is null or empty");
				errors.rejectValue("content", "null error");
			}
		}
		
		
		
	}
}
