package util.convert;

import net.sf.cglib.beans.BeanCopier;
import util.convert.entity.Man;
import util.convert.entity.Person;

/**
 * 类BeanCopierUtils.java的实现描述：TODO 类实现描述
 * 
 * @author maihx 2016年4月9日 下午10:18:54
 */
public class BeanCopierUtils {

	public static void main(String[] args) {
		
		seniorClassCopierCase();
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

}
