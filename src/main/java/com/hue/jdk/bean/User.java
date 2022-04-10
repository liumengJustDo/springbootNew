package com.hue.jdk.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname User
 * @Description TODO
 * @Date 2022/3/23 16:25
 * @Created by liumeng
 */

@Data
@AllArgsConstructor
// @TableName("user_tbl") 如若与数据库中的表名不一致 则可以重命名该表名
public class User {
    //此属性在表中不存在
    @TableField(exist = false)
    private  String username;
    @TableField(exist = false)
    private String password;

    //以下是数据库字段
    private long id;
    private int age;
    private String name;
    private String email;

    @TableField(exist = false)
    private Pet pet;


    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
