package com.koitt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDrive {

	public static void main(String[] args) {
		// 스프링 설정파일 불러오기
		ApplicationContext context = new ClassPathXmlApplicationContext("com/koitt/config/config.xml");
		
		// Example 타입으로 빈 객체 찾아서 가져오기
		Example example = context.getBean(Example.class);
		
		// example 객체의 execute 메소드 호출해서 국제화
		example.execute();
	}
}
