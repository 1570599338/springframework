package com.lquan.atImprot2.dao;/**
 * Created by 01370602 on 2020/4/27.
 */

import com.lquan.atImprot2.dao.impl.IndexDao;
import com.lquan.atImprot2.invocationHandle.MyInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * ClassName IndexDao
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class IndexDao3  implements BeanPostProcessor{

	/**
	 * 在bean初始化之前执行
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("*****哈哈哈哈哈***"+bean+"-------"+beanName);

		if (beanName.equals("indexDao")){
			System.out.println("*****哈哈indexDao哈哈哈***"+bean+"-------"+beanName);
			bean = Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{Dao.class},new MyInvocationHandler(bean));
			System.out.println("*****哈哈Proxy哈哈哈***"+bean+"-------"+beanName);

		}


		return bean;
	}

	/**
	 * 在bean的初始化之后执行
	 * <p>
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("*****postProcessAfterInitialization***"+bean+"-------"+beanName);
		return null;
	}

	public void say(){
		System.out.println("Hello IndexDao3");
	}

}
