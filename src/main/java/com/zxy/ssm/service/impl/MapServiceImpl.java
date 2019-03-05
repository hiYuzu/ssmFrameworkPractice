package com.zxy.ssm.service.impl;

import com.zxy.ssm.dao.IMapDao;
import com.zxy.ssm.pojo.Map;
import com.zxy.ssm.service.IMapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description
 * @date 2019/3/5 10:12
 */
@Service("mapService")
public class MapServiceImpl implements IMapService {
    @Resource
    private IMapDao mapDao;

    @Override
    public List<Map> getMapData() {
        return mapDao.getMapData();
    }
}
