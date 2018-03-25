package sys;

import org.springframework.beans.factory.annotation.Autowired;

public class WorkWithStudents {
	@Autowired
	StudentsDao studentsDao;

	public Student addstudent(Student student) {
		student = studentsDao.addStudent(student);
		System.out.println(student);
		return student;
	}
}