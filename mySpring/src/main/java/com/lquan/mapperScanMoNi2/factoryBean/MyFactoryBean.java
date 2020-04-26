package com.lquan.mapperScanMoNi2.factoryBean;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.mapperScanMoNi2.dao.CarDao;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

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

public class MyFactoryBean implements FactoryBean,InvocationHandler {

	private Class clazz;

	public MyFactoryBean(Class clazz){
		this.clazz = clazz;
	}


	@Override
	public Object getObject() throws Exception {
		Class[] clazzs = new Class[]{
				clazz
		};
		// 代理对象
		Object carDao = Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{CarDao.class},this);

		return carDao;
	}


	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {

		Method me = proxy.getClass().getInterfaces()[0].getMethod(method.getName(),String.class);
		Select select =me.getAnnotation(Select.class);
		System.out.println(select.value()[0]);


		System.out.println("***invoke*******");
		//return me.invoke(method,objects);
		return null;
	}
}
