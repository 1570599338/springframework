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

添加了@Configuration注解作用是，让对应的Congfig类能够去产生CGLIB代理，CGLIB回去实现一个类，并注入一个FactoryBean






###@Improt的注解的使用方式  com.lquan.atImprot
1、使用普通类
2、使用实现了ImportSelector接口的类
    作用：可以动态的开闭默写功能
3、使用实现了ImportBeanDefinitionRegistrar接口的类
    

###full和lite的区别

full表示他是一个全配置类，spring在为这个配置类生成bean的时候他会加上cglib代理

lite表示他是一个部分配置类，spring在为这个配置类生成bean的时候他会是原生的




### spring的后置处理器
BeanPostProcessor：插手spring实例过程，实例化之后，在bean没有被spring的bean容器管理之前干活
                    经典场景：1、bean的初始化@PostConstruct，初始化的类CommonAnnotationBeanPostProcessor
                             2、aop
                             
                             
BeanFactoryPostProcessor：  springbean容器当中任意的一个bean被new出来之前执行，针对beaFactory来创建， 
                            经典场景: 1、ConfigurationClassPostProcessor#postProcessorBeanFactory针对配置类加上cglib代理
                                    
                                    
BeanDefinitionRegistryPostProcessor: 是BeanFactoryPostProcessor的子类在BeanFactoryPostProcessor之前执行？因为源码当中先遍历的BeanDefinitionRegistryPostProcessor
                                     ，并且 BeanDefinitionRegistryPostProcessor有spring系统提供的，还有自定义的，自定义的先执行
                                     经典场景:   ConfigurationClassPostProcessor类这个类实现了spring核心类，实现扫描共功能 、3中import的扫描、@Bean的扫描、 
                                                 判断配置类是否是一个完整的配置类。
                                                 
                                                 
                                                 
importSelect ：通过这个方法 selectImports返回一个类名（全名），把它编程bd动态添加bd(这个bd是死的)                                                                               
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    

 