package com.lquan.trans.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 01370602 on 2020/5/11.
 */
public interface IUser {
	public void insertLog(String name);

	public void inserA(String name);

	public void insertB(String name);

	public List<Map<String,String>> queryList();


	public List<Map<String,String>> queryListLog();


	public void deleUser();

}
