package com.lquan.test;/**
 * Created by 01370602 on 2020/4/21.
 */

import com.lquan.config.Configration;
import com.lquan.dao.DaoFactoryBean;
import com.lquan.dao.TempDaoFactoryBean;
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
                = new AnnotationConfigApplicationContext(Configration.class);
        DaoFactoryBean daoFactoryBean = (DaoFactoryBean) annotationConfigApplicationContext.getBean("&daoFactoryBean");
        daoFactoryBean.testBean();


    //    TempDaoFactoryBean tempDaoFactoryBean = (TempDaoFactoryBean) annotationConfigApplicationContext.getBean("daoFactoryBean");
     //   tempDaoFactoryBean.test();
    }
}