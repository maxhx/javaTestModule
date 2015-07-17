
package test;
import java.io.IOException;
import java.util.Scanner;

/**   
 * @Title: GetCPUSerialNumber.java 
 * @Package  
 * @Description: 纯java获取CPU序列号(摘自http://www.oschina.net/code/snippet_86425_22997) 
 * @author 麦海贤   
 * @date Jul 18, 2013 2:20:51 PM 
 * @version V1.0   
 */

public class GetCPUSerialNumber {
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		Process process = Runtime.getRuntime().exec(
				new String[] { "wmic", "cpu", "get", "ProcessorId" });
		process.getOutputStream().close();
		Scanner sc = new Scanner(process.getInputStream());
		String property = sc.next();
		String serial = sc.next();
		System.out.println(property + ": " + serial);

		System.out.println("time:" + (System.currentTimeMillis() - start));
	}

}