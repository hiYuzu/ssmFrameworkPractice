package com.zxy.ssm.service;

import com.zxy.ssm.pojo.Sender;

import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: Sender操作服务类接口
 * </p>
 * @date 2018/10/29 21:42
 */

public interface ISenderService {

    /**
     * <p>
     *
     * @return
     * @Description: 查询结果个数
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:42
     */
    int getCount();

    /**
     * <p>
     *
     * @return
     * @Description: 查询sender数据
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:42
     */
    List<Sender> getSenders();

    /**
     * <p>
     *
     * @param sender
     * @return
     * @throws Exception
     * @Description 插入sender数据
     * </p>
     * @author hiYuzu
     * @data 2018/11/5 8:39
     */
    int insertSender(Sender sender) throws Exception;
}