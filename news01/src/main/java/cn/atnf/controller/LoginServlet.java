package cn.atnf.controller;

import java.io.IOException;

import cn.atnf.entity.User;
import cn.atnf.service.UserService;
import cn.atnf.serviceImpl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Augus
 * 登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前台数据
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String remenber = request.getParameter("remenber");
        String name;
        if((!(name=check(id,password)).equals(""))){  //登录成功，跳转到成功页
            Cookie cookie;
            System.out.println("remenber=" + remenber);// on, null
            if(remenber != null) {
                cookie = new Cookie("Cookie2020", id+"#"+password+"#"+remenber);
                cookie.setMaxAge(45);
                response.addCookie(cookie);
            } else {
                cookie = new Cookie("Cookie2020", id+"#"+password+"#"+remenber);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

            request.getSession().setAttribute("username", name);
            request.getSession().setMaxInactiveInterval(30);// 30秒
            response.sendRedirect("queryAllNews");

        }else{              //登录失败，跳转到失败页
            response.sendRedirect("login_failure.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String check(String userid, String userpwd){

        String uname = "";

        UserService us = new UserServiceImpl();
        User user = us.login(userid, userpwd);

        if(user != null){  //登录成功
            uname = user.getUname();
        }

        return uname;
    }

}


