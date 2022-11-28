package tw.com.pcschool.maven;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student=new Student();
		student.setId(rs.getInt("id")); //資料庫 column id
		student.setName(rs.getString("name"));
		return student;
	}

}
