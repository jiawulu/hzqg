package com.lu.controller;

import com.alibaba.fastjson.JSON;
import com.lu.dao.SpzlRepository;
import com.lu.domain.Result;
import com.lu.domain.Spzl;
import com.lu.domain.User;
import com.lu.utils.Constants;
import com.lu.utils.SpzlPoiHelper;
import com.lu.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/rest/spzl/")
public class SpzlController {

    private static Logger logger = LoggerFactory.getLogger(SpzlController.class);

    @Autowired
    private SpzlRepository spzlRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(@RequestParam("huhao") String huohao) {

        Result<List<Spzl>> result = new Result<>();
        List<Spzl> list = spzlRepository.getListByHuohao(huohao);
        result.setSuccess(true);
        result.setData(list);
        return JSON.toJSONString(result);

    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        User user = Utils.getUser(request);

        if (null == user || !(Constants.ROLE_ADMIN == user.getRole() || Constants.ROLE_GCLLY == user.getRole())) {
            return "没有权限";
        }

        if (!file.isEmpty()) {
            try {

                byte[] bytes = file.getBytes();

                List<Spzl> list = new SpzlPoiHelper().convert(new ByteArrayInputStream(bytes));

                if (list.size() > 0) {

                    spzlRepository.save(list);

                    return "上传成功";
                }

            } catch (Exception e) {
            }
        } else {
        }
        return "上传失败";
    }


}
