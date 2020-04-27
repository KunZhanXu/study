package com.xkz.service.impl;

import com.xkz.service.AccountService;

import javax.accessibility.AccessibleIcon;
import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    //如果是经常变化的数据,并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了..."+name+","+age+","+birthday);
    }

}