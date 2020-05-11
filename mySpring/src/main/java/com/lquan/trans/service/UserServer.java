package com.lquan.trans.service;/**
 * Created by 01370602 on 2020/5/10.
 */

import com.lquan.trans.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ClassName UserServer
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Service
public class UserServer implements IUser {


	@Autowired
	public ILog logService;

	@Autowired
	public UserDao userDao;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor =Exception.class)
	@Override
	public void insertLog(String name){
		userDao.insertUserA("insertUserA");
		logService.insertLogB("insertLogB");

	}






	@Transactional(propagation = Propagation.REQUIRED,rollbackFor =Exception.class)
	@Override
	public void inserA(String name){
		userDao.insertUserA("inserA");
		insertB( name);

		int i = 2/0;
	}

	//@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void insertB(String name){
			userDao.insertUserA("insertB");



	}


	/**
	 *
	 * @return
	 */
	@Override
	public List<Map<String,String>> queryList(){


		return userDao.queryList();
	}


	public List<Map<String,String>> queryListLog(){
		return logService.queryListLog();
	}


	/**
	 * 删除
	 */
	@Override
	public void deleUser(){
		userDao.deleUser();
		logService.deleLog();
	}


}
