package edu.northeastern.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtil {
	
	public void connector() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/COOD_FinalProject","root","root");
		Statement stmt = conn.createStatement();
		String s = "Insert into Customer values('Regmi','Mridul','regmimridul','dallu@123',26,10000)";
		stmt.execute(s);
		conn.close();
		System.out.println("Done");
	}
}
