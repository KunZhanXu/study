package com.xkz.ui;

import com.xkz.service.AccountService;
import com.xkz.service.impl.AccountServiceImpl;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;


/**
 * 模拟一个表现层,用于调用业务层
 */
public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取获取Bean对象
        AccountService as = (AccountService)ac.getBean("accountService");
        as.saveAccount();

        //手动关闭容器
        ac.close();

    }
}
