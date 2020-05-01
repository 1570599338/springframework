package com.lquan.condition.config;/**
 * Created by 01370602 on 2020/5/2.
 */

import com.lquan.condition.condition.LinuxCondition;
import com.lquan.condition.condition.MacCondition;
import com.lquan.condition.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName ConditionConfig
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Configuration
@ComponentScan("com.lquan.condition")
public class ConditionConfig {


	@Conditional({MacCondition.class})
	@Bean("Mac")
	public User userM(){

		return new User("Mac","系统是Mac可以这册到容器");

	}


	@Conditional({LinuxCondition.class})
	@Bean("linux")
	public User userL(){

		return new User("linux","系统是Mac可以注册到容器");

	}


	@Bean("windows")
	public User userw(){

		return new User("windows","windows没有约束");

	}


}
