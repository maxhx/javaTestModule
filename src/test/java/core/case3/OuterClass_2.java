package core.case3;

/**
 * <li>静态内部类属于类本身，不需要先创建外部类对象，再来创建内部类对象。 	</li>
 * <li>静态内部类只能访问外部类的类成员。									</li>
 * <li>外部类不能直接访问静态内部类中的成员，可以通过创建对象或用类名来访问。</li>
 * 
 * @author MAIHX
 *
 */
public class OuterClass_2 {

	private int outerPrivateParam = 1;

	public int outerPublicParam = 2;

	public static int outerStaticParam = 3;

	void outerFun() {
		// 外部类可以通过内部类.静态成员来访问内部类的静态成员
		System.out.println(InnerClass.innerStaticParam);
	}

	static void outerStaticFun() {
		InnerClass.innerStaticFun();
	}

	public static class InnerClass {

		public static int innerStaticParam = 5;
		public int innerParam = 4;

		public void innerFun() {
			// 在静态内部类中不能访问外部类的非静态成员，以下会报编译错。
			// System.out.println("outerPrivateParam : " + outerPrivateParam);
			// ouerFun();
			System.out.println("outerStaticParam : " + outerStaticParam);
			outerStaticFun();
		}

		public static void innerStaticFun() {
			System.out.println(innerStaticParam);
		}
	}

	public void test() {
		InnerClass inner = new InnerClass();
		System.out.println(inner.innerParam);
	}

	public static void main(String[] args) {
		OuterClass_2.InnerClass inner = new OuterClass_2.InnerClass();
		inner.innerFun();
		OuterClass_2.InnerClass.innerStaticFun();
	}
}
