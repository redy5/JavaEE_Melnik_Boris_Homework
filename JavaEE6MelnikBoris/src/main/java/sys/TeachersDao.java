package sys;

public interface TeachersDao {
	Teacher addTeacher(Teacher teacher);

	Teacher getTeacherById(int id);

	void saveTacher(Teacher teacher);
}