package fr.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws InterruptedException {		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Developer developer = (Developer) ctx.getBean("springDeveloper");
		Task task = ctx.getBean(Task.class);
		developer.doTask(task);
		developer.takeABreak(1000);
	}
	
}
