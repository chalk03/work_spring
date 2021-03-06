package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestDrive {

	public static void main(String[] args) {
		// 1. 스프링 설정파일 불러오기
		ApplicationContext context= new GenericXmlApplicationContext("/config/config.xml");
		
		// 2. ApplicationContext 객체 이용하여 PersonService 객체 만들기
		PersonService service = context.getBean("service", PersonService.class);
		
		// 3. 만든 객체로 2-2에서 구현한 메소드 호출하기
		service.getName();
	}
}
