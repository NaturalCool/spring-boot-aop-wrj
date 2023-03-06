package com.bluetea.aop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * UserAspect  统一登录切面
 * 缺点 1.没办法获取到 HttpSession 对象
 * 2.当需要只对部分方法拦截，而部分方法放开时，排除方法的规则很难或无法定义
 *
 * @author: NaturalCool
 * @date: 2023/3/6
 */
@Aspect
@Component
public class UserAspect {


    /**
     * 定义切点方法 controller 包下，子孙包下所有类的所有方法
     */
    @Pointcut("execution(* com.bluetea.aop.controller..*.*(..))")
    public void pointCut() {
    }

    /**
     * 前置方法
     */
    @Before("pointCut()")
    public void doBefore() {
    }

    /**
     * 环绕方法
     *
     * @param joinPoint ProceedingJoinPoint
     * @return obj
     */
    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        System.out.println("Around 方法开始执行！");

        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Around 方法执行结束！");
        return obj;
    }

}
