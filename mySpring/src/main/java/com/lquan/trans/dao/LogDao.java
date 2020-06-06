package com.lquan.trans.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by 01370602 on 2020/4/26.
 */
public interface LogDao {


	/**
	 * 新增日志
	 * @param context
	 */
	@Insert(" insert into mlog(context) values('${context}');")
	public void  insertLog(@Param("context") String context);


	@Select(" select * from  mlog ;")
	public List<Map<String,String>> queryList();


	@Delete("delete from  mlog ;")
	public void  deleUser();

}
