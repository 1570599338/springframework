package com.lquan.atImprot2.config;/**
 * Created by 01370602 on 2020/4/27.
 */

import com.lquan.atImprot2.anno.EnableLQuan;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName AppConfig
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/

@ComponentScan("com.lquan.atImprot2")
 @EnableLQuan(falg = true)
public class AppConfig {
}
