
package test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SQLUtil {
	String url = "jdbc:mysql://127.0.0.1:3306/test";
	String userName = "root";
	String password = "root";
	
	public Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,userName,password);
		}catch (Exception e) {
		}
		return conn;
	}
	

	public void testProc(){
	        Connection conn = getConnection();
	        CallableStatement stmt = null;
	        ResultSet rs =  null;   
	        try{
	            stmt = conn.prepareCall("{call hello()}");
	            rs = stmt.executeQuery();
	            while(rs.next()){
	            	System.out.println(rs.getString(1));
	            }
	            
	        }catch(Exception e){
	        	System.out.println(e.toString());
	        }finally{
	            try {
	                stmt.close();
	                conn.close();
	            }catch (Exception ex) {
	                System.out.println("ex : "+ ex.getMessage());
	            }
	        }
	    }
	    public static void main(String[] args) {
	    	long begin = System.currentTimeMillis();
    		new SQLUtil().testProc();
	        long end   = System.currentTimeMillis();
	        
	    }
}