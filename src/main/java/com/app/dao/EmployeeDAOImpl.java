package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String QUERY="SELECT EMP_ID,EMP_NAME,JOB,SALARY FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> getEmployeesByDesgn(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee> list= null;
		//get JDBC pooled Connection
		try(Connection con=ds.getConnection(); //connection object;
			PreparedStatement pst=con.prepareStatement(QUERY)){
			//query params
			pst.setString(1, desg1);
			pst.setString(2, desg2);
			pst.setString(3, desg3);
			
			if(con!=null) {
				System.out.println("Connection Established!!");
			}
			
			
			try(ResultSet rs=pst.executeQuery()){
				//copy the records of ResultSet object to List<Employee> object
				 list =new ArrayList<>();
				 while(rs.next()) {
					//copy the record of ResultSet to Employee object
					Employee emp =new Employee();
					//Sequence the column number with respect to SQL table
					emp.setEid(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setSalary(rs.getInt(4));
					//column number 4 because in the EMP table salary is in column 4; [putting 3-> leads to error]
					
					//add Employee object to list Collection
					list.add(emp);
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		return list;
	}

}
