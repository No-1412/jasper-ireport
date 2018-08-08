package com.kingdom.service;

import com.kingdom.dao.UserDao;
import com.kingdom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author No.1412
 * @version 2018/6/30
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 创建用户
     * @param user
     */
    public void generateUser(User user) {
        userDao.insert(user);
    }

    /**
     * 根据id更新用户
     * @param user
     */
    public void updateUser(User user) {
        userDao.updateByPrimaryKey(user);
    }

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    public User getById(Integer id) {
        return userDao.get(id);
    }

    /**
     * 查詢用戶
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        User user = userDao.getByName(username);
        return user;
    }

//    public UserService() throws IOException {
//    }

//    public Integer generateUser(User user) {
//        SqlSession session = this.openSession();
//        userDao = session.getMapper(UserDao.class);
//        int i = userDao.insert(user);
//        session.commit();
//        session.close();
//        return i;
//    }
//
//    public User findByUsername(String username) {
//        SqlSession session = this.openSession();
//        userDao = session.getMapper(UserDao.class);
//        User user = userDao.getByName(username);
//        session.close();
//        return user;
//    }


}
