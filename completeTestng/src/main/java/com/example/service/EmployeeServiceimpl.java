package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee updatedEmployee) {
		return employeeRepository.save(updatedEmployee);
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}
}