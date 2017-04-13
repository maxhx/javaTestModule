package com.m.hx.plugins.common_httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 提交参数演示
 * 该程序连接到一个用于查询手机号码所属地的页面
 * 以便查询号码段1330227所在的省份以及城市
 * @author MAIHX
 *
 */
public class SimpleHttpClient {

	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost("www.imobile.com.cn", 80, "http");  
		HttpMethod method = getPostMethod();
		client.executeMethod(method);
		//打印服务器返回状态
		System.out.println(method.getStatusLine());
		//打印结果页面
		String response = new String(method.getResponseBodyAsString().getBytes("8859_1"));
		//打印返回的信息
		System.out.println(response);
		
		method.releaseConnection();
	}
	
	private static HttpMethod getGetMethod(){
		return new GetMethod("/simcard.php?simcard=1330227");
	}
	
	/**
	 * 使用POST方式提交数据
	 * @return
	 */
	private static HttpMethod getPostMethod(){
		PostMethod post = new PostMethod();
		 NameValuePair simcard = new NameValuePair("simcard","1330227");  
		 post.setRequestBody(new NameValuePair[]{simcard});
		 return post;
	}
}
