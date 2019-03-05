package com.zxy.ssm.dao;

import com.zxy.ssm.pojo.Map;

import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description
 * @date 2019/3/5 10:14
 */
public interface IMapDao {
    /**
     * 获取所有信息
     * @return
     */
    List<Map> getMapData();
}
