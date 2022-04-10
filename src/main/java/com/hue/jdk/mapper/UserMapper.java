package com.hue.jdk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hue.jdk.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2022/4/7 20:06
 * @Created by liumeng
 */


/**
 * 只需要我们的Mapper 继承了BaseMapper就可以拥有crud能力
 *
 */
@Repository
public interface UserMapper  extends BaseMapper<User> {

}
