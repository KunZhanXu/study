package com.xkz.dao;

import com.xkz.domain.QueryVo;
import com.xkz.domain.User;

import java.util.List;

/**
 * 持久层接口
 */
public interface UserDao {

    /*查询所有*/
    List<User> findAll();
    /*
    * 保存方法
    * */
    void saveUser(User user);
    /**
     * 更新用户
     */
    void updateUser(User user);
    /*
    * 根据id删除用户
    * */
    void deleteUser(Integer userId);
    /*
    * 根据id查询用户信息
    * */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
