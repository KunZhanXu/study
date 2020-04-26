package com.xkz.service.impl;

import com.xkz.dao.AccountDao;
import com.xkz.dao.impl.AccountDaoImpl;
import com.xkz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 账户的业务层实现类
 *
 * 曾经XML的配置
 * <bean id="accountService" class="com.xkz.service.impl.AccountServiceImpl"
 *            scope="" init-method="" destory-method="">
 *          <property name="" value="" | ref=""></property>
 * </bean>
 *
 *
 * 用于创建对象的
 *        他们的作用就和在xml配置文件中编写了一个<bean>标签实现的功能是一样的
 *        @Component:
 *              作用:用于把当前类对象存入spring容器中
 *              属性:
 *                  value:用于指定bean的id.当我们不写时,它的默认值是当前类名,且首字母改小写.
 *        @Controller:一般用于表现层
 *        @Service:一般用在业务层
 *        @Repository:一般用在持久层
 *        以上三个注解于Component是一模一样的.
 *        他们三个是spring框架为我们提供明确的三层使用的注解,使我们的三层对象更加清晰
 *
 *
 * 用于注入数据的
 *        他们的作用就和在xml配置文件中的bean标签写一个<property>标签的作用是一样的
 *        @AutoWired:
 *              作用:自动按照类型注入.只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配,就可以注入成功
 *                   如果ioc容器中没有任何bean的类型和要注入的变量类型匹配,则报错.
 *              出现位置:
 *                      可以是变量上,也可以是方法
 *              细节:
 *                      使用注解注入时,set方法就不是必须的了
 * 用于改变作用范围的
 *        他们的作用就和在bean标签中使用scope属性实现的功能是一样的
 * 和生命周期相关的
 *        他们的作用就和在bean标签中使用init-method和destory-method的作用是相同的
 */
@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
