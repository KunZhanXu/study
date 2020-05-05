package com.xkz.jdbctemplate;

import com.xkz.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD操作
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
        //保存
        //jt.update("insert into account1(name,money)values(?,?)","fff",333f);
        //更新
        //jt.update("update account1 set name=?,money=? where id=?","test",4567,5);
        //删除
        //jt.update("delete from account1 where id=?",5);
        //查询所有
        /*List<Account> accounts = jt.query("select * from account1 where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 100f);
        for (Account account : accounts) {
            System.out.println(account);
        }*/
        //查询一个
        /*List<Account> accounts = jt.query("select * from account1 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));*/
        //查询返回一行一列(使用聚合函数,但不加group by字句)
        Long count = jt.queryForObject("select count(*) from account where money > ?",Long.class,1000f);
        System.out.println(count);


    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封装到Account中,然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}