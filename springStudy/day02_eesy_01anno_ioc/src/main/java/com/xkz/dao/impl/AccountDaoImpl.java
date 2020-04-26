package com.xkz.dao.impl;

import com.xkz.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDaoImpl")
public class AccountDaoImpl implements AccountDao {
    public void saveAccount(){
        System.out.println("保存了账户");
    }
}
