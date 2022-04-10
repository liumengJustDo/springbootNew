package com.hue.jdk.Test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname TestInterface
 * @Description TODO
 * @Date 2022/4/7 21:44
 * @Created by liumeng
 */
@Component
public class TestInterface {

    @Autowired
     Animal animal;

    @Test
    public void testAnimal(){
        animal.speak(2); //这儿感觉有点凌乱
    }
}
