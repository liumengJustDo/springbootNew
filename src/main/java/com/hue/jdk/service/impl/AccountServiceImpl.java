package com.hue.jdk.service.impl;

import com.hue.jdk.bean.Account;
import com.hue.jdk.mapper.AccountMapper;
import com.hue.jdk.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2022/4/7 11:39
 * @Created by liumeng
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctId(long id ){
        return  accountMapper.getAcct(id);
    }
}
