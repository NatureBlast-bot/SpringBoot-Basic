package com.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.controller.MainController;
import com.app.model.Employee;

@Component
public class LayeredAppTestingRunner implements CommandLineRunner {

	@Autowired
	private MainController controller;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("LayeredAppTestingRunner.run()");
		//invoke the business method
		try {
			List<Employee>list=controller.showEmployeeBYDesig("CLERK","ANALYST","TESTER");
			list.forEach(emp->
			System.out.println(emp)
			);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
