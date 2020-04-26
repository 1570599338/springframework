package com.lquan.mapperScanMoNi2.config;/**
 * Created by 01370602 on 2020/4/26.
 */

import com.lquan.mapperScanMoNi2.ImportBeanDefinitionRegistrar.MyImportBeanDefinitionRegistrar;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * ClassName AppConfig
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@Configurable
@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan("com.lquan.mapperScanMoNi2")
public class AppConfig {



	@Autowired
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}


//	@Bean
//	public  NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource){
//		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//
//
//		return namedParameterJdbcTemplate;
//	}


	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		driverManagerDataSource.setUrl("jdbc:mysql://112.125.90.15:3309/store?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return driverManagerDataSource;
	}





























}
