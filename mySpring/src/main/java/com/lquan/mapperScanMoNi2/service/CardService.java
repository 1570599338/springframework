package com.lquan.mapperScanMoNi2.service;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.mapperScanMoNi2.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ClassName CardService
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@Component
public class CardService {

	@Autowired
	CarDao carDao;


	public  void list(){
		System.out.println(carDao.list("panda"));
	}


	/**
	 * 初始化
	 */
	@PostConstruct
	public  void init(){
		System.out.println("*********************init");
	}


	@PreDestroy
	public  void destroy(){
		System.out.println("*********************destroy");
	}

}
