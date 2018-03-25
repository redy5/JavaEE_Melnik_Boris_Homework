package sys;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] arg0) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
	}
}