package com.kingdom.dao;

import com.kingdom.model.User;

import java.util.List;

/**
 * @author No.1412
 * @version 2018/6/30
 */
@DaoType
public interface UserDao {

    List<User> findList();

    User get(int id);

    int insert(User record);

    int insertSelective(User record);

    User getByName(String loginName);

    void updateByPrimaryKey(User user);
}
