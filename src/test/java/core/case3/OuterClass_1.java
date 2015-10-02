package core.case3;

/**
 * 
 * 成员内部类又被称为非静态内部类，它具有以下几个特性：
 * 
 * 在非静态内部类里可以直接访问外部类的成员。这是因为在非静态内部类对象里，保存了一个它寄存的外部类对象的引用。但是需要注意的是，
 * 外部类对象则不一定有非静态内部类对象寄存在其中。
 * 在外部类中不能直接访问内部类的成员，必须通过创建内部类对象来访问。
 * 在非静态内部类对象中不能定义静态方法、静态Field以及静态初始化块。不允许在外部类的静态方法或者静态代码块中直接使用非静态内部类。看下面代码：
 * 
 * @author MAIHX
 *
 */
public class OuterClass_1 {

	private int outerPrivateParam = 1;

	public int outerPublicParam = 2;

	public static int outerStaticParam = 3;

	void outerFun() {
		System.out.println("function in outer class.");
	}

	public class InnerClass {

		public int innerParam = 4;

		// 在非静态内部类中不可以定义静态变量，以下会报编译错
		// public static innerStaticParam = 5;
		public void innerFun() {
			System.out.println("outerPrivateParam : " + outerPrivateParam + ", outerPublicParam : " + outerPublicParam
					+ ", outerStaticParam : " + outerStaticParam);
			// 访问外部类的方法
			outerFun();
		}
	}

	public void test() {
		InnerClass inner = new InnerClass();
		inner.innerFun();
	}

	public static void main(String[] args) {
		OuterClass_1 outer = new OuterClass_1();
		outer.test();
	}
}
