package com.pj.controller;

import com.pj.Service.LoginService;
import com.pj.pojo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/test")
    public String test(String username, String password){
        UserData userData = loginService.findUserNameAndPassword(username, password);

        return userData.toString();
    }
}
