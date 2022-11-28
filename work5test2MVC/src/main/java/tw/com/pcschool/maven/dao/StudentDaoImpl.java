package tw.com.pcschool.maven.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import tw.com.pcschool.maven.Student;
import tw.com.pcschool.maven.StudentRowMapper;

@Component
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Student getById(Integer studentId) {
		String sql="SELECT id,name FROM student WHERE id=:studentId";
		
		Map<String, Object> map=new HashMap<>();
		map.put("studentId", studentId);
		
		List<Student> list =namedParameterJdbcTemplate.query(sql, map,new StudentRowMapper());
		
		if (list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
		
		
	}

	@Override
	public String delById(Integer studentId) {
		String sql="DELETE FROM student WHERE id= :studentId";
		
		Map<String, Object> map=new HashMap<>(); //通用寫法
		
		map.put("studentId",studentId );
		
		namedParameterJdbcTemplate.update(sql, map);
		return "執行DELETE 方法";
	}

	@Override
	public String getByList(List<Student> studentList) {
		String sql="INSERT INTO student(name) VALUE (:studentName)";
		
		//通用固定寫法，要用再看
		MapSqlParameterSource[] parameterSources=new MapSqlParameterSource[studentList.size()];
		
		for(int i=0;i<studentList.size();i++) {
			Student student=studentList.get(i);
			
			parameterSources[i]=new MapSqlParameterSource();
			parameterSources[i].addValue("studentName", student.getName());
		}
		
		namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);
		return "執行多筆INSER sql";
	}

	@Override
	public String getByStudent(Student student) {
		String sql="INSERT INTO student(name) VALUE (:studentName)"; //:符號 在SQL 代表 動態變數
		
		Map<String, Object> map=new HashMap<>();
		
		//map.put("studentId", student.getId());
		map.put("studentName", student.getName());
		
		
		//常用的通用方法，要用再來看，update進階用法
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		
		namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
		
		
		int id=keyHolder.getKey().intValue();  //如果id 為long 要用 longValue();
		System.out.println("mysql 自動生成的ID為: "+id);
		return "執行單一INSERT 動作";
	}
	

}
