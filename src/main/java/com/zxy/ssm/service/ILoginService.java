package com.zxy.ssm.service;

import com.zxy.ssm.pojo.Login;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description
 * @date 2019/3/12 14:03
 */
public interface ILoginService {
    /**
     * 插入登录信息
     * @param login
     * @return
     */
    int insertLoginData(Login login);
}
