package com.example.demo.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> findById(int id){
		String query = "SELECT * FROM employee Where employee_id =?";
		
		Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
		return employee;
	}
}
