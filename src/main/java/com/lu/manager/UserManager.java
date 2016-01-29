package com.lu.manager;

import com.lu.dao.UserRepository;
import com.lu.domain.User;
import com.lu.utils.Constants;
import com.lu.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wuzhong on 16/1/22.
 */
@Component
public class UserManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManager.class);

    @Autowired
    private UserRepository userRepository;

    @Deprecated
    public User register(String userName, String passWord) {

        User user = new User();
        user.setUserName(userName);
        user.setPassWord(Utils.md5(passWord));
        user.setLastLoginTime(System.currentTimeMillis());
        user.setRole(Constants.ROLE_ADMIN);
        try {
            return userRepository.save(user);
        } catch (Throwable e) {
            LOGGER.error("register", e);
            return null;
        }
    }

    public User login(String userName, String passWord) {
        User user = userRepository.getUserByUserNameAndPassWord(userName, Utils.md5(passWord));
        if (null != user) {
            user.setSid(Utils.generateUUId());
        }
        try {
            userRepository.save(user);
            return user;
        } catch (Throwable e) {
            LOGGER.error("register", e);
            return null;
        }
    }


    public User getUserBySid(String sid) {
        return userRepository.getUserBySid(sid);
    }

    public User assign(User currentUser, String userName, String passWord) {

        if (null == currentUser || currentUser.getRole() != Constants.ROLE_ADMIN) {
            throw new RuntimeException("you have no admin permission");
        }

        User user = new User();
        user.setUserName(userName);
        user.setPassWord(Utils.md5(passWord));
        user.setLastLoginTime(System.currentTimeMillis());
        user.setRole(Constants.ROLE_USER);
        try {
            return userRepository.save(user);
        } catch (Throwable e) {
            LOGGER.error("register", e);
            return null;
        }
    }


}
