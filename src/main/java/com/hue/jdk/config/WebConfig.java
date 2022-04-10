package com.hue.jdk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @Classname WebConfig
 * @Description TODO
 * @Date 2022/3/29 19:14
 * @Created by liumeng
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {

    //@Bean  默认是_method
//    @ConditionalOnMissingBean(HiddenHttpMethodFilter.class)
//    @ConditionalOnProperty(prefix = "spring.mvc.hiddenmethod.filter", name = "enabled", matchIfMissing = false)
//    public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
//        return new OrderedHiddenHttpMethodFilter();
//    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        //不移除  后面的内容 矩阵变量功能才能生效
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

}
