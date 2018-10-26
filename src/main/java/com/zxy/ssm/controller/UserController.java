package com.zxy.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxy.ssm.model.UserModel;
import com.zxy.ssm.model.ResultListModel;
import com.zxy.ssm.pojo.User;
import com.zxy.ssm.service.IUserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *
 * @author yuzu
 * @Description: User控制器
 * </p>
 * @date 2018/9/29 13:18
 */
@Controller
@RequestMapping("/UserController")
public class UserController {
    /**
     * 声明服务
     */
    @Resource
    private IUserService userService;

    /**
     * <p>
     *
     * @return
     * @Description: 查询user信息
     * </p>
     * @author yuzu
     * @date 2018/9/29 13:20
     */
    @RequestMapping(value = "/queryUsers", method = {RequestMethod.GET})

    public @ResponseBody ResultListModel<UserModel> queryUsers() {
        ResultListModel<UserModel> resultListModel = new ResultListModel<UserModel>();
        List<UserModel> listUserModel = new ArrayList<UserModel>();
        List<User> listUser;
        int count = userService.getCount();
        if (count > 0) {
            listUser = userService.getUsers();
            for (User temp : listUser) {
                UserModel userModel = convertUserModel(temp);
                if (userModel != null) {
                    listUserModel.add(userModel);
                }
            }
            resultListModel.setRows(listUserModel);
        }
        resultListModel.setTotal(count);
        return resultListModel;
    }

    /**
     * <p>
     *
     * @param userModel
     * @return
     * @Description: 将UserModel转为User
     * </p>
     * @author yuzu
     * @date 2018/9/29 14:49
     */
    private User convertUser(UserModel userModel) {
        User user = new User();
        if (userModel != null) {
            user.setUserId(Integer.parseInt(userModel.getUserId()));
            user.setUserName(userModel.getUserName());
            user.setUserSex(userModel.getUserSex());
            user.setUserAge(Integer.parseInt(userModel.getUserAge()));
            user.setUserTel(userModel.getUserTel());
            user.setUserEmail(userModel.getUserEmail());
            user.setUserPwd(userModel.getUserPwd());
        }
        return user;
    }

    /**
     * <p>
     *
     * @param user
     * @return
     * @Description: 将User转为UserModel
     * </p>
     * @author yuzu
     * @date 2018/9/29 14:49
     */
    private UserModel convertUserModel(User user) {
        UserModel userModel = new UserModel();
        if (user != null) {
            userModel.setUserId(String.valueOf(user.getUserId()));
            userModel.setUserName(user.getUserName());
            userModel.setUserSex(user.getUserSex());
            userModel.setUserAge(String.valueOf(user.getUserAge()));
            userModel.setUserTel(user.getUserTel());
            userModel.setUserEmail(user.getUserEmail());
            userModel.setUserPwd(user.getUserPwd());
        }
        return userModel;
    }
}