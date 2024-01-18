package cn.atnf.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.atnf.dao.UserDao;
import cn.atnf.entity.User;
import cn.atnf.util.DBUtil;

/**
 * @author Augus
 */
public class UserDaoImpl implements UserDao{

    @Override
    public int insertOne(User user) {

        String sql = "insert into t_user values (?,?,?,?,?,?)";

        Object[] objs = {user.getUid(), user.getUname(), user.getUpassword(), user.getUsex(), user.getUemail(), user.getUregdate()};
        int n = DBUtil.excuteDML(sql, objs);

        return n;
    }

    @Override
    public User findOne(String uid, String pwd) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_user where uid=? and upassword=?";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        User user = null;
        try {
            ps.setString(1, uid);
            ps.setString(2, pwd);

            rs = ps.executeQuery();
            if(rs.next()) {
                user = new User(rs.getString("uid"), rs.getString("uname"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uemail"), rs.getDate("uregdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeAll(rs, ps, conn);
        }

        return user;
    }

    @Override
    public boolean findOne(String uid) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_user where uid=?";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        try {
            ps.setString(1, uid);

            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeAll(rs, ps, conn);
        }

        return false;
    }

}


