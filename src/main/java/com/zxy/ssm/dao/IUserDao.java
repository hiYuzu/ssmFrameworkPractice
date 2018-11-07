package com.zxy.ssm.dao;

import java.util.List;


import com.zxy.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * @author yuzu
 * @Description: User数据库操作接口
 * </p>
 * @date 2018/10/11 8:25
 */
public interface IUserDao {

    /**
     * <p>
     *
     * @return
     * @Description: 查询结果个数
     * </p>
     * @author yuzu
     * @date 2018/10/11 8:28
     */
    int getCount();

    /**
     * <p>
     *
     * @return
     * @Description: 查询User数据
     * </p>
     * @author yuzu
     * @date 2018/10/11 8:30
     */
    List<User> getUser();

    /**
     * <p>
     *
     * @param user
     * @return
     * @Description: 获取密码
     * </p>
     * @author hiYuzu
     * @data 2018/11/5 10:52
     */
    String getPassword(@Param("user") User user);
}