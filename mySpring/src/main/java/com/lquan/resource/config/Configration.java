package com.lquan.resource.config;/**
 * Created by 01370602 on 2020/4/23.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName Configration
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Configuration
@ComponentScan("com.lquan.resource")
@MapperScan("")
public class Configration {
}
