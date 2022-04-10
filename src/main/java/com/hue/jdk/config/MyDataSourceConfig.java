package com.hue.jdk.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Classname MyDataSourceConfig
 * @Description TODO
 * @Date 2022/4/6 19:20
 * @Created by liumeng
 */

//@Configuration
public class MyDataSourceConfig {

    //默认自动的配置是判断容器中没有才会配置 @ConditionalOnMissingBean({ DataSource.class, XADataSource.class })
//    @ConfigurationProperties("spring.datasource")
//    @Bean
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();

//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();

// stat 加入监控功能 wall 防火墙功能
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /**
     * 配置druid的监控页功能
     */
//    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean =
                new ServletRegistrationBean<StatViewServlet>(statViewServlet, "/druid/*");

        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");
        return registrationBean;
    }

    /**
     * WebStatFilter用于采集web-jdbc关联监控的数据。
     */
//    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean =
                new FilterRegistrationBean<WebStatFilter>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }

}
