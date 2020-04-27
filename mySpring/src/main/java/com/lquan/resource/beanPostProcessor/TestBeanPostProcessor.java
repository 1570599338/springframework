package com.lquan.resource.beanPostProcessor;/**
 * Created by 01370602 on 2020/4/23.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * ClassName TestBeanPostProcessor
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Component
public class TestBeanPostProcessor  implements BeanPostProcessor,PriorityOrdered{
	/**
	 * 在bean初始化之前执行
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if("indexDao".equals(beanName)){
			System.out.println("indexDao--postProcessBeforeInitialization0");
		}

		return bean;
	}

	/**
	 * 在bean的初始化之后执行
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if("indexDao".equals(beanName)){
			System.out.println("indexDao--postProcessAfterInitialization0");
		}
		return bean;
	}


	/**
	 * Get the order value of this object.
	 * <p>Higher values are interpreted as lower priority. As a consequence,
	 * the object with the lowest value has the highest priority (somewhat
	 * analogous to Servlet {@code load-on-startup} values).
	 * <p>Same order values will result in arbitrary sort positions for the
	 * affected objects.
	 *
	 * @return the order value
	 * @see #HIGHEST_PRECEDENCE
	 * @see #LOWEST_PRECEDENCE
	 */
	@Override
	public int getOrder() {
		return 101;
	}
}
