package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeMGMTService {
	public List<Employee> fetchEmployeeDesig(String desg1,String desg2,String desg3) throws Exception;
}
