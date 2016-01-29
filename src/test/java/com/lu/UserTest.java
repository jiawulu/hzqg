package com.lu;

import com.lu.domain.User;
import com.lu.manager.HtzlManager;
import com.lu.manager.UserManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootApplication.class)
@WebAppConfiguration
public class UserTest {

    @Autowired
    private UserManager userManager;

    @Test
    public void testCreateUser() throws Throwable {

        User user = userManager.register("admin","admin");


        userManager.assign(user, "test","test");


    }

}
