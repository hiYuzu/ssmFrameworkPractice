package com.zxy.ssm.util;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description Session管理
 * @date 2018/12/19 8:40
 */
public class SessionManager {

    /**
     * 判断Session是否过期
     * @param httpsession
     * @param key
     * @return
     */
    public static boolean isSessionValidate(HttpSession httpsession, String key) {
        boolean flag = true;
        try {
            if (httpsession != null && httpsession.getId() != null && httpsession.getAttribute(key) != null) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (Exception e) {
            flag = true;
        }
        return flag;
    }
}
