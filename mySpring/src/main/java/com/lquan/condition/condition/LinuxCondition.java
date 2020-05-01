package com.lquan.condition.condition;/**
 * Created by 01370602 on 2020/5/2.
 */

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * ClassName MacCondition
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class LinuxCondition implements Condition{


	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String name  = context.getEnvironment().getProperty("os.name");
		if(name.contains("linux")){
			return true;
		}
		return false;
	}
}
