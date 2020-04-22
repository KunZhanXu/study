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
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件:有可能有用户名,有可能有性别,也有可能有地址,还有可能是都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合,查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
