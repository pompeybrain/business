package cn.pompeybrain.business.aop;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录过滤器
 * Created by Administrator on 2017/5/12 0012.
 */
@WebFilter(filterName = "authenticateFilter", urlPatterns = "/*")
@Component
public class AuthenticateFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // 不新建session
        String requestUrl = request.getRequestURI();
        if (request.getRequestURI().matches("(.*)/logout$")) {
            session.invalidate();
            System.out.println("logout!");
        } else if (!requestUrl.matches("(.*)/login$") && (session == null || session.getAttribute("user") == null)) {
            PrintWriter out = response.getWriter();
            out.println("not-login");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
