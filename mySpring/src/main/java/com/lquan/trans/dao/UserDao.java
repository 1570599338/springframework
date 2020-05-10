package com.lquan.trans.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 01370602 on 2020/5/10.
 */
public interface UserDao {


	/**
	 * 新增日志
	 * @param name
	 */
	@Insert(" insert into user(name) values(${name});")
	public void  insertLog(@Param("name") String name);
}
