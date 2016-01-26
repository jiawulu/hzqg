package com.lu.utils;

import com.lu.domain.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.UUID;

public class Utils {

    public final static String md5(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String generateUUId() {
        return UUID.randomUUID().toString();
    }

    public static String getSid(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (Constants.SID.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static User getUser(HttpServletRequest request) {
        Object obj = request.getAttribute("user");
        if (null != obj && obj instanceof User) {
            return (User) obj;
        }
        return null;
    }

    public static int getIntParam(HttpServletRequest request, String key, int defaultValue) {
        String value = request.getParameter(key);
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        try {
            return Integer.valueOf(value);
        } catch (Throwable e) {
            return defaultValue;
        }
    }


}
