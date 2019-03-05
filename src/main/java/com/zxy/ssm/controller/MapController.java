package com.zxy.ssm.controller;

import com.zxy.ssm.model.ResultListModel;
import com.zxy.ssm.model.ResultModel;
import com.zxy.ssm.pojo.Map;
import com.zxy.ssm.service.IMapService;
import com.zxy.ssm.util.DateUtil;
import com.zxy.ssm.util.DefaultArgument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description
 * @date 2019/3/5 9:56
 */
@Controller
@RequestMapping("/MapController")
public class MapController {
    @Resource
    private IMapService mapService;

    @RequestMapping("/getMapData")
    public @ResponseBody
    ResultListModel<Map> getMapData(HttpSession session) {
        if (session.getAttribute(DefaultArgument.LOGIN_USER) == null) {
            return null;
        }
        ResultListModel<Map> mapListModel = new ResultListModel<Map>();
        List<Map> mapList = mapService.getMapData();
        if (mapList != null && mapList.size() > 0) {
            for (int i = 0; i < mapList.size(); i++) {
                mapList.get(i).setOptTime(DateUtil.dateToTimestamp(mapList.get(i).getOptTime()));
            }
            mapListModel.setRows(mapList);
            mapListModel.setTotal(mapList.size());
        }
        return mapListModel;
    }
}
