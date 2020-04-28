package com.lquan.atImprot1.config;/**
 * Created by 01370602 on 2020/4/27.
 */

import com.lquan.atImprot1.anno.EnableLQuan;
import com.lquan.atImprot1.improts.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * ClassName AppConfig
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@ComponentScan("com.lquan.atImprot1")
 @EnableLQuan(falg = true)
public class AppConfig {
}
