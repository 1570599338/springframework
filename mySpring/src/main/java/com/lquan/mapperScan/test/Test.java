package com.lquan.mapperScan.test;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.mapperScan.config.AppConfig;
import com.lquan.mapperScan.service.CardService;
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

		annotationConfigApplicationContext.close();

	}
}
