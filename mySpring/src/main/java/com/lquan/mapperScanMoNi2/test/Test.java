package com.lquan.mapperScanMoNi2.test;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.mapperScanMoNi1.dao.CardDao;
import com.lquan.mapperScanMoNi2.config.AppConfig;
import com.lquan.mapperScanMoNi2.dao.CarDao;
import com.lquan.mapperScanMoNi2.service.CardService;
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

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		annotationConfigApplicationContext.getBean(CardService.class).list();
		//		CarDao cardDao = (CarDao) annotationConfigApplicationContext.getBean("carDao");
//		System.out.println(cardDao.list("liuquan"));

		annotationConfigApplicationContext.close();

	}
}
