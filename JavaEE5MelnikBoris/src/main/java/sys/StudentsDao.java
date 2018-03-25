package sys;

public interface StudentsDao {
	void addStudent(Student student);
	static final String SQL_SELECT_STUDENT_BY_ID = "select id, pib, course from students where id = ?";
	public Student getStudentById(int id);
}