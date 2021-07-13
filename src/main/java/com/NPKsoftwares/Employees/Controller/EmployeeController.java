package com.NPKsoftwares.Employees.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.NPKsoftwares.Employees.Model.Empolyee;
import com.NPKsoftwares.Employees.Service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/")
	public String viewHomepage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployee());
		return  "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Empolyee employee=new Empolyee();
		model.addAttribute("employee", employee);
		return"Registe_Employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Empolyee employee){
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{employeeId}")
	public String showFormForUpdate(@PathVariable(value="employeeId") long employeeId,Model model) {
		Empolyee employee= employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employee);
		return"Update_Employee";
	}
	@GetMapping("/deleteEmployee/{employeeId}")
	public String deleteEmployee(@PathVariable ( value="employeeId") long employeeId) {
		
		this.employeeService.deleteEmployeeById(employeeId);
		return "redirect:/";
	}
}
