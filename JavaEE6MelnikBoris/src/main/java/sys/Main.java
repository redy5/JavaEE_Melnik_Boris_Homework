package sys;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] arg0) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		
		Lecture lecture = new Lecture();
		lecture.setName("Introduction to Spring");
		lecture.setCredits(2.5);
		WorkWithLectures worker = (WorkWithLectures)context.getBean("worker");
		worker.addLecture(lecture);
	}
}