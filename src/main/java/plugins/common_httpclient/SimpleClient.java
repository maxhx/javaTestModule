package plugins.common_httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * 最简单的HTTP客户端,用来演示通过GET或者POST方式访问某个页面  
 * @author MAIHX
 *
 */
public class SimpleClient {
	
	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		//设置代码服务器地址和端口
		//client.getHostConfiguration().setProxy("addr",port);
		//使用GET方法
		HttpMethod method = new GetMethod("http://java.sun.com");
		//使用POST方法
		//HttpMethod method = new PostMethod("http://java.sun.com");
		client.executeMethod(method);
		//打印服务器返回状态
		System.out.println(method.getStatusLine());
		//打印返回的信息
		System.out.println(method.getResponseBodyAsString());
		//释放连接
		method.releaseConnection();
	}

}
