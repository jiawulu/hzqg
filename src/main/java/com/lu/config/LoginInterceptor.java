package com.lu.config;

import com.alibaba.fastjson.JSON;
import com.lu.domain.Result;
import com.lu.domain.User;
import com.lu.manager.UserManager;
import com.lu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String sid = Utils.getSid(request);
        if (!StringUtils.isEmpty(sid)) {
            User user = userManager.getUserBySid(sid);
            if (null != user) {
                request.setAttribute("user", user);
            }
        }

        if (request.getRequestURI().startsWith("/rest/open/") || null != request.getAttribute("user")) {
            return true;
        }

        Result result = new Result();
        result.setCode(-1);
        result.setMsg("need login");
        response.getWriter().write(JSON.toJSONString(result));
        return false;

//        response.getWriter().write("FIXME");
//        return false;
    }

}