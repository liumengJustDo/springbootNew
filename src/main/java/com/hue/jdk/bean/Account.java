package com.hue.jdk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

    private Long id;
    private String userId;
    private Integer money;

}
