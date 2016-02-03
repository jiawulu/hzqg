package com.lu.controller;

import com.alibaba.fastjson.JSON;
import com.lu.dao.HtzlRepository;
import com.lu.domain.Htzl;
import com.lu.domain.PageValue;
import com.lu.domain.Result;
import com.lu.domain.User;
import com.lu.manager.HtzlManager;
import com.lu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest/htzl/")
public class HtzlController {

    @Autowired
    private HtzlRepository htzlRepository;

    @Autowired
    private HtzlManager htzlManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String list(HttpServletRequest httpServletRequest) {

        final User user = Utils.getUser(httpServletRequest);

        int pageNo = Utils.getIntParam(httpServletRequest, "pageNo", 0);
        int pageSize = Utils.getIntParam(httpServletRequest, "pageSize", 20);
        int cgjqWarnType = Utils.getIntParam(httpServletRequest, "cgjqWarnType", 0);
        long startJq = Utils.getLongParam(httpServletRequest, "startJq", 0L);
        long endJq = Utils.getLongParam(httpServletRequest, "endJq", 0L);
        int zjcs = Utils.getIntParam(httpServletRequest, "zjcs", 0);
        int cycs = Utils.getIntParam(httpServletRequest, "cycs", 0);

        PageRequest pageRequest = new PageRequest(pageNo, pageSize);

        Page<Htzl> page = htzlManager.search(pageRequest, user, cgjqWarnType, startJq, endJq, zjcs, cycs);

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
    String handleFileUpload(@RequestParam("file") MultipartFile file) {

//        if (!file.isEmpty()) {
//            try {
//
//                byte[] bytes = file.getBytes();
//
//                new ByteArrayInputStream(bytes)
//
//                BufferedOutputStream stream =
//                        new BufferedOutputStream(new FileOutputStream(new File(name)));
//                stream.write(bytes);
//                stream.close();
//                return "You successfully uploaded " + name + "!";
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + name + " because the file was empty.";
//        }
        return null;
    }

}
