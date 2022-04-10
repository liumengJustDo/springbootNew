package com.hue.jdk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * @Classname UrlController
 * @Description TODO
 * @Date 2022/3/26 21:55
 * @Created by liumeng
 */

@Slf4j
@RestController
public class UrlController {

    //    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping(value = "/user")
    public String getUser() {
        return "GET-张三";
    }

    @PostMapping(value = "/user")
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser() {
        return "POST-张三";
    }

    @PutMapping(value = "/user")
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser() {
        return "PUT-张三";
    }

    @DeleteMapping(value = "/user")
//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE-张三";
    }


//    @Bean  默认是_method
//    @ConditionalOnMissingBean(HiddenHttpMethodFilter.class)
//    @ConditionalOnProperty(prefix = "spring.mvc.hiddenmethod.filter", name = "enabled", matchIfMissing = false)
//    public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
//        return new OrderedHiddenHttpMethodFilter();
//    }


    //自定义filter  将_method改成我们喜欢的命名方式
//    @Bean
//    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
//        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
//        methodFilter.setMethodParam("_m");
//        return methodFilter;
//    }
}
