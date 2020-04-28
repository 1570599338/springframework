package com.lquan.atImprot2.anno;

import com.lquan.atImprot2.improts.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author 01370602
 * @date 2020/4/28
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)
public @interface EnableLQuan {

	String value() default "";


	boolean falg() default false;
}
