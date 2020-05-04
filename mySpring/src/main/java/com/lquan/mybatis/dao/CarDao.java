package com.lquan.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by 01370602 on 2020/4/26.
 */
public interface CarDao {

	@Select("select * from member where shortname like '%${name}%'")
	public List<Map<Integer,String>> list(@Param("name") String name);
}
