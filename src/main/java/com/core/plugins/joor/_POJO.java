package com.core.plugins.joor;

import org.joor.Reflect;

public class _POJO {
	
	public _POJO(String name) {
		super();
		this.name = name;
	}

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[name=" + name + "]";
	}

	public static void main(String[] args) {
		Object o = new _POJO("ddd");
		String n = Reflect.on(o).call("getName").get();
		System.out.println(n);
		Reflect.on(o).set("name", "sssss");
		System.out.println(o);
		
	}

}
