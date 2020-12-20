package com.gjh.base.auth.controller;

import com.gjh.base.auth.model.AuthConstant;
import com.gjh.base.auth.model.SysUser;
import com.gjh.base.model.ApiResult;
import com.gjh.base.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 23:21
 */
@Api(tags = "Auth - User API")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PreAuthorize("hasAuthority('UserIndex')")
    @GetMapping("/index")
    public ApiResult index() {
        return ApiResult.ok("index");
    }

    @RequestMapping("/currentUser")
    public ApiResult currentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return ApiResult.error(500, "not login");
        }
        Object currentUser = session.getAttribute(AuthConstant.CURRENT_USER);
        if (currentUser == null) {
            return ApiResult.error(500, "not login");
        }
        if (currentUser instanceof SysUser) {
            SysUser sysUser = (SysUser) currentUser;
            return ApiResult.ok(sysUser);
        }
        return ApiResult.error(500, "invalid user");
    }
}
