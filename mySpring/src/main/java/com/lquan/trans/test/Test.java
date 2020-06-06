package com.lquan.trans.test;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.trans.config.AppConfig;
import com.lquan.trans.service.IUser;
import com.lquan.trans.service.LogService;
import com.lquan.trans.service.UserServer;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName Test
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//UserServer userServer = annotationConfigApplicationContext.getBean(UserServer.class);
		IUser userServer = annotationConfigApplicationContext.getBean(IUser.class);
		//SqlSessionFactoryBean  sqlSessionFactoryBean = annotationConfigApplicationContext.getBean(SqlSessionFactoryBean.class);

		userServer.deleUser();
		System.out.println("******************清空上次结果成功***************************");
		System.out.println("******************spring事务传播开始执行***************************");
		try {
			//userServer.inserA("1234");
			userServer.insertLog("2345");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("******************执行结果查询***************************");
		if((userServer.queryList()!=null && userServer.queryList().size()>0) ||(userServer.queryListLog()!=null && userServer.queryListLog().size()>0)){
			if(userServer.queryList()!=null && userServer.queryList().size()>0){
				userServer.queryList().forEach(e->{
					System.out.println(e.toString());
				});
			}else{
				System.out.println("******************User查询数据为空************************");
			}
			System.out.println("------------------------User和Log结果分割线--------------------------------------------");
			if(userServer.queryListLog()!=null && userServer.queryListLog().size()>0){
				userServer.queryListLog().forEach(e->{
					System.out.println(e.toString());
				});
			}else{
				System.out.println("******************Log查询数据为空************************");
			}
		}else{
			System.out.println("******************User/log皆查询数据为空************************");
		}





		//annotationConfigApplicationContext.close();

	}
}
