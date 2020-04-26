package com.lquan.mapperScanMoNi2.InvocationHandler;/**
 * Created by 01370602 on 2020/4/26.
 */

import org.apache.ibatis.annotations.Select;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * ClassName MyInvocationHandler
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class MyInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {


		Method me = proxy.getClass().getInterfaces()[0].getMethod(method.getName(),String.class);
		Select select =me.getAnnotation(Select.class);
		System.out.println(select.value());


		System.out.println("***invoke*******");
		return me.invoke(method,objects);
	}
}
