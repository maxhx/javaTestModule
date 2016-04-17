package designPattern.single;

/**
 * 静态内部类解决线程安全问题
 * 
 * @author MAIHX
 *
 */
public class SmartLazySingleton {
	private static class LazyHolder {
		private static final SmartLazySingleton INSTANCE = new SmartLazySingleton();
	}
	
	private SmartLazySingleton(){}
	
	public static final SmartLazySingleton getInstance(){
		return LazyHolder.INSTANCE;
	}
}
