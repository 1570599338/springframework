#

## BeanFactory和FactoryBean的区别
### 功能实现分别在com.lquan.spring.annotion和com.lquan.spring.xml包下


## spring包扫描

### 问题 初始化spring的环境有几种方法 com.lquan.scan.scan1
xml             ClassPathXmlApplicationContext      类的扫描     单独bean的注册(声明和注册)

annotaion       需要结合xml和javaconfig来完成

javaconfig      AnnotationConfigApplicationContext      类的扫描    类的定义


###  模拟扫描spring的包扫描功能 com.lquan.scan.scan2
