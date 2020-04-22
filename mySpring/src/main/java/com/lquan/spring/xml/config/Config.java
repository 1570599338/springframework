package com.lquan.spring.xml.config;/**
 * Created by 01370602 on 2020/4/22.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * ClassName Config
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Configuration
@ComponentScan("com.lquan.spring.xml")
@ImportResource("classpath:spring.xml")
public class Config {
}
