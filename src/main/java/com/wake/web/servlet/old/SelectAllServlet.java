package com.wake.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.wake.pojo.Brand;
import com.wake.service.BrandService;
import com.wake.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询
        List<Brand> brands = brandService.selectAll();
        //2.转为JSON
        String jsonString = JSON.toJSONString(brands);
        //3.写数据,告诉浏览器响应的数据是什么，使用什么字符集解码
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(jsonString);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}