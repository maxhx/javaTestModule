
package com.core.algorithm;
/**
 * @author maihx
 * 非波拉契数列
 */
public class Fibonacci {
	
	static int count = 0;
	
	public static void main(String[] args) {
		System.out.println("Fibonacci[20]="+getValue(20)+",遍历次数"+count);
		
	}
	
	public static int getValue(int n){
		count++;
		if(n==0||n==1){
			return 1;
		}else{
			return getValue(n-1)+getValue(n-2);
		}
	}

}