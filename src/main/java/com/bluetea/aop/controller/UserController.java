package com.bluetea.aop.controller;

import com.bluetea.aop.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * userController
 *
 * @author: NaturalCool
 * @date: 2023/3/6
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/hello")
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.ok("Hello!");
    }

    /**
     * method1
     *
     * @param request HttpServletRequest
     * @return result
     */
    @GetMapping("/method1")
    public ResponseEntity<?> method1(HttpServletRequest request) {
        // 有 session 就获取，没有不会获取
        HttpSession session = request.getSession();
        if (Objects.nonNull(session) && !StringUtils.isEmpty(session.getAttribute("userinfo"))) {
            // 已登录，业务处理
            return ResponseEntity.ok("1已经登录！");
        }
        // 未登录
        return ResponseEntity.ok("1请先登录1");
    }

    /**
     * method2
     *
     * @param request HttpServletRequest
     * @return result
     */
    @GetMapping("/method2")
    public ResponseEntity<?> method2(HttpServletRequest request) {
        // 有 session 就获取，没有不会获取
        HttpSession session = request.getSession();
        if (Objects.nonNull(session) && !StringUtils.isEmpty(session.getAttribute("userinfo"))) {
            // 已登录，业务处理
            return ResponseEntity.ok("2已经登录！");
        }
        // 未登录
        return ResponseEntity.ok("2请先登录");
    }
    // 基于 service 中的 aspect 无法满足要求时 看下面

    @GetMapping("/login")
    public boolean login(HttpServletRequest request, String username, String password) {
        HttpSession session = request.getSession();
        if (StringUtils.isEmptys(username, password)) {
            if ("admin".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)) {
                // 登录成功
                session.setAttribute("userinfo", "admin");
                log.info("success");
                return true;
            } else {
                // 用户名或密码错误
                session.setAttribute("error", "登录失败，用户名或密码错误！~");
                log.error("用户名或密码错误");
                return false;
            }
        }
        session.setAttribute("error", "用户名或密码不能为空！");
        log.error("用户名或密码不能为空");
        return false;

    }

    @GetMapping("/getInfo")
    public ResponseEntity<?> getInfo() {
        log.debug("执行了 getInfo 方法");
        return ResponseEntity.ok("执行了 getInfo 方法");
    }

    @GetMapping("/reg")
    public ResponseEntity<?> reg() {
        log.debug("执行了 reg 方法");
        return ResponseEntity.ok("执行了 reg 方法");
    }

    @GetMapping("/index")
    public ResponseEntity<?> index() {
        Object obj = null;
        int i = Objects.requireNonNull(obj, "this obj must can not be null!").hashCode();
        return ResponseEntity.ok("Hello,User Index");
    }
}
