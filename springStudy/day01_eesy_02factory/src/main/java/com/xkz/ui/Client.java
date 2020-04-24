package com.xkz.ui;

import com.xkz.factory.BeanFactory;
import com.xkz.service.AccountService;
import com.xkz.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层,用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //AccountService as = new AccountServiceImpl();
        AccountService as = (AccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}
