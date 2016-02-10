package com.lu.controller;

import com.alibaba.fastjson.JSON;
import com.lu.dao.CyjyRepository;
import com.lu.domain.Cyjy;
import com.lu.domain.Result;
import com.lu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/rest/cyjy/")
public class CyjcController {

    @Autowired
    private CyjyRepository cyjyRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(HttpServletRequest httpServletRequest) {
        int htId = Utils.getIntParam(httpServletRequest, "htId", 0);
        Result<List<Cyjy>> result = new Result<>();
        result.setSuccess(true);
        result.setData(cyjyRepository.getListByHtId(htId));
        return JSON.toJSONString(result);

    }


}
