package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.User;

public class UserDao {

	public UserDao() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Class.forName("org.sqlite.JDBC");
	}
	
	String sqlUrl = "jdbc:sqlite:hello.db";
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(sqlUrl);
	}
	
	public User getUser(String name,String password) throws SQLException {
		
		
		Connection c = getConnection();
		Statement s = c.createStatement();
		
		String sqldrop = "drop table if exists user";
		String sqlcreate = "create table user (id int primary key,name varchar(50),password varchar(50))";
		String sqlinsert = "insert into user values(2,'shuvo','123')";
//		s.execute(sqldrop);
//		s.execute(sqlcreate);
//		s.execute(sqlinsert);
		
		
		String sqlselect = "select * from user where name = ? and password = ?";
		
		PreparedStatement ps = c.prepareStatement(sqlselect);
		
		ps.setString(1, name);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		User result = new User();
		
		if(rs.next()) {
			//User result = new User();
			result.setID(rs.getInt(1));
			result.setName(name);
			result.setPassword(password);
			
			
		}else {
			result = null;
		}
		
		c.close();
		s.close();
		ps.close();

		
		return result;
		
		

	}
	public void addUser(String name,String password) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection(sqlUrl);
			
			String sqlinsert = "insert into user values(null,?,? )";
			  
			PreparedStatement ps = c.prepareStatement(sqlinsert);
			
			ps.setString(1, name);
			ps.setString(2, password);
			
			ps.execute();
			
			c.close();
			ps.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


}
