package com.zxy.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.zxy.ssm.util.DefaultArgument;
import com.zxy.ssm.util.EncodeUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxy.ssm.model.UserModel;
import com.zxy.ssm.pojo.User;
import com.zxy.ssm.service.IUserService;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * 日志输出标记
     */
    private static final String LOG = "UserController";

    /**
     * 声明日志对象
     */
    private static Logger logger = Logger.getLogger(UserController.class);
    /**
     * 声明服务
     */
    @Resource
    private IUserService userService;

    /**
     * <p>
     *
     * @Description 登录
     * </p>
     * @author hiYuzu
     * @date 2018/11/5 10:12
     */
    @RequestMapping(value = "/loginUser", method = {RequestMethod.POST})

    public String loginUser(UserModel userModel, HttpSession session) throws Exception {
        if (userModel != null && userModel.getUserName() != null && userModel.getUserPwd() != null) {
            userModel.setUserPwd(EncodeUtil.encode(userModel.getUserPwd()));
            User user = convertUser(userModel);
            try {
                String pwd = userService.getPassword(user);
                if (user.getUserPwd().equals(pwd)) {
                    session.setAttribute(DefaultArgument.LOGIN_USER, DefaultArgument.VAIL_LOGIN);
                    return "/html/loginSuccess";
                }
            } catch (Exception e) {
                logger.error(LOG + "登录失败,失败信息：" + e.getMessage());
                return "/html/login";
            }
        }
        return "/html/login";
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
            if (userModel.getUserId() != null) {
                user.setUserId(Integer.parseInt(userModel.getUserId()));
            }
            user.setUserName(userModel.getUserName());
            user.setUserSex(userModel.getUserSex());
            if (userModel.getUserAge() != null) {
                user.setUserAge(Integer.parseInt(userModel.getUserAge()));
            }
            user.setUserTel(userModel.getUserTel());
            user.setUserEmail(userModel.getUserEmail());
            user.setUserPwd(userModel.getUserPwd());
        }
        return user;
    }

}