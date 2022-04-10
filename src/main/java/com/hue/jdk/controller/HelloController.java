package com.hue.jdk.controller;

import com.hue.jdk.bean.Car;
import com.hue.jdk.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname helloController
 * @Description TODO
 * @Date 2022/3/23 15:02
 * @Created by liumeng
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @Autowired
    Person person;

    @Value("${person.name:李四}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "hello 你好"+name;
    }

    @RequestMapping("/car")
    public Car RequestCar()
    {
        return  car;
    }

    @RequestMapping("/person")
    public Person testPerson(){
        return person;
    }
}
