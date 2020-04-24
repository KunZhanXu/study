package com.xkz.test;

import com.xkz.dao.UserDao;
import com.xkz.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }
    @After
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis Annotation");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("北京市昌平区");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(7);
        user.setUsername("mybatis update Annotation");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("北京市丰城市");
        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){

        userDao.deleteUser(7);
    }

    @Test
    public void testFindOne(){

        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%mybatis%");
        for (User user :
                users) {
            System.out.println(user);
        }
    }

    @Test
    public void testTotalUser(){
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }
}
