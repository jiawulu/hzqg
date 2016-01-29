package com.lu;

import com.lu.dao.HtzlRepository;
import com.lu.domain.Htzl;
import com.lu.domain.User;
import com.lu.manager.HtzlManager;
import com.lu.manager.UserManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootApplication.class)
@WebAppConfiguration
public class HtzlSearchTest {

    @Autowired
    private HtzlManager htzlManager;
    @Autowired
    private UserManager userManager;
    @Autowired
    private HtzlRepository htzlRepository;

    @Test
    public void test() throws Throwable {

        User admin = userManager.login("admin","admin");

        Page<Htzl> result = htzlManager.search(new PageRequest(0,5),admin,10,0,0,0,0);

        System.out.println(result.getTotalElements());

        Htzl htzl = result.getContent().get(0);
        int zjcs = new Random(100).nextInt();
        htzl.setZjcs(zjcs);

        Htzl htzl1 = htzlRepository.save(htzl);

//        Assert.assertTrue(htzl == htzl1);
        Assert.assertTrue(htzl1.getZjcs() == zjcs);
    }

}
