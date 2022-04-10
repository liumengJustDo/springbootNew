package com.hue.jdk.config;

import ch.qos.logback.core.FileAppender;
import com.hue.jdk.bean.Pet;
import com.hue.jdk.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Classname MyConfig
 * @Description TODO
 * @Date 2022/3/23 16:31
 * @Created by liumeng
 *
 *  1、配置类里面使用@86卽标注在方法上给容器注册组件，默认也是单实例的
 *  2、配置类本身也是组件
 *  3、proxyBeanMethods：代理bean的方法
 *  Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件;
 *  Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的
 *  组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *  4、@Import({User.class, DBHelper.class})
 * 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名 （需要无参构造）
 *
 * 5 @ConditionalOnBean(name="tom") 有tom组件才自动装配
 *
 * 6 @ImportResource("classpath:beans.xml") 引入配置文件
 *
 * 7 @EnableConfigurationProperties + @ConfigurationProperties
 *  引用第三方包的功能
 *  1.开启配置绑定
 *  2.把Car这个组件自动注册到容器中
 *
 */
//@ConditionalOnBean(name="tom")
//@EnableConfigurationProperties(car.class)
@Import({User.class, FileAppender.class})
@Configuration(proxyBeanMethods = false) //告诉SpringBoot这是一个配置类 ==配置文件
@ImportResource("classpath:beans.xml")  //引入了beans组件之后 可能与自定义的组件发生冲突
public class MyConfig {

    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean//给容器中添加文件 ，以方法名作为组件的id 返回类型就是组件类型。返回的值就是组件在容器中的实例
    public  User user01()
    {
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")  //然后我们自定义的 "tom" 就是该组件的id
    public Pet tomcatPet()
    {
     return new Pet("tomcat",11);
    }

}
