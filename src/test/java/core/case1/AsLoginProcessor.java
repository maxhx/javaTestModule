package core.case1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsLoginProcessor {

	public static void main(String[] args) throws IOException {
		String surl = "http://login.goodjobs.cn/index.php/action/UserLogin";  
		
		URL url = new URL(surl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();  
		
		/**
		 * 把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
		 * 通过把URLConnection设为输出，你可以把数据向你的Web页输出
		 * */
		connection.setDoOutput(true);
		
		/**
		 * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中
		 * */
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"GBK");
		
		out.write("memberName=myMemberName&password=myPassword");//关键所在
		//remember to clean up
		out.flush();
		out.close();
		
		//取得cookie， 相当于记录了身份，供下次访问时使用
		String cookieVal = connection.getHeaderField("Set-Cookie");
		
		String s = "http://user.goodjobs.cn/dispatcher.php/module/Resume/action/Preview";
		
		url = new URL(s);
		HttpURLConnection resumeConnection = (HttpURLConnection)url.openConnection();
		if(cookieVal != null){
			// 发送cookie信息上去，以表明自己的身份，否则会被认为没有权限 
			resumeConnection.setRequestProperty("Cookie", cookieVal);  
		}
		resumeConnection.connect();
		InputStream urlStream = resumeConnection.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlStream));
		String ss = null;
		String total = "";
		while((ss = bufferedReader.readLine())!=null){
			total += ss;
		}
		System.out.println(total);
		bufferedReader.close();
		
	}
}
