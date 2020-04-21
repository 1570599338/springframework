package com.lquan.dao;/**
 * Created by 01370602 on 2020/4/21.
 */

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * ClassName DaoFactoryBean
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {

    public void testBean(){
        System.out.println("testBean");
    }


    @Override
    public Object getObject() throws Exception {
        return new TempDaoFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        return TempDaoFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
