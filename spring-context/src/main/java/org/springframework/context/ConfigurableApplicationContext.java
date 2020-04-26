/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context;

import java.io.Closeable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.lang.Nullable;

/**
 * 此接口结合了所有ApplicationContext需要实现的接口，因此大多数的ApplicationContext都要实现此接口。
 * 它在ApplicationContext的基础上增加了一系列配置应用上下文的功能。配置应用上下文和控制应用上下文生命周期的方法在此接口中被封装起来，以免客户端程序直接使用。
 *
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link org.springframework.context.ApplicationContext} interface.
 *
 * <p>Configuration and lifecycle methods are encapsulated here to avoid
 * making them obvious to ApplicationContext client code. The present
 * methods should only be used by startup and shutdown code.
 *
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 03.11.2003
 */
public interface ConfigurableApplicationContext extends ApplicationContext, Lifecycle, Closeable {

	/**
	 * Any number of these characters are considered delimiters between
	 * multiple context config paths in a single String value.
	 * @see org.springframework.context.support.AbstractXmlApplicationContext#setConfigLocation
	 * @see org.springframework.web.context.ContextLoader#CONFIG_LOCATION_PARAM
	 * @see org.springframework.web.servlet.FrameworkServlet#setContextConfigLocation
	 *
	 * 应用上下文配置时，这些符号用于分割多个配置路径
	 *
	 */
	String CONFIG_LOCATION_DELIMITERS = ",; \t\n";

	/**
	 * Name of the ConversionService bean in the factory.
	 * If none is supplied, default conversion rules apply.
	 * @since 3.0
	 * @see org.springframework.core.convert.ConversionService
	 *
	 * BeanFactory中，ConversionService类所对应的bean的名字。如果没有此类的实例的话
	 * 则使用默认的转换规则
	 *
	 */
	String CONVERSION_SERVICE_BEAN_NAME = "conversionService";

	/**
	 * Name of the LoadTimeWeaver bean in the factory. If such a bean is supplied,
	 * the context will use a temporary ClassLoader for type matching, in order
	 * to allow the LoadTimeWeaver to process all actual bean classes.
	 * @since 2.5
	 * @see org.springframework.instrument.classloading.LoadTimeWeaver
	 *
	 * LoadTimeWaver类所对应的Bean在容器中的名字。如果提供了该实例，上下文会使用临时的ClassLoader
	 * 这样，LoadTimeWaver就可以使用bean确切的类型了
	 */
	String LOAD_TIME_WEAVER_BEAN_NAME = "loadTimeWeaver";

	/**
	 * Name of the {@link Environment} bean in the factory.
	 * @since 3.1
	 *
	 * Environment类在容器中实例的名字
	 *
	 */
	String ENVIRONMENT_BEAN_NAME = "environment";

	/**
	 * Name of the System properties bean in the factory.
	 * @see java.lang.System#getProperties()
	 *
	 * System系统变量在容器中对应的Bean的名字
	 *
	 */
	String SYSTEM_PROPERTIES_BEAN_NAME = "systemProperties";

	/**
	 * Name of the System environment bean in the factory.
	 * @see java.lang.System#getenv()
	 *
	 * System 环境变量在容器中对应的Bean的名字
	 *
	 */
	String SYSTEM_ENVIRONMENT_BEAN_NAME = "systemEnvironment";


	/**
	 * Set the unique id of this application context.
	 * @since 3.0
	 *
	 * 设置容器的唯一ID
	 *
	 */
	void setId(String id);

	/**
	 * Set the parent of this application context.
	 * <p>Note that the parent shouldn't be changed: It should only be set outside
	 * a constructor if it isn't available when an object of this class is created,
	 * for example in case of WebApplicationContext setup.
	 * @param parent the parent context
	 * @see org.springframework.web.context.ConfigurableWebApplicationContext
	 *
	 * 设置此容器的父容器
	 * 需要注意的是，父容器一经设定就不应该修改。并且一般不会在构造方法中对其进行配置，因为很多时候。
	 * 其父容器还不可用。比如WebApplicationContext。
	 *
	 */
	void setParent(@Nullable ApplicationContext parent);

	/**
	 * Set the {@code Environment} for this application context.
	 * @param environment the new environment
	 * @since 3.1
	 *
	 * 设置容器的Environment变量
	 *
	 */
	void setEnvironment(ConfigurableEnvironment environment);

	/**
	 * Return the {@code Environment} for this application context in configurable
	 * form, allowing for further customization.
	 * @since 3.1
	 *
	 * 以COnfigurableEnvironment的形式返回此容器的环境变量。以使用户更好的进行配置
	 *
	 */
	@Override
	ConfigurableEnvironment getEnvironment();

	/**
	 * Add a new BeanFactoryPostProcessor that will get applied to the internal
	 * bean factory of this application context on refresh, before any of the
	 * bean definitions get evaluated. To be invoked during context configuration.
	 * @param postProcessor the factory processor to register
	 *
	 * 此方法一般在读取应用上下文配置的时候调用，用以向此容器中增加BeanFactoryPostProcessor。
	 * 增加的Processor会在容器refresh的时候使用。
	 *
	 */
	void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);

	/**
	 * Add a new ApplicationListener that will be notified on context events
	 * such as context refresh and context shutdown.
	 * <p>Note that any ApplicationListener registered here will be applied
	 * on refresh if the context is not active yet, or on the fly with the
	 * current event multicaster in case of a context that is already active.
	 * @param listener the ApplicationListener to register
	 * @see org.springframework.context.event.ContextRefreshedEvent
	 * @see org.springframework.context.event.ContextClosedEvent
	 *
	 * 向容器增加一个ApplicationListener，增加的Listener用于发布上下文事件如refresh和shutdown等
	 * 需要注意的是，如果此上下文还没有启动，那么在此注册的Listener将会在上下文refresh的时候，全部被调用
	 * 如果上下文已经是active状态的了，就会在multicaster中使用
	 *
	 */
	void addApplicationListener(ApplicationListener<?> listener);

	/**
	 * Register the given protocol resolver with this application context,
	 * allowing for additional resource protocols to be handled.
	 * <p>Any such resolver will be invoked ahead of this context's standard
	 * resolution rules. It may therefore also override any default rules.
	 * @since 4.3
	 *
	 * 向容器中注入给定的Protocol resolver，允许多个实例同时存在。
	 * 在此注册的每一个resolver都将会在上下的标准解析规则之前使用。因此，某种程度上来说
	 * 这里注册的resolver可以覆盖上下文的resolve
	 *
	 */
	void addProtocolResolver(ProtocolResolver resolver);

	/**
	 * Load or refresh the persistent representation of the configuration,
	 * which might an XML file, properties file, or relational database schema.
	 * <p>As this is a startup method, it should destroy already created singletons
	 * if it fails, to avoid dangling resources. In other words, after invocation
	 * of that method, either all or no singletons at all should be instantiated.
	 * @throws BeansException if the bean factory could not be initialized
	 * @throws IllegalStateException if already initialized and multiple refresh
	 * attempts are not supported
	 *
	 * 加载资源配置文件（XML、properties,Whatever）。
	 * 由于此方法是一个初始化方法，因此如果调用此方法失败的情况下，要将其已经创建的Bean销毁。
	 * 换句话说，调用此方法以后，要么所有的Bean都实例化好了，要么就一个都没有实例化
	 *
	 */
	void refresh() throws BeansException, IllegalStateException;

	/**
	 * Register a shutdown hook with the JVM runtime, closing this context
	 * on JVM shutdown unless it has already been closed at that time.
	 * <p>This method can be called multiple times. Only one shutdown hook
	 * (at max) will be registered for each context instance.
	 * @see java.lang.Runtime#addShutdownHook
	 * @see #close()
	 *
	 * 向JVM注册一个回调函数，用以在JVM关闭时，销毁此应用上下文。
	 *
	 */
	void registerShutdownHook();

	/**
	 * Close this application context, releasing all resources and locks that the
	 * implementation might hold. This includes destroying all cached singleton beans.
	 * <p>Note: Does <i>not</i> invoke {@code close} on a parent context;
	 * parent contexts have their own, independent lifecycle.
	 * <p>This method can be called multiple times without side effects: Subsequent
	 * {@code close} calls on an already closed context will be ignored.
	 *
	 * 关闭此应用上下文，释放其所占有的所有资源和锁。并销毁其所有创建好的singleton Beans
	 * 实现的时候，此方法不应该调用其父上下文的close方法，因为其父上下文具有自己独立的生命周期
	 * 多次调用此方法，除了第一次，后面的调用应该被忽略。
	 *
	 */
	@Override
	void close();

	/**
	 * Determine whether this application context is active, that is,
	 * whether it has been refreshed at least once and has not been closed yet.
	 * @return whether the context is still active
	 * @see #refresh()
	 * @see #close()
	 * @see #getBeanFactory()
	 *
	 * 检测此FactoryBean是否被启动过。
	 *
	 */
	boolean isActive();

	/**
	 * Return the internal bean factory of this application context.
	 * Can be used to access specific functionality of the underlying factory.
	 * <p>Note: Do not use this to post-process the bean factory; singletons
	 * will already have been instantiated before. Use a BeanFactoryPostProcessor
	 * to intercept the BeanFactory setup process before beans get touched.
	 * <p>Generally, this internal factory will only be accessible while the context
	 * is active, that is, in-between {@link #refresh()} and {@link #close()}.
	 * The {@link #isActive()} flag can be used to check whether the context
	 * is in an appropriate state.
	 * @return the underlying bean factory
	 * @throws IllegalStateException if the context does not hold an internal
	 * bean factory (usually if {@link #refresh()} hasn't been called yet or
	 * if {@link #close()} has already been called)
	 * @see #isActive()
	 * @see #refresh()
	 * @see #close()
	 * @see #addBeanFactoryPostProcessor
	 *
	 * 返回此应用上下文的容器。
	 * 千万不要使用此方法来对BeanFactory生成的Bean做后置处理，因为单例Bean在此之前已经生成。
	 * 这种情况下应该使用BeanFactoryPostProcessor来在Bean生成之前对其进行处理。
	 * 通常情况下，内容容器只有在上下文是激活的情况下才能使用。因此，在使用此方法前，可以调用
	 * isActive来判断容器是如可用
	 *
	 */
	ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;

}
