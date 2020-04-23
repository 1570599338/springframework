package com.lquan.scan.scan2.spring;/**
 * Created by 01370602 on 2020/4/23.
 */

import com.lquan.scan.scan2.anno.MyAnnotation;

import java.io.File;

/**
 * ClassName AnnotationConfigApplicationContextLQuan
 *
 * @Author lquan
 * @Description //TODO
 *
 * 模拟解析spring的包扫描
 *
 *
 * @Date
 * @Param
 * @return
 **/
public class AnnotationConfigApplicationContextLQuan {

	/**
	 * 模拟spring扫描包扫描获取对应的注解
	 * @param basePackage
	 */
	public void scan(String basePackage){
		String rootPath = this.getClass().getResource("/").getPath();

		String basePackagePath = basePackage.replaceAll("\\.","/");

		File file = new File(rootPath+"//"+basePackagePath);
		String names[] = file.list();
		for (String name : names) {
			name =  name.replaceAll(".class","");
			try {
				Class clazz = Class.forName(basePackage+"."+name);
				//
				if(clazz.isAnnotationPresent(MyAnnotation.class)){
					MyAnnotation ann= (MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
					System.out.println(ann.value());
					System.out.println(clazz.newInstance());

				}




			} catch (Exception e) {
				e.printStackTrace();
			}


		}



	}


}
