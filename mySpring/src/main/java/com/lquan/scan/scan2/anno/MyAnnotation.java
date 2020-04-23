package com.lquan.scan.scan2.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 01370602 on 2020/4/23.
 *
 * 自定义注解，然后自己解析
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	String value() default "";

}
