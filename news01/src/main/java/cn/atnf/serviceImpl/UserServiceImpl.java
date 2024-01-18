package cn.atnf.serviceImpl;

import cn.atnf.dao.UserDao;
import cn.atnf.daoImpl.UserDaoImpl;
import cn.atnf.entity.User;
import cn.atnf.service.UserService;

public class UserServiceImpl implements UserService{
    private UserDao ud = new UserDaoImpl();

    @Override
    public int register(User user) {
        if(ud.findOne(user.getUid())){
            return -1;
        }
        return ud.insertOne(user);
    }
/*	public int register(User user) {

		return ud.insertOne(user);
	}*/

    @Override
    public User login(String uid, String pwd) {

        return ud.findOne(uid, pwd);
    }

}


