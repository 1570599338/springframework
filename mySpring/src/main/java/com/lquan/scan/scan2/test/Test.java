package com.lquan.scan.scan2.test;/**
 * Created by 01370602 on 2020/4/23.
 */

import com.lquan.scan.scan2.spring.AnnotationConfigApplicationContextLQuan;

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
		AnnotationConfigApplicationContextLQuan annotationConfigApplicationContextLQuan =
				new AnnotationConfigApplicationContextLQuan();
		annotationConfigApplicationContextLQuan.scan("com.lquan.scan.scan2.dao");
	}

}
