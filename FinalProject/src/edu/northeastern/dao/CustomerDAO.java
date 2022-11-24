package edu.northeastern.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.northeastern.dbObject.DBConnectionUtil;
import edu.northeastern.models.Customer;

public class CustomerDAO {
	
	public void insertNewCustomer(String lastName, String firstName, String username, String password, double balance, int age) throws SQLException {
		String insertQuery = "Insert into Customer values('"+lastName+"','"+firstName+"','"+username+"','"+password+"','"+age+"','"+balance+"')";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(insertQuery);
	}
	
	public Customer getCustomer(String username, String password) throws Exception {
		String fetchQuery = "Select * from customer where username='"+username+"'";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		ResultSet resultSet = dbConnectionUtil.selectOperations(fetchQuery);
		if(password.equals(resultSet.getString("password"))) {
			throw new Exception("Password Mismatch!");
		}
		Customer customer = new Customer(resultSet.getString("LastName"),resultSet.getString("FirstName"),resultSet.getString("UserName"),resultSet.getString("Password"),resultSet.getDouble("Balance"),resultSet.getInt("age"));
		return customer;
	}
	
	public void updateCustomer(Customer customer) throws SQLException {
		String updateQuery = "Update Customer set Balance="+customer.getBankBalance()+"where UserName='"+customer.getUserName()+"'";
		DBConnectionUtil dbConnectionUtil =  new DBConnectionUtil();
		dbConnectionUtil.queryOperations(updateQuery);
	}
}


