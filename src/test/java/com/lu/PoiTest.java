package com.lu;

import com.alibaba.fastjson.JSON;
import com.lu.domain.Htzl;
import com.lu.utils.HtzlPoiHelper;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzhong on 16/1/29.
 */
public class PoiTest {

    @Test
    public void test() {

        try {

            List<Htzl> list = new ArrayList<>();

            FileInputStream file = new FileInputStream(new File("/Users/wuzhong/AliDrive/6.work/hzqg/test.xls"));

            list.addAll(new HtzlPoiHelper().convert(file));

            System.out.println(JSON.toJSONString(list));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
