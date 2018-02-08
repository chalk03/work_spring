package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestDrive {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("/config/config.xml");
		
		GreetingService service = context.getBean("greeting", GreetingService.class);
		
		service.sayHello();
		
	}
}
