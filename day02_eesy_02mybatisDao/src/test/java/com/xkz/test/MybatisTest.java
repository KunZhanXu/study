package com.xkz.test;

import com.xkz.dao.UserDao;
import com.xkz.dao.impl.UserDaoImpl;
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

public class MybatisTest {
    private InputStream in;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂对象,创建dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {

        //6.释放资源
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("dao impl user");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前：" + user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后：" + user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3);
        user.setUsername("user dao impl Update user");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前：" + user);
        //5.执行更新方法
        userDao.updateUser(user);


        System.out.println("保存操作之后：" + user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {

        //5.执行删除方法
        userDao.deleteUser(3);
    }

    /**
     * 测试查询一个操作
     */
    @Test
    public void testFindOne() {

        //5.执行查询一个方法
        User user = userDao.findById(3);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName() {

        //5.执行查询一个方法
        List<User> users = userDao.findByName("%王%");
        //List<User> users = userDao.findByName("王");
        for (User user :
                users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal() {

        //5.执行查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }

    /**
     * 测试使用queryVo作为查询条件
     */
    /*@Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        vo.setUser(user);
        //5.执行查询一个方法
        //List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }*/
}
