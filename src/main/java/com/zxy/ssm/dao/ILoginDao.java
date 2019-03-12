package com.zxy.ssm.dao;

import com.zxy.ssm.pojo.Login;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description
 * @date 2019/3/12 14:10
 */
public interface ILoginDao {
    /**
     * 插入登录信息
     * @param login
     * @return
     */
    int insertLoginData(@Param("login") Login login);
}
