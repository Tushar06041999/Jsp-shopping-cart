package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hellojdbc {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String JdbcUrl = "jdbc:mysql://localhost:3306/user";
		String dbuser = "root";
		String dbpassword = "polash";
		try (Connection c = DriverManager.getConnection(JdbcUrl, dbuser, dbpassword);
				Statement s = c.createStatement();) {

			String Uname = "polash";
			ResultSet rs = s.executeQuery("select * from user where id = 1 ");

			while (rs.next()) {
				int id = rs.getInt(1);
				String user = rs.getString(2);
				String password = rs.getString(3);
				
				System.out.printf("%d\t%s\t%s\n", id, user, password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
