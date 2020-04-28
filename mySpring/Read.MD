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
1、BeanPostProcessor：在每个bena初始化成前后做操作。--(com.lquan.resource)
    BeanPostProcessor接口扩展PriorityOrdered这个接口可以实现队形实现类在ioc容器中的执行顺序。

2、BeanFactoryPostProcessor: Spring允许在Bean创建之前，读取Bean的元属性，并根据自己的需求对元属性进行改变，比如将Bean的scope从singleton改变为prototype。


3、BeanDefinitionRegistryPostProcessor





##### @Import()注解
这个注解主要可以导入三种类型
一种普通的类 例如@Import(IndexDao.class)
第二种是，处理 ImportSelector类
第三种是，处理 ImportBeanDefinitionRegistrar 类


### Spring中添加bean有几种方式
1、register() 需要的一个类  没有办法参与 bd
2、scan() 需要的一个类  没有办法参与 bd
3、@Import() 中实现ImportBeanDefinitionRegistrar接口的类  可以参与 bd


@MapperScan()注解主要扫描mapper
他可以将接口转换成对象



### @Configuration的作用是什么？凭什么写它

因为Spring会在加了@@Configuration的类中在实例化的时候，属性会加一个full
@Component、@ComponentScan、@Import、@ImportResource属性的会加lite






###@Improt的注解的使用方式  com.lquan.atImprot
1、使用普通类
2、使用实现了ImportSelector接口的类
    作用：可以动态的开闭默写功能
3、使用实现了ImportBeanDefinitionRegistrar接口的类
    








 