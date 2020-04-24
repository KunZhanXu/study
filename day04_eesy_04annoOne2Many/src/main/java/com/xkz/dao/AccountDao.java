package com.xkz.dao;

import com.xkz.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户,并且获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id=true, column = "id",property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user",column = "uid", one = @One(select="com.xkz.dao.UserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();


    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid=#{userId}")
    List<Account> findAccountByUid(Integer userId);
}
