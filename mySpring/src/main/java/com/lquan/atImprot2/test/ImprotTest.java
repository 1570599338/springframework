package com.lquan.atImprot2.test;/**
 * Created by 01370602 on 2020/4/27.
 */

import com.lquan.atImprot2.config.AppConfig;
import com.lquan.atImprot2.dao.Dao;
import com.lquan.atImprot2.dao.IndexDao3;
import com.lquan.atImprot2.dao.impl.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName ImprotTest
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class ImprotTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Dao dao = (Dao) annotationConfigApplicationContext.getBean("indexDao");
		//IndexDao dao = (IndexDao) annotationConfigApplicationContext.getBean("indexDao");
		dao.say();


	}
}
