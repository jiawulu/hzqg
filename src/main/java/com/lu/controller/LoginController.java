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
public class LoginController {

    @Autowired
    private UserManager userManager;

    //    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/register")
    public Result register(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "passWord") String passWord, HttpServletRequest request) {

        Result result = new Result();

        User user = Utils.getUser(request);
        if(null == user || Constants.ROLE_ADMIN != user.getRole()){
            result.setMsg("没有权限");
            return result;
        }

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
            return result;
        }

        User user2 = userManager.register(userName, passWord);
        result.setSuccess(null != user);

        return result;

    }

    @RequestMapping("/login")
    public Result login(HttpServletResponse response, @RequestParam(value = "userName") String userName,
                        @RequestParam(value = "passWord") String passWord) {


        Result result = new Result();

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
            return result;
        }

        User user = userManager.login(userName, passWord);

        if (null == user) {
            return result;
        }

        Cookie cookie = new Cookie(Constants.SID, user.getSid());
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);
        result.setSuccess(true);
        return result;
    }
}
