package sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class WorkWithTeacher {
	@Autowired
	LecturesDao lecturesDao;

	public Lecture addLecture(Lecture lecture) {
		lecture = lecturesDao.addLecture(lecture);
		System.out.println(lecture);
		return lecture;
	}
}