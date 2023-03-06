package com.bluetea.aop.interceptor;

import com.bluetea.aop.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 自定义登录拦截器
 * Q: 当前端发送 ajax 请求，触发拦截器的 response.sendRedirect("xxx") 没有调整， 为什么？
 * A: ajax 是局部刷新技术，不能实现整体页面的跳转。
 *
 * @author: NaturalCool
 * @date: 2023/3/6
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 判断登录业务
        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session) && !StringUtils.isEmpty(session.getAttribute("userinfo"))) {
            return true;
        }
        log.error("当前用户没有访问权限！");
        response.setStatus(401);
        //  response.sendRedirect("/login.html");
        return false;
    }
}
