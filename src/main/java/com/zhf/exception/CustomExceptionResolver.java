package com.zhf.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZengHongFa
 * @create 2020/2/2 0002 11:20
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    //前端控制器，如果遇到异常，会自动调用的方法
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) {
        String message = null;
        ex.printStackTrace();

        //统一异常处理
        CustomException customException = null;
        if(ex instanceof CustomException){
            customException = (CustomException) ex;
        }else {
            customException = new CustomException("未知异常");
        }
        //错误信息得到
        message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
