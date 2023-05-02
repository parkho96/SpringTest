package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ContentDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContentDTO dto = (ContentDTO)target;
		
		String writerP=dto.getWriter();
//		이 방식도 가능하고
//		if(writerP==null||writerP.trim().isEmpty()) {
//			System.out.println("Writer is null or Empty");
//			errors.rejectValue("writer", "null error");
//		}

//		이렇게 사용해도 되고
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
				"writer", "writer is empty");
		if(writerP.length()<4) {
			errors.rejectValue("writer", "writer is too short");
		}
		
		
//		String contentP=dto.getContent();
//		if(contentP==null||contentP.trim().isEmpty()) {
//			System.out.println("content is null or empty");
//			errors.rejectValue("content", "null error");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"content", "Content is empty");
	}
}
