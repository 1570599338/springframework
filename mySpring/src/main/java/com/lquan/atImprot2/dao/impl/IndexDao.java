package com.lquan.atImprot2.dao.impl;/**
 * Created by 01370602 on 2020/4/27.
 */

import com.lquan.atImprot2.dao.Dao;
import org.springframework.stereotype.Component;

/**
 * ClassName IndexDao
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Component
public class IndexDao implements Dao{

	@Override
	public void say(){
		System.out.println("Hello IndexDao");
	}
}
