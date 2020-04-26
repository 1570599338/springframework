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

/**
 * A common interface defining methods for start/stop lifecycle control.
 * The typical use case for this is to control asynchronous processing.
 * <b>NOTE: This interface does not imply specific auto-startup semantics.
 * Consider implementing {@link SmartLifecycle} for that purpose.</b>
 *
 * <p>Can be implemented by both components (typically a Spring bean defined in a
 * Spring context) and containers  (typically a Spring {@link ApplicationContext}
 * itself). Containers will propagate start/stop signals to all components that
 * apply within each container, e.g. for a stop/restart scenario at runtime.
 *
 * <p>Can be used for direct invocations or for management operations via JMX.
 * In the latter case, the {@link org.springframework.jmx.export.MBeanExporter}
 * will typically be defined with an
 * {@link org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler},
 * restricting the visibility of activity-controlled components to the Lifecycle
 * interface.
 *
 * <p>Note that the present {@code Lifecycle} interface is only supported on
 * <b>top-level singleton beans</b>. On any other component, the {@code Lifecycle}
 * interface will remain undetected and hence ignored. Also, note that the extended
 * {@link SmartLifecycle} interface provides sophisticated integration with the
 * application context's startup and shutdown phases.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see SmartLifecycle
 * @see ConfigurableApplicationContext
 * @see org.springframework.jms.listener.AbstractMessageListenerContainer
 * @see org.springframework.scheduling.quartz.SchedulerFactoryBean
 */
public interface Lifecycle {

	/**
	 * Start this component.
	 * <p>Should not throw an exception if the component is already running.
	 * <p>In the case of a container, this will propagate the start signal to all
	 * components that apply.
	 * @see SmartLifecycle#isAutoStartup()
	 *
	 * 启动当前组件
	 * <p>如果组件已经在运行，不应该抛出异常
	 * <p>在容器的情况下，这会将 开始信号 传播到应用的所有组件中去。
	 */
	void start();

	/**
	 * Stop this component, typically in a synchronous fashion, such that the component is
	 * fully stopped upon return of this method. Consider implementing {@link SmartLifecycle}
	 * and its {@code stop(Runnable)} variant when asynchronous stop behavior is necessary.
	 * <p>Note that this stop notification is not guaranteed to come before destruction:
	 * On regular shutdown, {@code Lifecycle} beans will first receive a stop notification
	 * before the general destruction callbacks are being propagated; however, on hot
	 * refresh during a context's lifetime or on aborted refresh attempts, a given bean's
	 * destroy method will be called without any consideration of stop signals upfront.
	 * <p>Should not throw an exception if the component is not running (not started yet).
	 * <p>In the case of a container, this will propagate the stop signal to all components
	 * that apply.
	 * @see SmartLifecycle#stop(Runnable)
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 *
	 * (1)通常以同步方式停止该组件，当该方法执行完成后,该组件会被完全停止。当需要异步停止行为时，考虑实现SmartLifecycle 和它的 stop(Runnable) 方法变体。

	 *  注意，此停止通知在销毁前不能保证到达:在*常规关闭时，{@code Lifecycle} bean将首先收到一个停止通知，然后才传播*常规销毁回调;
	 *  然而，在*上下文的生命周期内的热刷新或中止的刷新尝试上，只调用销毁方法对于容器，这将把停止信号传播到应用的所有组件*
	 *
	 *
	 */
	void stop();

	/**
	 * Check whether this component is currently running.
	 * <p>In the case of a container, this will return {@code true} only if <i>all</i>
	 * components that apply are currently running.
	 * @return whether the component is currently running
	 *  检查此组件是否正在运行。
	 *  1. 只有该方法返回false时，start方法才会被执行。
	 *  2. 只有该方法返回true时，stop(Runnable callback)或stop()方法才会被执行。
	 */
	boolean isRunning();

}
