package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P03AnnotationDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(P03AnnotationDiApplication.class, args);
	}

}
//@SpringBootApplication
//@Configuration(각종 설정)
//+ @EnableAutoConfiguration(application context 관련 자동 설정)
//+ @ComponentScan
//	(@Component @Configuration이 붙은 클래스를 스캔하여 빈 등록)
