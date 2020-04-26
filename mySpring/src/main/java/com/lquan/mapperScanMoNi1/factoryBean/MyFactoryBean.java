package com.lquan.mapperScanMoNi1.factoryBean;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.mapperScanMoNi1.InvocationHandler.MyInvocationHandler;
import com.lquan.mapperScanMoNi1.dao.CardDao;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

/**
 * ClassName MyFactoryBean
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 *
 **/
@Component
public class MyFactoryBean implements FactoryBean {

	//private Class clzz =CardDao.class;


	@Override
	public Object getObject() throws Exception {
		Class[] clazz = new Class[]{CardDao.class};
		// 代理对象
		Object proxy =  Proxy.newProxyInstance(this.getClass().getClassLoader(),clazz,new MyInvocationHandler());

		return proxy;
	}


	@Override
	public Class<?> getObjectType() {
		return CardDao.class;
	}
}
