package com.m.hx.plugins.xmemcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import net.rubyeye.xmemcached.CASOperation;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class Cache {

	private MemcachedClientBuilder builder = null;
	private MemcachedClient client = null;
	private String address = "10.16.69.85:11211";
	private int[] weight = new int[] { 1, 1, 1 };
	public Cache() {
		builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(address), weight);
		builder.setConnectionPoolSize(5);
		try {
			client = builder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void set(String key, int exp, Object value) {
		try {
			if (!client.set(key, exp, value)) {
				System.err.println("set error, key is " + key + " value is " + value);
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public void delete(String key) {
		try {
			client.delete(key);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public void update(String key, final Object value) {
		try {
			client.cas(key, 0, new CASOperation<Object>() {
				public int getMaxTries() {
					return 1;
				}

				public Object getNewValue(long currentCAS, Object currentValue) {
					//更新数据库
					
					return value;
				}
				
			});
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public Object get(String key) {
		try {
			return client.get(key);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addServer(String server, int port, int weight) {
		try {
			client.addServer(server, port, weight);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeServer(String hostList) {
		client.removeServer(hostList);
	}
	
	public Object refresh(String key){
		try {
			return client.touch(key,1);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void tst(){
		try {
			Object ob = client.get("A2015105549391");
			System.out.println(ob);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

