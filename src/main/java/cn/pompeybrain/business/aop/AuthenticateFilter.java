package cn.pompeybrain.business.aop;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 登录过滤器
 * Created by Administrator on 2017/5/12 0012.
 */
@WebFilter(filterName = "authenticateFilter", urlPatterns = "/*")
@Component
public class AuthenticateFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // 不新建session
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();
        if (requestUrl.matches("(.*)/login$") || method.equals("OPTIONS") || requestUrl.matches("(.*)/util/")) {
            filterChain.doFilter(request, response);
        } else if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/util/notLogin");
        } else {
            int roleId = Integer.valueOf((String) session.getAttribute("role"));
            if (roleId == 1) {
                filterChain.doFilter(request, response);
            } else if (requestUrl.matches("(.*)/user")) {
                response.sendRedirect("/util/authorityError");
            }
        }
    }
}
