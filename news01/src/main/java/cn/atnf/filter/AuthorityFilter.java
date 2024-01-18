//package cn.atnf.filter;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.annotation.WebFilter;
//
//import java.io.IOException;
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// * @author Augus
// */
////@WebFilter("/*") // 指定过滤器应用于所有请求
//public class AuthorityFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // 初始化过滤器时执行的操作，例如读取配置文件
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        // 在此处执行过滤操作，例如权限验证、日志记录等
//        // 获取当前用户的ID
//        String uid = (String) request.getSession().getAttribute("uid");
//
//        // 检查用户是否具有删除新闻的权限
//        if (uid != null && hasPermissionToDeleteNews(userId)) {
//            // 如果具有权限，继续执行后续的Servlet
//            chain.doFilter(request, response);
//        } else {
//            // 如果没有权限，返回错误信息或重定向到登录页面
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "您没有权限删除新闻");
//        }
//
//        // 如果过滤通过，继续执行后续的Servlet
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // 销毁过滤器时执行的操作，例如释放资源
//    }
//}
//
