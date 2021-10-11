package fr.training.spring;


import org.springframework.stereotype.Component;

@Component("springDeveloper")
public class DependencyInjectionDeveloper {

	private Task task;

	public DependencyInjectionDeveloper(Task documentingTask) {
		this.task = documentingTask;
	}
	
	public void doTask() {
		task.execute();
	}
	
}
