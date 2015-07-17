
package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBCDemo
 * @author maihaixian
 * @version Aug 15, 2012 5:35:37 PM
 */
public class JDBCDemo {
	
	private Connection conn;
	
	public Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");//注册Mysql驱动
			String url = "jdbc:mysql://localhost:3306/dang";//数据库url
			String user ="root";
			String password = "123";
			conn = DriverManager.getConnection(url,user,password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}


	
	

}