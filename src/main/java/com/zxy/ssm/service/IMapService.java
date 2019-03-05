package com.zxy.ssm.service;

import com.zxy.ssm.pojo.Map;

import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description
 * @date 2019/3/5 10:11
 */
public interface IMapService {
    /**
     * 获取所有信息
     * @return
     */
    List<Map> getMapData();
}
