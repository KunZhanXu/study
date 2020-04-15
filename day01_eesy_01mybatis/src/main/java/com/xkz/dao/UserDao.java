package com.xkz.dao;

import com.xkz.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();
}
