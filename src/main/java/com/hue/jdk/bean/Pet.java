package com.hue.jdk.bean;

/**
 * @Classname Pet
 * @Description TODO
 * @Date 2022/3/23 16:25
 * @Created by liumeng
 */
public class Pet {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
