package com.zxy.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxy.ssm.dao.IUserDao;
import com.zxy.ssm.pojo.User;
import com.zxy.ssm.service.IUserService;

/**
 * <p>
 *
 * @author yuzu
 * @Description: User操作服务类实现
 * </p>
 * @date 2018/9/29 16:15
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public int getCount() {
        return userDao.getCount();
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUser();
    }

    @Override
    public String getPassword(User user) {
        return userDao.getPassword(user);
    }
}