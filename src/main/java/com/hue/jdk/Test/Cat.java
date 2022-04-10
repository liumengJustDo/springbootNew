package com.hue.jdk.Test;

import org.springframework.stereotype.Component;

/**
 * @Classname Cat
 * @Description TODO
 * @Date 2022/4/7 21:42
 * @Created by liumeng
 */
@Component
public class Cat implements Animal {
    private  String name;

    public void speak(int i) {
        System.out.println("发出第"+i+"种叫声");
    }
}
