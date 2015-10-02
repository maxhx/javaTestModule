package core.case4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FetchHttpCase {
	
	//////////////单例模式////////////////
	private static class LazyHolder{
		private static final FetchHttpCase INSTANCE = new FetchHttpCase();
	}
	
	private FetchHttpCase(){}
	
	public static final FetchHttpCase getInstance(){
		return LazyHolder.INSTANCE;
	}
	//////////////单例模式////////////////
	
	public static void main(String[] args) {
		FetchHttpCase ftc = FetchHttpCase.getInstance();
		try {
			String callBackStr = ftc.fetch_url("http://www.baidu.com");
			System.out.println(callBackStr);
		} catch (Exception e) {
		}
	}
	
	
	public static String fetch_url(String url) throws IOException {  
	    BufferedReader bis = null;  
	    InputStream is = null;  
	    try {  
	        URLConnection connection = new URL(url).openConnection();  
	        is = connection.getInputStream();  
	        // warning of UTF-8 data  
	        bis = new BufferedReader(new InputStreamReader(is, "UTF-8"));  
	        String line = null;  
	        StringBuffer result = new StringBuffer();  
	        while ((line = bis.readLine()) != null) {  
	            result.append(line);  
	        }  
	        return result.toString();  
	    } finally {  
	        if (bis != null) {  
	            try {  
	                bis.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if (is != null) {  
	            try {  
	                is.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	}  

}
