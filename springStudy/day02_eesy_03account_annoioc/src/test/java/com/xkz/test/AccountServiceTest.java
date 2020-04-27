package com.xkz.test;

import com.xkz.domain.Account;
import com.xkz.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试:测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account :
                accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(123456f);
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        as.deleteAccount(4);
    }
}
