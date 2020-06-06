package com.lquan.trans.service;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.trans.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ClassName CardService
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@Service
public class LogService implements ILog{

	@Autowired
	private LogDao logDao;

	@Transactional(propagation = Propagation.NESTED,rollbackFor =Exception.class)
	@Override
	public void insertLogB(String cont){
		logDao.insertLog("insertLogB");
		int a =1/0;
		logDao.insertLog("insertLogC");

	}



	/**
	 * 删除
	 */
	@Override
	public void deleLog(){
		logDao.deleUser();
	}


	@Override
	public List<Map<String,String>> queryListLog(){


		return logDao.queryList();
	}
}
