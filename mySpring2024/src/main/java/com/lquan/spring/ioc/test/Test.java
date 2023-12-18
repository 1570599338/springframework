package com.lquan.spring.ioc.test;

import com.lquan.spring.ioc.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring
 * @description:
 * @author: lquan
 * @create: 2023-12-18 17:20
 **/
public class Test {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		User user = applicationContext.getBean("userX", User.class);
		System.out.println(user.getUserName()+"_"+user.getUserAge());
	}
}
