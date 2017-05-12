package cn.pompeybrain.business.session;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 * Created by Administrator on 2017/5/12 0012.
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
@Component
public class LoginFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.getRequestURI());
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null && request.getRequestURI().matches("login")) {
            System.out.println("未登录");
            response.sendError(0, "not login");

        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
    }
}
