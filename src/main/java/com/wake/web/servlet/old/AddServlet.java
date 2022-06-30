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
import java.io.BufferedReader;
import java.io.IOException;


//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    public BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 页面提交的数据是json格式用输入流读取数据
         * 将接收到的数据转为Brand对象
         * 调用service的add()添加
         * 响应添加成功的标识
         */
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //调用service
        brandService.add(brand);
        //响应成功标识
        response.getWriter().write("success");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}