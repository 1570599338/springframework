package com.lquan.scan.scan1.dao;/**
 * Created by 01370602 on 2020/4/22.
 */

import org.springframework.stereotype.Service;

/**
 * ClassName IndexDao
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Service
public class IndexDao implements IIndexDao {

	@Override
	public void query(){
		System.out.println("查询queryDao");
	}
}
