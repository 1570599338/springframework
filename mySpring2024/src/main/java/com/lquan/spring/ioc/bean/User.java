package com.lquan.spring.ioc.bean;

/**
 * @program: spring
 * @description:
 * @author: lquan
 * @create: 2023-12-18 17:23
 **/
public class User {
	private String userName;
	private String userAge;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
}
