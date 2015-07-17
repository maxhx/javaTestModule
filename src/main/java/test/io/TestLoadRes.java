
package test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @类名 TestLoadRes
 * @author maihaixian	 
 * @version 创建时间：Oct 10, 2012 1:57:40 PM
 * @detail 测试载入资源
 */
public class TestLoadRes {
	
	public void getResource() throws IOException{  
		//返回读取指定资源的输入流  
        InputStream is=this.getClass().getResourceAsStream("/test/io/gsstpLog.txt");
        BufferedReader br=new BufferedReader(new InputStreamReader(is));  
        String s="";  
        while((s=br.readLine())!=null)  
            System.out.println(s);   
    } 
	
	public static void main(String[] args) throws IOException {
        TestLoadRes test = new TestLoadRes();
		test.getResource();
	}

}