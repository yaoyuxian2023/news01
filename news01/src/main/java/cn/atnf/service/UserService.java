package cn.atnf.service;

import cn.atnf.entity.User;

/**
 * @author Augus
 */
public interface UserService {

    int register(User user);

    User login(String uid, String pwd);

}


