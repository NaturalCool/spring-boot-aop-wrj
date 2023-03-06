package com.bluetea.aop.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 自定义统一异常处理器
 * 注意： 如果用 @Aspect 模式时，方法中的异常将无法在此捕获
 * 会直接在 around 方法中抛出
 * 而自定义拦截器模式则不会
 * 并且自定义拦截器模式优先级高于 @Aspect
 *
 * @author: NaturalCool
 * @date: 2023/3/6
 */
@ControllerAdvice
@ResponseBody
public class ErrorAdvice {

    @ExceptionHandler(Exception.class)
    public HashMap<String, Object> exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>(2);
        result.put("code", "-1");
        result.put("msg", e.getMessage());
        return result;
    }

    @ExceptionHandler(ArithmeticException.class)
    public HashMap<String, Object> arithmeticAdvice(ArithmeticException e) {
        HashMap<String, Object> result = new HashMap<>(2);
        result.put("code", "-2");
        result.put("msg", e.getMessage());
        return result;
    }

    @ExceptionHandler(NullPointerException.class)
    public HashMap<String, Object> arithmeticAdvice(NullPointerException e) {
        HashMap<String, Object> result = new HashMap<>(2);
        result.put("code", "-3");
        result.put("msg", e.getMessage());
        return result;
    }
}
