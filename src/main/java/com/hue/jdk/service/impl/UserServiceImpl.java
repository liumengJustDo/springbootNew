package com.hue.jdk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hue.jdk.bean.User;
import com.hue.jdk.mapper.UserMapper;
import com.hue.jdk.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2022/4/7 20:25
 * @Created by liumeng
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
