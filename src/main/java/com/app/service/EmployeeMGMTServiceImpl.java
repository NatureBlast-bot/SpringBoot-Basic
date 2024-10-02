package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IEmployeeDAO;
import com.app.model.Employee;

@Service("empService")
public class EmployeeMGMTServiceImpl implements IEmployeeMGMTService {

	@Autowired
	private IEmployeeDAO empDAO;
	@Override
	public List<Employee> fetchEmployeeDesig(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee>list=empDAO.getEmployeesByDesgn(desg1, desg2, desg3);
		if(list!=null) {
			System.out.println("List is full");
		}else {
			System.out.println("List is empty");
		}
		return list;
		
	}

}
