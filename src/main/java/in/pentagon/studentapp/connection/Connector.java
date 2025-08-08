package in.pentagon.studentapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//factory class which returns con reference variable
public class Connector {

		public static Connection requestConnection() {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Shamanth@2003");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
			
		}
}
