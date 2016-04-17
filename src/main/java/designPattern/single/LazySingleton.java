package designPattern.single;

/**
 * 懒汉式，非线性安全
 * 
 * @author MAIHX
 *
 */
public class LazySingleton {
	
	private LazySingleton(){}
	private static LazySingleton single = null;
	//静态工厂方法
	public static LazySingleton getInstance(){
		if(single==null){
			single = new LazySingleton();
		}
		return single;
	}

}
