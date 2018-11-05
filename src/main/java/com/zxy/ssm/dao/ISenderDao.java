package com.zxy.ssm.dao;

import com.zxy.ssm.pojo.Sender;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: Sender数据库操作接口
 * </p>
 * @date 2018/10/29 21:33
 */
public interface ISenderDao {

    /**
     * <p>
     *
     * @return
     * @Description: 查询结果个数
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:33
     */
    int getCount();

    /**
     * <p>
     *
     * @return
     * @Description: 查询Sender数据
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:33
     */
    List<Sender> getSender();

    /**
     * <p>
     *
     * @param sender
     * @return
     * @Description: 插入sender数据
     * </p>
     * @author hiYuzu
     * @data 2018/11/5 8:52
     */
    int insertSender(@Param("sender") Sender sender);
}