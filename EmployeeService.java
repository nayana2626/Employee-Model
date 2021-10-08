package com.example.demo.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.util.EmployeeEntityDtoUtil;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeDto> getAll() {
		return employeeRepository.findAll().stream().map(EmployeeEntityDtoUtil::entityToDto).collect(Collectors.toList());
	}
	
	public EmployeeDto getById(Long id) {
		return employeeRepository.findById(id).map(EmployeeEntityDtoUtil::entityToDto).orElse(null);
	}
	
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}
	
	public EmployeeDto save(EmployeeDto e) {
		return EmployeeEntityDtoUtil.entityToDto(employeeRepository.save(EmployeeEntityDtoUtil.dtoToEntity(e)));
	}

}
