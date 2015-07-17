
package test.jvm;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/**   
 * @Title: ClassLoadCheck.java 
 * @Package www.io.util.jvm
 * @Description: 查看一下当前运行的jvm中加载了多少个类
 * @author 麦海贤   
 * @date 2013-10-24 上午10:49:06 
 * @version V1.0   
 */
public class ClassLoadCheck {

	public static void main( String[] args ) throws Exception {
	      ClassLoadingMXBean bean = ManagementFactory.getClassLoadingMXBean();
	      System.out.println( bean.getLoadedClassCount() );
    }
	
}