package com.xkz.test;

import com.xkz.dao.UserDao;
import com.xkz.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //根据字节输入流创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //根据SqlSessionFactory创建一个SqlSession
        SqlSession sqlSession = factory.openSession(true);
        //使用SqlSession获取Dao的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //执行Dao方法
        List<User> users = userDao.findAll();
        for (User user :
                users) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        in.close();
    }
}
