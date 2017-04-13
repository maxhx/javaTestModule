package com.m.hx.design.single;

/**
 * 饿汉式
 * 
 * @author MAIHX
 *
 */
public class HungrySingleton {

	private HungrySingleton(){}
	
	private static final HungrySingleton single = new HungrySingleton();
	//静态工厂方法
	public static HungrySingleton getInstance(){
		return single;
	}
	
}
