package com.lu.controller;

import com.alibaba.fastjson.JSON;
import com.lu.dao.GdzjRepository;
import com.lu.domain.Gdzj;
import com.lu.domain.Result;
import com.lu.manager.HtzlManager;
import com.lu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/rest/gdzj/")
public class GdzjController {

    @Autowired
    private GdzjRepository gdzjRepository;
    @Autowired
    private HtzlManager htzlManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(HttpServletRequest httpServletRequest) {
        int htId = Utils.getIntParam(httpServletRequest, "htId", 0);
        Result<List<Gdzj>> result = new Result<>();
        result.setSuccess(true);
        result.setData(gdzjRepository.getListByHtId(htId));
        return JSON.toJSONString(result);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest httpServletRequest) {

        int htId = Utils.getIntParam(httpServletRequest, "htId", 0);
        String json = httpServletRequest.getParameter("json");

        Gdzj gdzj = JSON.parseObject(json, Gdzj.class);
        Result<List<Gdzj>> result = new Result<>();
        result.setSuccess(htzlManager.add(htId, gdzj));

        return JSON.toJSONString(result);
    }

}
