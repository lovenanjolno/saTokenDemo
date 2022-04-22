package com.pj.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//@EnableWebMvc
public class MainController {

    @GetMapping("/index")
    public String index(){
        System.out.println("当前登录状态: "+StpUtil.isLogin());
        if(!StpUtil.isLogin())
        {
            return "redirect:/login";
        }
        else{
            return "index";
        }


    }

    @GetMapping("/")
    public String defaultIndex(){
        if(StpUtil.isLogin()){
            return "redirect:/index";
        }
        return "redirect:/login";
    }





}