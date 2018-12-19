package com.zxy.ssm.controller;

import javax.annotation.Resource;
import com.zxy.ssm.model.ResultModel;
import com.zxy.ssm.util.EncodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxy.ssm.model.UserModel;
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

    @RequestMapping(value = "/signUp", method = {RequestMethod.POST})
    public @ResponseBody
    ResultModel signUp(UserModel userModel) throws Exception {
        ResultModel resultModel = new ResultModel();
        if (userModel != null && userModel.getUserName() != null && userModel.getUserTel() != null && userModel.getUserPwd() != null) {
            userModel.setUserPwd(EncodeUtil.encode(userModel.getUserPwd()));
            User user = convertUser(userModel);
            userService.insert(user);
        } else {
            resultModel.setResult(false);
            resultModel.setDetail("注册所需信息不全!");
        }
        return resultModel;
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
            if (userModel.getUserSex() != null) {
                user.setUserSex(userModel.getUserSex());
            }
            if (userModel.getUserAge() != null) {
                user.setUserAge(Integer.parseInt(userModel.getUserAge()));
            }
            if (userModel.getUserEmail() != null) {
                user.setUserEmail(userModel.getUserEmail());
            }
            user.setUserName(userModel.getUserName());
            user.setUserPwd(userModel.getUserPwd());
            user.setUserTel(userModel.getUserTel());
        }
        return user;
    }

}