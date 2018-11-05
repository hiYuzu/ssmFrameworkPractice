package com.zxy.ssm.controller;

import com.zxy.ssm.model.ResultListModel;
import com.zxy.ssm.model.ResultModel;
import com.zxy.ssm.model.SenderModel;
import com.zxy.ssm.pojo.Sender;
import com.zxy.ssm.service.ISenderService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @discription sender留言处理
 * </p>
 * @author: hiYuzu
 * @date: 2018/10/29 21:26
 */

@Controller
@RequestMapping("/SenderController")
public class SenderController {
    /**
     * 日志输出标记
     */
    private static final String LOG = "SenderController";

    /**
     * 声明日志对象
     */
    private static Logger logger = Logger.getLogger(SenderController.class);

    /**
     * 声明服务
     */
    @Resource
    private ISenderService senderService;

    /**
     * <p>
     *
     * @return
     * @Description: 查询sender信息
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:26
     */
    @RequestMapping(value = "/querySenders", method = {RequestMethod.GET})

    public @ResponseBody
    ResultListModel<SenderModel> querySenders() {
        ResultListModel<SenderModel> resultListModel = new ResultListModel<SenderModel>();
        List<SenderModel> listSenderModel = new ArrayList<SenderModel>();
        List<Sender> listSender;
        int count = senderService.getCount();
        if (count > 0) {
            listSender = senderService.getSenders();
            for (Sender temp : listSender) {
                SenderModel senderModel = convertSenderModel(temp);
                if (senderModel != null) {
                    listSenderModel.add(senderModel);
                }
            }
            resultListModel.setRows(listSenderModel);
            resultListModel.setResult(true);
            resultListModel.setDetail("success");
        }
        resultListModel.setTotal(count);
        return resultListModel;
    }

    /**
     * <p>
     *
     * @return
     * @Description: 插入sender信息
     * </p>
     * @author hiYuzu
     * @date
     */
    @RequestMapping(value = "/insertSender", method = {RequestMethod.POST})
    public @ResponseBody
    ResultModel insertSender(SenderModel senderModel) {
        ResultModel resultModel = new ResultModel();
        if (senderModel != null) {
            try {
                Sender sender = new Sender();
                sender = convertSender(senderModel);
                int result = senderService.insertSender(sender);
                if (result > 0) {
                    resultModel.setResult(true);
                    resultModel.setDetail("发送成功!");
                } else {
                    resultModel.setResult(false);
                    resultModel.setDetail("发送失败");
                }
            } catch (Exception e) {
                resultModel.setResult(false);
                resultModel.setDetail("发送失败");
                logger.error(LOG + "登录失败,失败信息：" + e.getMessage());
            }
        }
        return resultModel;
    }


    /**
     * <p>
     *
     * @param senderModel
     * @return
     * @Description: 将SenderModel转为Sender
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:47
     */
    private Sender convertSender(SenderModel senderModel) {
        Sender sender = new Sender();
        if (senderModel != null) {
            if(sender.getSenderId() > 0){
                sender.setSenderId(Integer.parseInt(senderModel.getSenderId()));
            }
            sender.setSenderName(senderModel.getSenderName());
            sender.setSenderTel(senderModel.getSenderTel());
            sender.setSenderMsg(senderModel.getSenderMsg());
            if(sender.getOptTime() != null){
                sender.setOptTime(senderModel.getOptTime());
            }
        }
        return sender;
    }

    /**
     * <p>
     *
     * @param sender
     * @return
     * @Description: 将Sender转为SenderModel
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:47
     */
    private SenderModel convertSenderModel(Sender sender) {
        SenderModel senderModel = new SenderModel();
        if (sender != null) {
            if(sender.getSenderId() > 0){
                senderModel.setSenderId(String.valueOf(sender.getSenderId()));
            }
            senderModel.setSenderName(sender.getSenderName());
            senderModel.setSenderTel(sender.getSenderTel());
            senderModel.setSenderMsg(sender.getSenderMsg());
            if(sender.getOptTime() != null){
                senderModel.setOptTime(sender.getOptTime());
            }
        }
        return senderModel;
    }
}
