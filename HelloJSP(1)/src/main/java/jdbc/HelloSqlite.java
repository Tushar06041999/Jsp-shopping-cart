package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloSqlite {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		
		String sqliteUrl = "jdbc:sqlite:hello.db";
		try {
			Connection c = DriverManager.getConnection(sqliteUrl);
			
			Statement s = c.createStatement();
			
			String sqldrop = "drop table if exists user";
			String sqlcreate = "create table user (id int primary key,name varchar(50),password varchar(50))";
			String sqlinsert = "insert into user values(1,'pol','12345')";
			s.execute(sqldrop);
			s.execute(sqlcreate);
			s.execute(sqlinsert);
			
			String sqlselect = "select * from user";
			ResultSet rs = s.executeQuery(sqlselect);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				System.out.printf("%d\t%s\t%s\n",id,name,password);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
