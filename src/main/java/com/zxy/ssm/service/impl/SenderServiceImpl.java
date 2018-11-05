package com.zxy.ssm.service.impl;

import com.zxy.ssm.dao.ISenderDao;
import com.zxy.ssm.pojo.Sender;
import com.zxy.ssm.service.ISenderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: Sender操作服务类实现
 * </p>
 * @date 2018/10/29 21:44
 */
@Service("senderService")
@Transactional(rollbackFor = Exception.class)
public class SenderServiceImpl implements ISenderService {
    @Resource
    private ISenderDao senderDao;

    @Override
    public int getCount() {
        return senderDao.getCount();
    }

    @Override
    public List<Sender> getSenders() {
        return senderDao.getSender();
    }

    @Override
    public int insertSender(Sender sender) throws Exception {
        return senderDao.insertSender(sender);
    }
}