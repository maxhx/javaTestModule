
package test.interview.calculationcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @���� Service
 * @���� max	 
 * @����ʱ�䣺Feb 28, 2013 3:12:29 PM
 * @version 
 */
public class Service {
	/**
	 * 1�������ļ�Ŀ¼
	 * 2���ҵ�java�ļ�
	 * 3����ȡjava�ļ�ͳ�ƴ�������
	 * */
	
	private int sum  = 0;//ͳ��java�ļ���Ŀ
	private int sum1 = 0;//������ע�ͺͿ���
	private int sum2 = 0;//����������
	private int sum3 = 0;//����ע�ͺͿ���
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getSum1() {
		return sum1;
	}

	public void setSum1(int sum1) {
		this.sum1 = sum1;
	}

	public int getSum2() {
		return sum2;
	}

	public void setSum2(int sum2) {
		this.sum2 = sum2;
	}

	public int getSum3() {
		return sum3;
	}

	public void setSum3(int sum3) {
		this.sum3 = sum3;
	}

	public void calculate(File file){
		//����ļ�����·��ΪĿ¼
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(int i = 0;i<files.length;i++){
				File f = files[i];
				calculate(f);
			}
		}else{
			sum++;
			read(file);
		}
	}
	
	public void read(File file){
		String fileName = file.getName();
//		System.out.println(fileName);
		if(fileName.endsWith(".java")){
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				String line = null;
				while((line=br.readLine())!=null){
					if(!"".equals(line.trim())){
						sum2++;
						if(!line.trim().startsWith("//")){
							sum1++;
						}
					}
					sum3++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	

}