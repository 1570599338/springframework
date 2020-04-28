package com.lquan.atImprot2.invocationHandle;/**
 * Created by 01370602 on 2020/4/28.
 */

import java.lang.reflect.InvocationHandler;
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
public class MyInvocationHandler implements InvocationHandler{

	private  Object target;

	public MyInvocationHandler(Object target){
		this.target = target;

	}
	/**
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


		System.out.println("代理");
		return method.invoke(target,args);
	}
}
