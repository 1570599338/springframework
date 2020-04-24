package com.lquan.scan.scan1.test;/**
 * Created by 01370602 on 2020/4/21.
 */

import com.lquan.scan.scan1.config.Configration;
import com.lquan.scan.scan1.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName Test
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class Test {

    public static void main(String[] args) {
    	// 把spring所有的前提环境准备好
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(Configration.class);

		annotationConfigApplicationContext.register(Configration.class);
		annotationConfigApplicationContext.scan("com.lquan.scan");
		annotationConfigApplicationContext.refresh();
	//	annotationConfigApplicationContext.register(IndexDao.class);

		IndexDao indexDao = annotationConfigApplicationContext.getBean(IndexDao.class);
		indexDao.query();
    }
}
