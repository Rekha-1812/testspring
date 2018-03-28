package com.springmvc.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.hibernate.bean.EmployeeBean;
import com.springmvc.hibernate.entity.EmployeeEntity;
import com.springmvc.hibernate.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	@Autowired 
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {
	  return new ModelAndView("index");
	 }
	
	
	@RequestMapping("/empform")
	public ModelAndView showform() {
		// command is a reserved request attribute name, now use <form> tag to show
		// object data
		return new ModelAndView("empform", "command", new EmployeeBean());
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") EmployeeBean employeeBean) {
		// write code to save emp object
		// here, we are displaying emp object to prove emp has data
		System.out.println(employeeBean.getEmployeeName() + " " + employeeBean.getEmployeeSalary() + " " + employeeBean.getEmployeeDesignation());
		// return new ModelAndView("empform","command",emp);//will display object data
		/*
		 *code to save the bean to the database 
		 * 
		 */
		//transfer the data from bean to entity
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeName(employeeBean.getEmployeeName());
		employeeEntity.setEmployeeSalary(employeeBean.getEmployeeSalary());
		employeeEntity.setEmployeeDesignation(employeeBean.getEmployeeDesignation());
		
		employeeService.saveEmployee(employeeEntity);
		
		
		
		return new ModelAndView("success");// will redirect to viewemp request mapping
	}

}