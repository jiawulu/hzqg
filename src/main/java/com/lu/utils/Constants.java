package com.lu.utils;

/**
 * Created by wuzhong on 16/1/22.
 */
public interface Constants {

    String SID = "sid";
    String ROLE = "role";

    /**
     * 1. admin
     * 2. 部门经理 （不可以导入，查看所有业务员，可以注册用户，只读）
     * 3. 业务员 （不可以导入， 合同资料操作）
     * 4. 工厂联络员 （导入， 出运打钩， 索赔）
     */
    int ROLE_ADMIN = 0;
    int ROLE_MANAGER = 1;
    int ROLE_YWY = 2;
    int ROLE_GCLLY = 3;

    String NAME = "name";
}
