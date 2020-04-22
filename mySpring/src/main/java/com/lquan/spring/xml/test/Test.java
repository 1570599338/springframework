package com.lquan.spring.xml.test;/**
 * Created by 01370602 on 2020/4/22.
 */

import com.lquan.spring.xml.config.Config;
import com.lquan.spring.xml.dao.DaoFactoryBean;
import com.lquan.spring.xml.dao.TempDaoFactoryBean;
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
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				= new AnnotationConfigApplicationContext(Config.class);

		// 注意获取factorybean的实例对象需要在对应beanname前面加"&"
//		TempDaoFactoryBean daoFactoryBean = (TempDaoFactoryBean) annotationConfigApplicationContext.getBean("daoFactoryBean");
//		daoFactoryBean.getAge();
//		daoFactoryBean.getDesc();
//		daoFactoryBean.getMsg1();

		TempDaoFactoryBean daoFactoryBean1 = (TempDaoFactoryBean) annotationConfigApplicationContext.getBean("tempDaoFactoryBean");
		daoFactoryBean1.getAge();
		daoFactoryBean1.getDesc();
		daoFactoryBean1.getMsg1();



	}
}
