package com.koitt.model;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.koitt.service.MailService;

public class MailSendingTasklet implements Tasklet{

	private Resource directory;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/koitt/config/applicationContext.xml");
		
		Users user = new Users("chalk03@naver.com", "강동민");
		MailService service = context.getBean(MailService.class);
		service.sendEmail(user);
		
		return RepeatStatus.FINISHED;
	}
	
	public Resource getDirectory() {
		return directory;
	}

	public void setDirectory(Resource directory) {
		this.directory = directory;
	}
}
