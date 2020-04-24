package com.xkz.service.impl;

import com.xkz.dao.AccountDao;
import com.xkz.dao.impl.AccountDaoImpl;
import com.xkz.factory.BeanFactory;
import com.xkz.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
