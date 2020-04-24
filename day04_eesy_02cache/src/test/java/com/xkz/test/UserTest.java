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
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        //sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.findById(1);
        System.out.println(user1);

        /*sqlSession.close();*/

        //再次获取sqlsession对象
        /*sqlSession = factory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);*/
        sqlSession.clearCache();  //此方法也可以清空缓存

        User user2 = userDao.findById(1);
        System.out.println(user2);

        System.out.println(user1==user2);
        //com.xkz.domain.User@4d3167f4
        //com.xkz.domain.User@4d3167f4
        //true   执行结果如上所述,两次查询出来的结果是一样的,说明第二次查询,也就是user2是从缓存中拿出来

        //com.xkz.domain.User@4d3167f4
        //com.xkz.domain.User@6121c9d6
        //false  当关闭之后再次获取sqlSession之后,两次查询的结果就不一样的,也进行了两次查询,说明第二次再次查询了一次,不是从缓存中拿出来的
    }


    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearCache(){
        //1.根据id查询用户
        User user1 = userDao.findById(7);
        System.out.println(user1);
        //2.更新用户信息
        user1.setUsername("update user clear cache1");
        user1.setAddress("北京市海淀区");
        userDao.updateUser(user1);

        //3.再次查询id为7的用户
        User user2 = userDao.findById(7);
        System.out.println(user2);

        System.out.println(user1==user2);
        }


}
