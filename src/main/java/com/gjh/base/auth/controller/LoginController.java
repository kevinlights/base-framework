package com.gjh.base.auth.controller;

import com.gjh.base.auth.model.AuthConstant;
import com.gjh.base.auth.model.SysUser;
import com.gjh.base.model.ApiResult;
import com.gjh.base.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 23:16
 */
@Api(tags = "Auth - Login API")
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ApiResult login(@RequestParam("username") String username, @RequestParam("password") String password,
                           HttpServletRequest request) {
        SysUser user = userService.getUserByName(username);
        if (null == user) {
            return ApiResult.error(500, "user not exists");
        }
        if (!user.getPassword().equals(passwordEncoder.encode(password))) {
            return ApiResult.error(500, "password invalid");
        }
        HttpSession session = request.getSession(true);
        session.setAttribute(AuthConstant.CURRENT_USER, user);
        return ApiResult.ok("login successfully");
    }

    @GetMapping("/loginError")
    public ApiResult loginError() {
        return ApiResult.error(500, "login error");
    }

    @GetMapping("/logout")
    public ApiResult logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute(AuthConstant.CURRENT_USER);
        }
        return ApiResult.ok("logout successfully");
    }
}
