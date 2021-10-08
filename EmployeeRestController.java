package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeDto>> getAll() {
		return ResponseEntity.ok(employeeService.getAll());
	}
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createNew(@RequestBody EmployeeDto e) {
		return ResponseEntity.ok(employeeService.save(e));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getById(id));
	}
	
	@PutMapping("/")
	public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto e) {
		return ResponseEntity.ok(employeeService.save(e));
	}
	
	@DeleteMapping("/{id}")
	public BodyBuilder delete(@PathVariable Long id) {
		employeeService.deleteById(id);
		return ResponseEntity.ok();
	}

}
