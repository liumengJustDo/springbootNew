package com.hue.jdk;

import ch.qos.logback.core.FileAppender;
import com.hue.jdk.bean.Pet;
import com.hue.jdk.bean.User;
import com.hue.jdk.config.MyConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @SpringBootConfiguration
 *当前是一个配置类
 *
 * @EnableAutoConfiguration
 *     1 @AutoConfigurationPackage
 *         @Import(AutoConfigurationPackages.Registrar.class)
 *         利用Register给容器中导入一系列组件
 *         将指定的下一个包下的所有组件导入进来 SpringBootApplication
 *     2 @Import(AutoConfigurationImportSelector.class)
 *          1、利用getAutoConfigurationEntry(annotationMetadata);给容器中批量导入一些组件
 *          2、调用List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes)获取到所有需要导入到容器中的配置类
 *          3、利用工厂加载 Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader)；得到所有的组件
 *          4、从META-INF/spring.factories位置来加载一个文件。
 *            默认扫描我们当前系统里面所有META-INF/spring.factories位置的文件
 *          6、spring-boot-autoconfigure-2.3.4.RELEASE.jar包里面也有META-INF/spring.factories
 *
 * @ComponentScan() 指定扫描哪些 Spring注解
 *
 * 也就是SpringBoot中自动配置类一般会利用EnableAutoConfiguration注解把配置文件中的属性封装到一个java bean类中，利用这个封装类为其组件注入值
 *
 */

@MapperScan("com.hue.jdk.mapper")  //扫描Mapper映射
@ServletComponentScan(basePackages = "com.hue.jdk")  //指定原生Servlet组件都放在那里
@SpringBootApplication() // 取消自动资源配置  exclude = DataSourceAutoConfiguration.class
public class SpringBootTestApplication {

    public static void main(String[] args) {
        //1 返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootTestApplication.class, args);
        //2 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3 从容器中获取组件 注册的实例就是单实例的
        Pet tom01 = run.getBean("tom", Pet.class);

        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("组件"+(tom01==tom02));  //true

        //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
        MyConfig bean = run.getBean(MyConfig.class);
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user ==user1);//true

        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);

        System.out.println("用户的宠物："+(user01.getPet() == tom));


        //5获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);//这里需要添加无参构造方法
        System.out.println("============");
        for(String str:beanNamesForType){
            System.out.println(str);
        }
        FileAppender bean1 = run.getBean(FileAppender.class);
        System.out.println(bean1);


         boolean tom11 = run.containsBean("tom");
         System.out.println("容器中Tom组件："+tom11);

         boolean user11 = run.containsBean("user01");
         System.out.println("容器中user01组件："+user11);

         boolean tom22 = run.containsBean("tom22");
         System.out.println("容器中tom22组件："+tom22);
     }
}