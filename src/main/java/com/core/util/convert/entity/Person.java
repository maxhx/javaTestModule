package com.core.util.convert.entity;
/**
 * 类Person.java的实现描述：TODO 类实现描述 
 * @author maihx 2016年4月10日 上午9:51:45
 */
public class Person {
	
	private String name;
	private int age;
	
	public Person(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder sbd = new StringBuilder();
		sbd.append("name:").append(this.name).append(";").append("age:").append(this.age);
		return sbd.toString();
	}
	
	

}
