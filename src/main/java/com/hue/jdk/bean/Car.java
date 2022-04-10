package com.hue.jdk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname Car
 * @Description TODO
 * @Date 2022/3/24 10:36
 * @Created by liumeng
 *
 * 只有在容器中的组件 才有SpringBoot提供的强大功能
 *
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private  String brand;
    private Integer price;


}
