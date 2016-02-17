package com.lu.controller;

import com.lu.domain.Result;
import com.lu.domain.User;
import com.lu.manager.UserManager;
import com.lu.utils.Constants;
import com.lu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/rest/open/")
public class UserController {

    @Autowired
    private UserManager userManager;

    @RequestMapping("/login")
    public Result login(HttpServletResponse response, @RequestParam(value = "userName") String userName,
                        @RequestParam(value = "passWord") String passWord) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
            return Result.ERROR_PARAM;
        }

        User user = userManager.login(userName, passWord);

        Result result = new Result();
        if (null == user) {
            result.setCode(Result.ERROR_CODE_LOGIN_FAILED);
            result.setMsg("登录失败,请确认用户名和密码");
            return result;
        }


        Cookie cookie = new Cookie(Constants.SID, user.getSid());
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie(Constants.ROLE, String.valueOf(user.getRole()));
        cookie2.setMaxAge(-1);
        cookie2.setPath("/");
        response.addCookie(cookie2);

        Cookie cookie3 = new Cookie(Constants.NAME, user.getUserName());
        cookie3.setMaxAge(-1);
        cookie3.setPath("/");
        response.addCookie(cookie3);

        result.setSuccess(true);
        return result;
    }


    @RequestMapping("/register")
    public Result register(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "passWord") String passWord, @RequestParam(value = "role") int role, HttpServletRequest request) {


        User user = Utils.getUser(request);
        if (null == user || Constants.ROLE_ADMIN != user.getRole()) {
            return Result.NO_PERMISSION;
        }

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord) || role <= 0) {
            return Result.ERROR_PARAM;
        }

        try {
            Result result = new Result();
            User user2 = userManager.assign(user, userName, passWord, role);
            result.setSuccess(null != user2);
            return result;
        } catch (Throwable e) {
            return Result.EXCEPTION;
        }

    }


}
