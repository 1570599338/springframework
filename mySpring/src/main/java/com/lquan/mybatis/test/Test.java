package com.lquan.mybatis.test;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.mybatis.config.AppConfig;
import com.lquan.mybatis.service.CardService;
import org.mybatis.spring.SqlSessionFactoryBean;
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


	}
}
