package cn.atnf.controller;

import java.io.IOException;

import cn.atnf.entity.User;
import cn.atnf.service.UserService;
import cn.atnf.serviceImpl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Augus
 * 注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取前台数据
        String id = req.getParameter("uid");
        String name = req.getParameter("uname");
        String password = req.getParameter("upassword");
        String password2 = req.getParameter("upassword2");
        String sex = req.getParameter("usex");
        String email = req.getParameter("uemail");
        java.util.Date regdate = new java.util.Date();

        String uname = check(id,name,password,password2,sex,email,regdate);

        if(!( "".equals(uname) || "######".equals(uname)
                || "******".equals(uname)|| "$$$$$$".equals(uname))){  //注册成功，跳转到成功页
            req.getSession().setAttribute("info", uname);
            resp.sendRedirect("reg_success.jsp");

        }else{              //注册失败，跳转到失败页
            String info = "";
            if("######".equals(uname)){
                info = "错误：登录ID已经存在！";
            }
            if("******".equals(uname)){
                info = "错误：两次输入密码不一致！";
            }
            if("$$$$$$".equals(uname)){
                info = "错误：所有信息都必须填写！";
            }
            req.getSession().setAttribute("info", info);
            resp.sendRedirect("reg_failure.jsp");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }

    private String check(String userid, String username,
                         String userpwd, String userpwd2,
                         String usersex, String useremail,
                         java.util.Date userregdate){

        if("".equals(userid) || "".equals(username) || "".equals(userpwd) || "".equals(userpwd2)){
            return "$$$$$$";
        }

        if(!(userpwd.equals(userpwd2))){
            return "******";
        }

        User user = new User(userid,username,userpwd,usersex,useremail,userregdate);

        UserService us = new UserServiceImpl();

        int n = us.register(user);

        if (n == -1) {
            return "######";
        }

        return username;
    }

}

