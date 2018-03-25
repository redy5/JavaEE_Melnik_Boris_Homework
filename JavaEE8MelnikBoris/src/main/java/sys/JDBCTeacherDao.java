package sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCTeacherDao implements TeachersDao {

	private static final String SQL_INSERT_teacher = "insert into teachers (pib,course) values (?,?)";

	@SuppressWarnings("deprecation")
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	public void addTeacher(Teacher teacher) {
		jdbcTemplate.update(SQL_INSERT_teacher, teacher.getTeacherId(), teacher.getFirstname(),teacher.getLastname(),teacher.getBirthDate(),teacher.getCellphone());
	}

	private static final String SQL_SELECT_teacher_BY_ID = "select id, pib, course from teachers where id = ?";

	@SuppressWarnings("deprecation")
	public Teacher getTeacherById(int id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_teacher_BY_ID, new ParameterizedRowMapper<Teacher>() {
			public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(rs.getInt(1));
				teacher.setFirstname(rs.getString(2));
				teacher.setLastname(rs.getString(3));
				teacher.setBirthDate(rs.getDate(4));
				teacher.setCellphone(rs.getString(4));
				return teacher;
			}
		}, id);
	}
}