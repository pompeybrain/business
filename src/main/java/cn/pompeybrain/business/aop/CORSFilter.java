package cn.pompeybrain.business.aop;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 跨域过滤器
 * Created by Administrator on 2017/5/19 0019.
 */
@WebFilter
@Component
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));

        httpServletResponse
                .setHeader(
                        "Access-Control-Allow-Headers",
                        "User-Agent,Origin,Cache-Control,Content-type,Date,Server,withCredentials,AccessToken");


        httpServletResponse.setHeader("Access-Control-Allow-Credentials",
                "true");

        httpServletResponse.setHeader("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");


        httpServletResponse.setHeader("Access-Control-Max-Age", "1209600");


        httpServletResponse.setHeader("Access-Control-Expose-Headers",
                "accesstoken");


        httpServletResponse.setHeader("Access-Control-Request-Headers",
                "accesstoken");


        httpServletResponse.setHeader("Expires", "-1");


        httpServletResponse.setHeader("Cache-Control", "no-cache");


        httpServletResponse.setHeader("pragma", "no-cache");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
