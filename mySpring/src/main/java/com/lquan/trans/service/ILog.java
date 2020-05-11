package com.lquan.trans.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 01370602 on 2020/5/11.
 */
public interface ILog {

	public void insertLogB(String cont);



	/**
	 * 删除
	 */
	public void deleLog();


	public List<Map<String,String>> queryListLog();
}
