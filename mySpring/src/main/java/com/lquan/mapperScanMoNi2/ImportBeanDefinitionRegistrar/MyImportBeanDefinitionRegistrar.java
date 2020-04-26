package com.lquan.mapperScanMoNi2.ImportBeanDefinitionRegistrar;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.mapperScanMoNi2.InvocationHandler.MyInvocationHandler;
import com.lquan.mapperScanMoNi2.dao.CarDao;
import com.lquan.mapperScanMoNi2.factoryBean.MyFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ClassName MyImportBeanDefinitionRegistrar
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


	/**
	 * Register bean definitions as necessary based on the given annotation metadata of
	 * the importing {@code @Configuration} class.
	 * <p>Note that {@link// BeanDefinitionRegistryPostProcessor} types may <em>not</em> be
	 * registered here, due to lifecycle constraints related to {@code @Configuration}
	 * class processing.
	 *
	 * @param importingClassMetadata annotation metadata of the importing class
	 * @param registry               current bean definition registry
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		// 1、得到bd
		// 扫描所有的接口
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CarDao.class);
		//
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();

		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
		beanDefinition.setBeanClass(MyFactoryBean.class);

		// 注入Spring容器中
		registry.registerBeanDefinition("carDao",beanDefinition);

	}
}