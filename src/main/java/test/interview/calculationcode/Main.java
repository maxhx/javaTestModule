
package test.interview.calculationcode;

import java.io.File;

/**
 * @���� Main
 * @���� max	 
 * @����ʱ�䣺Feb 28, 2013 3:30:11 PM
 * @version 
 */
public class Main {
	
	public static void main(String[] args){
		String fileName = "D:\\CCSSOFT1\\om-client\\src";
		File file = new File(fileName);
		Service service = new Service();
		service.calculate(file);
		System.out.println("ͳ�Ƴ�java�ļ���Ŀ:"+service.getSum());
		System.out.println("ͳ�Ƴ�������ע�ͺͿ���:"+service.getSum1());
		System.out.println("ͳ�Ƴ�����������:"+service.getSum2());
		System.out.println("ͳ�Ƴ�����ע�ͺͿ���:"+service.getSum3());
	}

}