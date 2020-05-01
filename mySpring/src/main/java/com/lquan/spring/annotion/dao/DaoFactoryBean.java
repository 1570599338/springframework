package com.lquan.spring.annotion.dao;/**
 * Created by 01370602 on 2020/4/21.
 */

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * ClassName DaoFactoryBean
 *
 * @Author lquan
 * @Description //TODO
 * 如果一个类实现了FactoryBean
 * 那么spring容器当中存在两个对象
 * 一个是getObject()返回的对象
 * 还有一个是当前对象
 *
 *
 * getObject得到的对象存在是当前类指定的名字
 *
 * 实现factoryBean对象是 "&" +当前类的名字
 *
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
