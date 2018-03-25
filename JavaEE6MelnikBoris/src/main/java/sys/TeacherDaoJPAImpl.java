package sys;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TeacherDaoJPAImpl implements TeachersDao {
	
	@PersistenceContext
	private EntityManager em;

	public Teacher addTeacher(Teacher teacher) {
		em.persist(teacher);
		return teacher;
	}

	public Teacher getTeacherById(int id) {
		return em.find(Teacher.class, id);
	}

	public void saveTacher(Teacher teacher) {
		em.merge(teacher);
		
	}
}