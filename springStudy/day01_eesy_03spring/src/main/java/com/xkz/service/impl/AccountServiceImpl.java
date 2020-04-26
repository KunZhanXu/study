package com.xkz.service.impl;

import com.xkz.dao.AccountDao;
import com.xkz.dao.impl.AccountDaoImpl;
import com.xkz.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
