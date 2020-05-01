package com.lquan.condition;/**
 * Created by 01370602 on 2020/5/2.
 */

import com.lquan.condition.config.ConditionConfig;
import com.lquan.condition.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * ClassName TestMain
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class TestMain {





	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConditionConfig.class);

		Map<String,User> map = ac.getBeansOfType(User.class);
		System.out.println(map);


	}
}
