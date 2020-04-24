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

public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);

    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {

        in.close();
    }


    @Test
    public void testFirstLevelCache(){

        SqlSession sqlSession1 = factory.openSession();
        UserDao dao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = dao1.findById(1);
        System.out.println(user1);
        sqlSession1.close();  //一级缓存消失

        //sqlsession必须commit() 或者 close()才会保存到二级缓存中
        //在二级缓存中存的不是当前User1对象,而是数据,吧user1的数据给放到二级缓存中,
        // 当下面发起请求时,已经不会从数据库再去查询了,这时候会从二级缓存中把数据取出来,然后再新建一个对象,赋值给user2

        SqlSession sqlSession2 = factory.openSession();
        UserDao dao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = dao2.findById(1);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1==user2);
        }





}
