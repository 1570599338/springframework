package com.lquan.spring.xml.dao;/**
 * Created by 01370602 on 2020/4/21.
 */

/**
 * ClassName TempDaoFactoryBean
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class TempDaoFactoryBean {

	private String msg1;
	private String desc;
	private String age;


	public String getMsg1() {
		System.out.println(msg1);
		return msg1;
	}

	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}

	public String getDesc() {
		System.out.println(desc);
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAge() {
		System.out.println(age);
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void  test(){

        System.out.println("TempDaoFactoryBean");
    }
}
