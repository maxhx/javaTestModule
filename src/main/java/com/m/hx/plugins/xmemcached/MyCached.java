package com.m.hx.plugins.xmemcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MyCached {

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException, MemcachedException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("10.16.69.85:11211"));
		MemcachedClient memcachedClient = builder.build();
		try {
			
//			memcachedClient.set("1", 0, "123");
			String value = memcachedClient.get("1");
			System.out.println("value=" + value);
			String val2 = memcachedClient.get("888");
			System.out.println("val="+val2);
		} catch (MemcachedException e) {
			System.err.println("MemcachedClient operation fail");
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.err.println("MemcachedClient operation timeout");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// ignore
		}
		try {
			// flush memcached client
//			memcachedClient.flushAll();
//			memcachedClient.notifyAll();
			// close memcached client
			memcachedClient.shutdown();
		} catch (IOException e) {
			System.err.println("Shutdown MemcachedClient fail");
			e.printStackTrace();
		}
	}

	
	@Test
	public void tst(){
		Cache cache = new Cache();
		cache.set("hellp", 0, "hellopppp");
		System.out.println(cache.get("hello"));
		/*try {
			Object ob = client.get("A2015105549391");
			System.out.println(ob);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
	}
}
