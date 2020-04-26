package com.lquan.mapperScanMoNi1.InvocationHandler;/**
 * Created by 01370602 on 2020/4/26.
 */

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
//	private Object o;
//
//	public MyInvocationHandler(Object o){
//		this.o = o;
//	}

	@Override
	public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

		System.out.println("***invoke*******");
		return null;//method.invoke( method, objects);
	}
}
