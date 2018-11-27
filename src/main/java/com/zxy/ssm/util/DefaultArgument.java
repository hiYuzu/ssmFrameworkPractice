package com.zxy.ssm.util;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description 默认参数值
 * @date 2018/11/26 14:18
 */
public class DefaultArgument {
    /**
     * 默认用户名
     */
    public static final String LOGIN_USER = "loginUser";
    /**
     * 默认验证值
     */
    public static final int VAIL_LOGIN = 9527;
    /**
     * int默认值:-1
     */
    public static final int INT_DEFAULT = -1;
    /**
     * 无选择默认值:0
     */
    public static final String NONE_DEFAULT = "0";
    /**
     * double默认值:-1
     */
    public static final double DOUBLE_DEFAULT = -1;
    /**
     * 删除标记默认值:false
     */
    public static final boolean DEL_DEFAULT = false;
    /**
     * 系统时间
     */
    public static Timestamp LOGIN_DATETIME = new Timestamp(Calendar.getInstance().getTimeInMillis());
    /**
     * 系统最底层级别
     */
    public static final String BOTTOM_LEVEL_FALG = "4";

}
