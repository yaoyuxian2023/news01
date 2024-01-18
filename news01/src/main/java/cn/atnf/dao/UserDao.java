package cn.atnf.dao;

import cn.atnf.entity.User;

/**
 * @author Augus
 */
public interface UserDao {

    int insertOne(User user);

    User findOne(String uid, String pwd);

    boolean findOne(String uid);

}
