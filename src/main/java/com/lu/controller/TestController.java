package com.lu.controller;

import com.lu.dao.GdsjRepository;
import com.lu.dao.GdzjRepository;
import com.lu.dao.HtzlRepository;
import com.lu.domain.Gdsj;
import com.lu.domain.Htzl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/open/")
public class TestController {

    @Autowired
    private HtzlRepository htzlRepository;
    @Autowired
    private GdsjRepository gdsjRepository;
    @Autowired
    private GdzjRepository gdzjRepository;

    @RequestMapping("/test")
    public void test() {

        Htzl htzl = new Htzl();

        htzl.setBmmll(1);
        htzl.setKh("1");
        htzl.setKfddh("1");

        htzl = htzlRepository.save(htzl);

        Gdsj gdsj = new Gdsj();
        gdsj.setHtId(1);
        gdsj.setCyqk("111111");

        gdsjRepository.save(gdsj);

    }


}
