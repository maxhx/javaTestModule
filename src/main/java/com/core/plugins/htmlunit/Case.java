package com.core.plugins.htmlunit;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Case {
	
	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) throws Exception, Throwable, IOException {
		// 模拟Chrome浏览器
		final WebClient webClient=new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		final HtmlPage page=webClient.getPage("http://www.yanyulin.info");
		System.out.println(page.asText());
		webClient.closeAllWindows();
	}

}
