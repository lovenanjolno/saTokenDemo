package com.pj.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.pj.Service.LoginService;
import com.pj.pojo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    // 测试登录  ---- http://localhost:8081/acc/doLogin?name=zhang&pwd=123456
    LoginService loginService;

    /**
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public String login(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        System.out.println(username);
        System.out.println(password);
        UserData user = new UserData();

        user = loginService.findUserNameAndPassword(username, password);


        if((user != null)) {

            StpUtil.login(10001);
            return "redirect:index";
        }
        //return SaResult.error("登录失败");
        return "login";

    }

    @GetMapping("/logout")
    public String Logout(){
        if(StpUtil.isLogin()) {
            StpUtil.logout(StpUtil.getLoginId());
        }
        System.out.println(StpUtil.isLogin());
        return "redirect:/login";
    }
}
