package com.lu.controller;

import com.alibaba.fastjson.JSON;
import com.lu.domain.Htzl;
import com.lu.domain.PageValue;
import com.lu.domain.Result;
import com.lu.domain.User;
import com.lu.dto.HtzlDto;
import com.lu.dto.HtzlQueryDto;
import com.lu.manager.HtzlManager;
import com.lu.utils.Constants;
import com.lu.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/rest/htzl/")
public class HtzlController {

    private static Logger logger = LoggerFactory.getLogger(HtzlController.class);

    @Autowired
    private HtzlManager htzlManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(HttpServletRequest httpServletRequest, @RequestParam("json") String json) {

        final User user = Utils.getUser(httpServletRequest);

        HtzlQueryDto queryDto = JSON.parseObject(json, HtzlQueryDto.class);

        PageRequest pageRequest = new PageRequest(queryDto.getPageNo(), (0 == queryDto.getPageSize()) ? 20 : queryDto.getPageSize());

        Page<Htzl> page = htzlManager.search(pageRequest, user, queryDto);

        Result<PageValue<Htzl>> result = new Result<>();

        result.setSuccess(true);

        PageValue<Htzl> pageValue = new PageValue<>();
        pageValue.setPageNo(page.getNumber());
        pageValue.setTotalSize(page.getTotalElements());
        pageValue.setTotalPage(page.getTotalPages());
        pageValue.setPageSize(page.getSize());
        pageValue.setValues(page.getContent());

        result.setData(pageValue);
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

                boolean success = htzlManager.importXls(new ByteArrayInputStream(bytes));

                if (success) {
                    return "上传成功,请刷新当前页面";
                } else {
                    return "上传失败";
                }

            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
//            return "You failed to upload " + name + " because the file was empty.";
        }
        return "上传失败";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String update(@RequestParam("json") String json) {

        Result result = new Result<>();

        try {

            HtzlDto htzlDto = JSON.parseObject(json, HtzlDto.class);
            result.setSuccess(htzlManager.save(htzlDto));

        } catch (Throwable e) {
            logger.error("save exception", e);
        }

        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/uploadCyqk", method = RequestMethod.POST)
    public Result updateCyqk(@RequestParam("htId") int htid, @RequestParam("cyqk") boolean cyqk, HttpServletRequest request) {

        User user = Utils.getUser(request);

        if (null == user || !(Constants.ROLE_ADMIN == user.getRole() || Constants.ROLE_GCLLY == user.getRole())) {
            return Result.NO_PERMISSION;
        }

        Result result = new Result();
        result.setSuccess(htzlManager.updateByCyqk(htid, cyqk));
        return result;
    }

}
