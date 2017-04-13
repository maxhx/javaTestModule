package com.m.hx.core.util.convert.entity;

import java.io.StringWriter;

/**
 * 类Man.java的实现描述：TODO 类实现描述 
 * @author maihx 2016年4月10日 上午9:55:14
 */
public class Man extends Person {
	
	/**职位*/
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return new StringWriter()
				.append("name:").append(this.getName()).append(";")
				.append("age:").append(String.valueOf(this.getAge())).append(";")
				.append("title:").append(this.getTitle()).toString();
	}
	
	

}
