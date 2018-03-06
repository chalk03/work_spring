package com.koitt.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedule {

	@Scheduled(cron="0 0/1 * * * *")
	public void printTest() {
		System.out.println("1분마다 출력되는 메시지");
	}
	
	@Scheduled(cron="0 0/2 * * * *")
	public void printTest2() {
		System.out.println("2분마다 출력되는 메시지");
	}
	
}
