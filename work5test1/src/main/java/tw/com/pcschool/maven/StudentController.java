package tw.com.pcschool.maven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@PostMapping("/students")
	public String insert(@RequestBody Student student) {
		String sql="INSERT INTO student(name) VALUE (:studentName)"; //:符號 在SQL 代表 動態變數
		
		Map<String, Object> map=new HashMap<>();
		
		//map.put("studentId", student.getId());
		map.put("studentName", student.getName());
		
		
		//常用的通用方法，要用再來看，update進階用法
		KeyHolder keyHolder=new GeneratedKeyHolder();
		
		
		namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
		
		
		int id=keyHolder.getKey().intValue();  //如果id 為long 要用 longValue();
		System.out.println("mysql 自動生成的ID為: "+id);
		
		return "執行 INSERT SQL";
	}
	
	//處理多筆 SQL update
	@PostMapping("/students/batch")
	public String insertList(@RequestBody List<Student> studentList) {
		String sql="INSERT INTO student(name) VALUE (:studentName)";
		
		//通用固定寫法，要用再看
		MapSqlParameterSource[] parameterSources=new MapSqlParameterSource[studentList.size()];
		
		for(int i=0;i<studentList.size();i++) {
			Student student=studentList.get(i);
			
			parameterSources[i]=new MapSqlParameterSource();
			parameterSources[i].addValue("studentName", student.getName());
		}
		
		namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);
		
		return "執行一批 INSERT sql";
	}
	
	@DeleteMapping("/students/{studentId}")
	public String delete(@PathVariable Integer studentId) {
		
		String sql="DELETE FROM student WHERE id= :studentId";
		
		Map<String, Object> map=new HashMap<>(); //通用寫法
		
		map.put("studentId",studentId );
		
		namedParameterJdbcTemplate.update(sql, map);
		
		return "執行 DELETE SQL";
		
	}
	
	//Get 就Read 規則
	@GetMapping("/students/{studentId}")
	public Student select(@PathVariable Integer studentId) {
		
		//程式盡量避免*號搜尋，會花費額外流量
		String sql="SELECT id,name FROM student WHERE id = :studentId";
		
		Map<String,Object> map=new HashMap<>();
		map.put("studentId", studentId);
		
		
		List<Student> list = namedParameterJdbcTemplate.query(sql, map,new StudentRowMapper());
		
		//判斷LIST有無資料
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
		
	}
	
}
