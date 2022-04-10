package com.hue.jdk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;

}
