package com.xiao.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiao.dao.UserDao;
import com.xiao.model.User;

import redis.clients.jedis.Jedis;

public class RedisTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		UserDao dao = (UserDao) ac.getBean("userDao");
		User user1 = new User();
		user1.setId(new Long(2));
		user1.setUsername("obama");
		dao.saveUser(user1);
		User user2 = dao.getUser(1);
		System.out.println(user2.getUsername());
	}

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("120.27.102.176");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
	}
}
