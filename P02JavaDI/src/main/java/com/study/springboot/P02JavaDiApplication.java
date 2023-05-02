package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.bean.Config;
import com.study.springboot.bean.Member;
import com.study.springboot.bean.Printer;

//@SpringBootApplication
public class P02JavaDiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(P02JavaDiApplication.class, args);
		
		//1.컨테이너(IoC)
		ApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		//2.Bean 가져오기
		Member member1 = (Member)context.getBean("member1");
		member1.print();
		
		Member member2 = context.getBean("hello",Member.class);
		member2.print();
		
		Member member3 = context.getBean("member1",Member.class);
		member3.print();
		
		Printer printer = context.getBean("printerB",Printer.class);
		member1.setPrinter(printer);
		member1.print();
		member2.print();
		member3.print();
		
		//3.Singleton(동일 객체)
		if(member1==member3) {
			System.out.println("동일 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		
		
	}

}
