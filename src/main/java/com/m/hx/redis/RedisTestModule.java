package com.m.hx.redis;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/** 
 * @Title: 麦海贤_美的集团	
 * @Description: RedisAPI 操作类 
 * 使用外部技术库如下：
 *  		<dependency>
		    <groupId>redis.clients</groupId>
		    <artifactId>jedis</artifactId>
		    <version>2.9.0</version>
		</dependency>
		
 * @see  http://www.cnblogs.com/liuling/p/2014-4-19-04.html 		
 * @author: maihx
 * @date: 2017年1月9日 下午7:30:42  
 */
public class RedisTestModule {
    
    
    private Jedis jedis;
    
    @Before
    public void setup(){
	 //连接redis服务器，127.0.0.1:6379
	 jedis = new Jedis("127.0.0.1", 6379);
	 //权限认证
	 //jedis.auth("admin");  
    }
    
    @Test
    public void testString(){
	//- 添加数据
	jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin  
	System.out.println(jedis.get("name"));//执行结果：xinxin  
	
	jedis.append("name", " is my lover"); //拼接
	System.out.println(jedis.get("name")); 
	
	jedis.del("name");  //删除某个键
	System.out.println(jedis.get("name"));
	
	//设置多个键值对
	 jedis.mset("name","liuling","age","23","qq","476777XXX");
	  jedis.incr("age"); //进行加1操作
	  System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq")); 
    }
    
    
    @Test
    public void testMap() {
	
    }

}
