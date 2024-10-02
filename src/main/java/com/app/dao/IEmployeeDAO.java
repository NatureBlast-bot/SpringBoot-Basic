package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> getEmployeesByDesgn(String desg1,String desg2,String desg3) throws Exception;

}
