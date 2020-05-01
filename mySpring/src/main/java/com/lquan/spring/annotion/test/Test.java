package com.lquan.spring.annotion.test;/**
 * Created by 01370602 on 2020/4/21.
 */

import com.lquan.spring.annotion.dao.DaoFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import  com.lquan.spring.annotion.config.Configration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
                = new AnnotationConfigApplicationContext(Configration.class);

        // 注意获取factorybean的实例对象需要在对应beanname前面加"&"
        DaoFactoryBean daoFactoryBean = (DaoFactoryBean) annotationConfigApplicationContext.getBean("&daoFactoryBean");
        daoFactoryBean.testBean();




//        TempDaoFactoryBean tempDaoFactoryBean = (TempDaoFactoryBean) annotationConfigApplicationContext.getBean("daoFactoryBean");
//        tempDaoFactoryBean.test();
    }
}
