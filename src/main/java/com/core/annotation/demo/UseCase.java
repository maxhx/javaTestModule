package com.core.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author maihx
 * @createDate 2017年
 * @describe  	
 * 	##2017-04-14添加注释
 */
//@Target 是Java的元注解（指修饰注解的注解）之一。用来指定注解修饰类的哪个成员。
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	
	public int id();
	public String description() default "no description";

}
