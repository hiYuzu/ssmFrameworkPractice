package com.zxy.ssm.service;

import java.util.List;

import com.zxy.ssm.pojo.User;

/**
 * <p>
 *
 * @author yuzu
 * @Description: User操作服务类接口
 * </p>
 * @date 2018/9/29 16:08
 */

public interface IUserService {

    /**
     * <p>
     *
     * @return
     * @Description: 查询结果个数
     * </p>
     * @author yuzu
     * @date 2018/9/29 13:09
     */
    int getCount();

    /**
     * <p>
     *
     * @return
     * @Description: 查询user数据
     * </p>
     * @author yuzu
     * @date 2018/9/29 13:10
     */
    List<User> getUsers();

    /**
     * <p>
     *
     * @param user
     * @return
     * @Description: 查询user数据
     * </p>
     * @author hiYuzu
     * @date 2018/11/5 10:44
     */
    String getPassword(User user);
}