package sys;

public interface StudentsDao {
	Student addStudent(Student student);

	Student getStudent(int id);

	void saveStudent(Student student);
}