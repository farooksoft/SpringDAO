package com.stackroute.springdao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.springdao.dao.EmployeeDAO;
import com.stackroute.springdao.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@Autowired
	private Employee employee;
	
	@RequestMapping("/")
	public String index(ModelMap model) {
		model.addAttribute("employees",employeeDao.getAllEmployee());
		return "index";
	}
	
	@PostMapping("/sendData")
	public ModelAndView sendData(@RequestParam("empName") String name, @RequestParam("empDesig") String desig, ModelMap model) {
		System.out.println("After sendData");
		employee.setEmpName(name);
		employee.setEmpDesig(desig);
		//employee.setPostedDate();
		
		employeeDao.sendData(employee);
		System.out.println("Before");
		//model.addAttribute("employees",employeeDao.getAllEmployee());
		System.out.println("After");
		return new ModelAndView("/",model);
		
	}
	
	
	
}
