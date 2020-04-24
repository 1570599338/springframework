package com.lquan.resource.test;/**
 * Created by 01370602 on 2020/4/23.
 */

import com.lquan.resource.config.Configration;
import com.lquan.resource.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName TestMain
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(IndexDao.class);
		IndexDao indexDao =(IndexDao)annotationConfigApplicationContext.getBean("indexDao");
		indexDao.test();


	}
}
