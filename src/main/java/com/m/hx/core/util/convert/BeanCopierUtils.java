package com.m.hx.core.util.convert;

import java.lang.reflect.Field;

import com.m.hx.core.util.convert.entity.Man;
import com.m.hx.core.util.convert.entity.Person;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

/**
 * 类BeanCopierUtils.java的实现描述：TODO 类实现描述
 * 
 * @author maihx 2016年4月9日 下午10:18:54
 */
public class BeanCopierUtils {

	public static void main(String[] args) {
		
//		seniorClassCopierCase();
		
		useConverterCase();
	}
	
	/**普通类属性复制*/
	private static void classCopierCase(){
		Person p1 = new Person();
		p1.setAge(1);
		Person p2 = new Person();
		BeanCopier cope = BeanCopier.create(Person.class, Person.class, false);
		cope.copy(p1,p2,null);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
	}
	
	/**继承类属性复制*/
	private static void seniorClassCopierCase(){
		Person p1 = new Person();
		p1.setAge(1);
		Man m = new Man();
		BeanCopier cope = BeanCopier.create(Person.class, Man.class, false);
		cope.copy(p1,m,null);
		
		System.out.println(p1.toString());
		System.out.println(m.toString());
	}
	
	
	private static void useConverterCase(){
		Person p1 = new Person();
		p1.setAge(1);
		Man m = new Man();
		BeanCopier cope = BeanCopier.create(Person.class, Man.class, true);
		cope.copy(p1, m, new Converter() {
			
			public Object convert(Object value, Class target, Object context) {
				Man man = new Man();
				Field[] fs = value.getClass().getFields();
				for(Field f:fs){
					System.out.println(f.getName());
				}
				return null;
			}
		});
	}

}
