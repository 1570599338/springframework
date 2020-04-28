package com.lquan.atImprot1.test;/**
 * Created by 01370602 on 2020/4/27.
 */

import com.lquan.atImprot1.config.AppConfig;
import com.lquan.atImprot1.dao.IndexDao3;
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

		annotationConfigApplicationContext.getBean(IndexDao3.class).say();

	}
}
