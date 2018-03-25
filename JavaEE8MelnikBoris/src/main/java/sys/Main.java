package sys;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@Autowired
	static Teacher teacher;

	public static void main(String[] arg0) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

		if (teacher != null) {
			final javax.persistence.EntityManagerFactory entityManagerFactory = EntityManagerFactory
					.getEntityManagerFactory();
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			try {
				entityManager.getTransaction().begin();
				Teacher createdEntity = entityManager.merge(teacher);
				entityManager.getTransaction().commit();
			} catch (Exception ex) {
				entityManager.getTransaction().rollback();
			} finally {
				entityManager.close();
			}

			WorkWithTeacher worker = (WorkWithTeacher) context.getBean("worker");
			worker.addTeacher(teacher);

		}
	}
}