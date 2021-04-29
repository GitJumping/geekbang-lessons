package org.geektimes.projects.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {

    // 后台-登录界面
    @GetMapping("/admin/login_backend")
    public String adminLogin() {
        return "login_backend";
    }

    // 后台-首页
    @GetMapping("/admin")
    public String adminIndex() {
        return "admin";
    }
}
