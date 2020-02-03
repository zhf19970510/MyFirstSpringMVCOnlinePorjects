package com.zhf.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2020/1/14 0014.
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");

        ModelAndView mv = new ModelAndView();
        //封装数据
        //request session application
        mv.addObject("msg", "hello springMVC ! ! !"+name);

        //跳转页面
        //request.getRequestDispatcher("url").forward(request, response);
        //response.sendRedirect("url");
        //设置逻辑视图名
        mv.setViewName("first");

        return mv;
    }
}
