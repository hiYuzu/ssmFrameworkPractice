package com.zxy.ssm.controller;

import com.zxy.ssm.model.UserModel;
import com.zxy.ssm.pojo.Login;
import com.zxy.ssm.pojo.User;
import com.zxy.ssm.service.ILoginService;
import com.zxy.ssm.service.IUserService;
import com.zxy.ssm.util.DefaultArgument;
import com.zxy.ssm.util.EncodeUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description 登录及页面跳转控制
 * @date 2018/12/18 19:09
 */
@Controller
public class LoginController {

    /**
     * 声明User服务
     */
    @Resource
    private IUserService userService;
    /**
     * 声明登录信息记录服务
     */
    @Resource
    private ILoginService loginService;

    /**
     * 日志输出标记
     */
    private static final String LOG = "UserController";

    /**
     * 声明日志对象
     */
    private static Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 登录请求get
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login() {
        return "html/login";
    }

    /**
     * 登录请求post
     * @param userModel
     * @param vCode
     * @param session
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(UserModel userModel, String vCode, HttpSession session, HttpServletRequest request) throws Exception {
        Object object = session.getAttribute("_code");
        if (object == null) {
            return "/html/login";
        }
        String realVCode = object.toString();
        if (!realVCode.equals(vCode.toLowerCase())) {
            session.setAttribute("msg", "验证码错误!");
            return "/html/login";
        }
        if (userModel != null && userModel.getUserName() != null && userModel.getUserPwd() != null) {
            userModel.setUserPwd(EncodeUtil.encode(userModel.getUserPwd()));
            User user = convertUser(userModel);
            try {
                String pwd = userService.getPassword(user.getUserName());
                if (user.getUserPwd().equals(pwd)) {
                    session.setAttribute(DefaultArgument.LOGIN_USER, userService.getUserId(user.getUserName()));
                    insertLoginData(session, request);
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
     * 登出接口
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public String logout(HttpSession session) {
        session.removeAttribute(DefaultArgument.LOGIN_USER);
        return "../index";
    }

    /**
     * 地图跳转
     * @return
     */
    @RequestMapping(value = "/goMap")
    public String goMap() {
        return "/html/myMap";
    }

    /**
     * 转换
     *
     * @param userModel
     * @return
     */
    private User convertUser(UserModel userModel) {
        User user = new User();
        user.setUserName(userModel.getUserName());
        user.setUserPwd(userModel.getUserPwd());
        user.setUserTel(userModel.getUserTel());
        return user;
    }

    private void insertLoginData(HttpSession session, HttpServletRequest request) {
        Login login = new Login();
        login.setUserId((Integer) session.getAttribute(DefaultArgument.LOGIN_USER));
        //IP地址
        login.setRemoteAddr(request.getRemoteAddr());
        //真实IP地址
        login.setRealIp(getClientIp(request));
        loginService.insertLoginData(login);
    }
    /**
     * 获取真实IP
     * @param request
     * @return
     */
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || ip.indexOf(":") > -1) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                ip = null;
            }
        }
        return ip;
    }
}
