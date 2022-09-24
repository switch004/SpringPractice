package com.example.demo.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	@Autowired
	private HelloRepository helloRepository;
	
	public Employee findEmployeeById(int id) {
		Map<String, Object> map = helloRepository.findById(id);
		
		int employeeId = (Integer) map.get("employee_id");
		String employeeName = (String) map.get("employee_name");
		int age = (Integer) map.get("age");
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setAge(age);
		return employee;
	}
}
