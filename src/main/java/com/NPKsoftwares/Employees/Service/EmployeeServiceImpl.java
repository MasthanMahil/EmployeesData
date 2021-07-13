package com.NPKsoftwares.Employees.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NPKsoftwares.Employees.Model.Empolyee;
import com.NPKsoftwares.Employees.Repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired

private EmployeeRepository employeeRepository;

	
	@Override
	public List<Empolyee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Void saveEmployee(Empolyee employee) {
		this.employeeRepository.save(employee);
		return null;
	}


	@Override
	public Empolyee getEmployeeById(long employeeId) {
		Optional<Empolyee> optional=employeeRepository.findById(employeeId);
		Empolyee employee=null;
		if(optional.isPresent()) {
			employee = optional.get();
			
		}else {
			throw new RuntimeException("employee not found for id::" + employeeId);
		}
		return employee;
	}


	@Override
	public void deleteEmployeeById(long employeeId) {
		
		this.employeeRepository.deleteById(employeeId);
		
	}


	



}
