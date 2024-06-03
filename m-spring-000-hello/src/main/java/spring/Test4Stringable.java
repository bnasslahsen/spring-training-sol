package spring;

import spring.bean.ToStringable;
import spring.bean.UserStringable;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4Stringable {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/spring-config-4-stringable.xml");
		//
		// Interface : ToStringable and NOT the real instance : UserStringable
		//
		UserStringable toto = context.getBean("totoImpl", UserStringable.class);
		ToStringable toto1 = context.getBean("totoImpl", ToStringable.class);
		
		String str = toto.toString();
		System.out.println("The result is " + str);
		System.out.println("The second result is " + toto1.toString());
		context.close();
	}
}
