package sys;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentDaoJPAImpl implements StudentsDao {
	
	@PersistenceContext
	private EntityManager em;

	public Student addStudent(Student student) {
		em.persist(student);
		return student;
	}

	public Student getStudent(int id) {
		return em.find(Student.class, id);
	}

	public void saveStudent(Student student) {
		em.merge(student);
	}

}