package com.zxy.ssm.interceptor;

import com.zxy.ssm.util.DefaultArgument;
import com.zxy.ssm.util.SessionManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description 安全拦截器
 * @date 2018/12/19 8:34
 */
public class SecurityInterceptor implements HandlerInterceptor {
    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //过滤不需要安全检查的访问
        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }

        HttpSession session = request.getSession();
        if (SessionManager.isSessionValidate(session, DefaultArgument.LOGIN_USER)) {
            //如果是ajax请求响应头会有，x-requested-with
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                //在响应头设置Session状态
                response.setHeader("sessionstatus", "timeout");
            } else {
                String path = request.getContextPath();
                response.sendRedirect(path + "/index.html");
            }
            return false;
        } else {
            //用户已登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
    }
}
