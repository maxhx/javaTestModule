package core.case3;

public class OuterClass_4 {

	/**
	 * 
	 * 适合创建只需要一次使用的类。
	 * 
	 * 格式 :
	 * 
	 * new 父类构造器(实参列表) | 实现接口()
	 * 
	 * {
	 * 
	 * //匿名内部类的类体部分。
	 * 
	 * }
	 * 
	 * @param sex
	 * @return
	 */
	public TestInterface getInnerClass(final String sex) {
		final int age = 23;
		return new TestInterface() {

			@Override
			public void print(String name) {
				System.out.println(name + " is a " + sex + " and age is " + age);
			};
		};
	}

	/**
	 * 
	 * 创建匿名内部类时会立即创建一个类的实例，这个类定义会立即消失。
	 * 
	 * 匿名内部类必须继承一个父类，或实现一个接口。
	 * 
	 * 注意 :
	 * 
	 * 匿名内部类不能是抽象类。 无法定义构造器，因为匿名内部类没有类名。但可定义初始化完成构造器的功能。
	 * 
	 * @author MAIHX
	 *
	 */
	class TestInterface {

		void print(String name) {
		};
	}

	public static void main(String[] args) {
		OuterClass_4 out = new OuterClass_4();
		out.getInnerClass("boy").print("demo");
	}
}
