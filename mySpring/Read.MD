#

## BeanFactory和FactoryBean的区别
### 功能实现分别在com.lquan.spring.annotion和com.lquan.spring.xml包下


## spring包扫描

### 问题 初始化spring的环境有几种方法 com.lquan.scan.scan1
xml             ClassPathXmlApplicationContext      类的扫描     单独bean的注册(声明和注册)

annotaion       需要结合xml和javaconfig来完成

javaconfig      AnnotationConfigApplicationContext      类的扫描    类的定义


###  模拟扫描spring的包扫描功能 com.lquan.scan.scan2


## spring的源码

1、spring中的bean的信息描述类
java中描述java类的信息--> class---->Class
Spring中的bean--->BeanDefinition




#### 2、spring的bean扩展有哪些？
答：一共5种
1、BeanPostProcessor：在每个bena初始化成前后做操作。
    BeanPostProcessor接口扩展PriorityOrdered这个接口可以实现队形实现类在ioc容器中的执行顺序。

2、BeanFactoryPostProcessor: Spring允许在Bean创建之前，读取Bean的元属性，并根据自己的需求对元属性进行改变，比如将Bean的scope从singleton改变为prototype。


3、BeanDefinitionRegistryPostProcessor




 