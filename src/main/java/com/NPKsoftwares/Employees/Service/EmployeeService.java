package com.NPKsoftwares.Employees.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.NPKsoftwares.Employees.Model.Empolyee;

@Service
public interface EmployeeService {
	List<Empolyee>getAllEmployee();
	
	Void saveEmployee(Empolyee employee);
	
	Empolyee getEmployeeById(long employeeId);
	 void deleteEmployeeById(long employeeId);

	

	

}
