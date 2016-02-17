package com.lu;

import com.lu.manager.HtzlManager;
import com.lu.utils.SpzlPoiHelper;
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
public class SpzlImportTest {

    @Test
    public void testImportXls() throws Throwable {

        FileInputStream file = new FileInputStream(new File("/Users/wuzhong/AliDrive/6.work/hzqg/test2.xlsx"));

        new SpzlPoiHelper().convert(file);


    }

}
