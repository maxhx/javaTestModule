package core.case3;

/**
 * 局部内部类放在方法中定义，局部内部类仅在方法内有效。局部类不能使用访问控制修饰符和static修饰符来修饰。
 * 
 * 若需要用局部内部类来创建实例或派生子类，那么只能在局部内部类所在的方法或代码块内进行。
 * 
 * @author MAIHX
 *
 */
public class OuterClass_3 {
	private int outerPrivateParam = 1;

	public int outerPublicParam = 2;

	public static int outerStaticParam = 3;

	void outerFun() {
		class InnerClass {

			public int innerParam = 4;

			public void innerFun() {
				System.out.println("outerPrivateParam : " + outerPrivateParam + ", outerPublicParam : "
						+ outerPublicParam + ",outerStaticParam : " + outerStaticParam);
			}
		}
		InnerClass inner = new InnerClass();
		inner.innerFun();
		System.out.println(inner.innerParam);
	}

	public static void main(String[] args) {
		OuterClass_3 out = new OuterClass_3();
		out.outerFun();
	}
}
