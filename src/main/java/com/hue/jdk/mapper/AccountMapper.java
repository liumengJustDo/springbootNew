package com.hue.jdk.mapper;

import com.hue.jdk.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname AccountMapper
 * @Description TODO
 * @Date 2022/4/7 11:20
 * @Created by liumeng
 */

@Repository
@Mapper
public interface AccountMapper {

     public Account getAcct(long id);

}
