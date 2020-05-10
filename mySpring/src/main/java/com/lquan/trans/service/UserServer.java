package com.lquan.trans.service;/**
 * Created by 01370602 on 2020/5/10.
 */

import com.lquan.trans.dao.LogDao;
import com.lquan.trans.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName UserServer
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class UserServer {


	@Autowired
	private LogService logService;

	@Autowired
	private UserDao userDao;

	public void insertLog(String name){
		userDao.insertLog("userx");

		logService.insertLog("log1");
		int i = 2/0;
		logService.insertLog("log2");
	}
}
