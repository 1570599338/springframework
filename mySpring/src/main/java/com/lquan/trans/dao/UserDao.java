package com.lquan.trans.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by 01370602 on 2020/5/10.
 */
public interface UserDao {


	/**
	 * 新增日志
	 * @param name
	 */
	@Insert(" insert into user(name) values('${name}');")
	public void  insertUserA(@Param("name") String name);


	@Select(" select * from  user ;")
	public List<Map<String,String>> queryList();


	@Delete("delete from  user ;")
	public void  deleUser();

}
