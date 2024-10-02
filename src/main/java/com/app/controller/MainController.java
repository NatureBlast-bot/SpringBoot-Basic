package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.model.Employee;
import com.app.service.IEmployeeMGMTService;

@Controller("controller")
public class MainController {
	
	@Autowired
	private IEmployeeMGMTService empService;
	
	public List<Employee>showEmployeeBYDesig(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee>list=empService.fetchEmployeeDesig(desg1, desg2, desg3);
		if(list!=null) {
			System.out.println("List is full");
		}else {
			System.out.println("List is empty");
		}
		return list;

		
	}
}
