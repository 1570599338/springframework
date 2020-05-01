package com.lquan.condition.model;/**
 * Created by 01370602 on 2020/5/2.
 */

/**
 * ClassName User
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class User {

	private String name;

	private String desc;

	public User(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", desc='" + desc + '\'' +
				'}';
	}
}
