package com.xkz.test;

import com.xkz.domain.Account;
import com.xkz.service.AccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试:测试我们的配置
 * Spring整合junit的配置
 *      1.导入spring整合Junit的jar坐标
 *      2.使用Junit提供的一个注解把原有的main方法替换了,替换成spring提供的
 *      3.告知spring的运行器,spring和ioc创建基本xml还是注解的,并说明位置
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

    private ApplicationContext ac;
    private AccountService as;

    @Before
    public void init(){
        //获取容器
        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        //得到业务层对象
        as = ac.getBean("accountService", AccountService.class);
    }
    @Test
    public void testFindAll() {
        //执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account :
                accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        //执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(123456f);
        //执行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        //执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        //执行方法
        as.deleteAccount(4);
    }
}
