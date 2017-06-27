package cn.pompeybrain.business.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 认证切面类
 * Created by Administrator on 2017/5/12 0012.
 */
@Aspect
//@Component
public class Authentication {

    @Pointcut("execution(* cn.pompeybrain.business.*.*Controller.*(..))")
    public void authenticate() {
    }

    @Before("authenticate()")
    public void deBefore(JoinPoint joinPoint) {
//        System.out.println("aop1");
    }
}
