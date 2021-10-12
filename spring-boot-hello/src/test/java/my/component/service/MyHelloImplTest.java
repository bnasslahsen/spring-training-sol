package my.component.service;


import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = AppConfig.class)
public class MyHelloImplTest {

	@Autowired
	MyHello myHello;

	@Test
	public void testSayHello() {
		Assert.notNull(myHello);
		String result = myHello.sayHello("Toto");
		org.junit.Assert.assertEquals("Hello : Toto", result);
	}
}
