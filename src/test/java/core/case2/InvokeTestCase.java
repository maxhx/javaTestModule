package core.case2;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class InvokeTestCase {
	
	public static void main(String[] args) throws Throwable {
		
		User user = new User();
		//创建属性描述器
		PropertyDescriptor pd = new PropertyDescriptor("name", User.class);
		//获得写方法
		Method method = pd.getWriteMethod();
		
		method.invoke(user	, "mhx");
		
		System.out.println(user);
	}

}
