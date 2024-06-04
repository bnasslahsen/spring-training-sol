package fr.training.spring;


import org.springframework.stereotype.Component;

@Component
public class DependencyInjectionDeveloper {

	private Task task;

	public DependencyInjectionDeveloper(Task documentingTask) {
		this.task = documentingTask;
	}
	
	public void doTask() {
		task.execute();
	}
	
}
