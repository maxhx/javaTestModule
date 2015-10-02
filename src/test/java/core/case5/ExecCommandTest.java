package core.case5;

public class ExecCommandTest {

	public static void main(String[] args) throws Exception {
		// 默认处理
//		ExecCommand exe1 = new ExecuteCommand();
//		exe1.exec("c:\\ls.bat");
//		// 自定义处理
//		ExecCommand exe2 = new ExecuteCommand() {
//			@Override
//			protected void lineHandler(String lineStr) {
//				System.out.println(lineStr);
//			}
//		};
//		exe2.exec("c:\\ls.bat", "c:\\");
		// 多个参数
		ExecCommand exe3 = new ExecuteCommand();
		exe3.exec(new String[] { "ping", "127.0.0.1" });
		
	}

}
