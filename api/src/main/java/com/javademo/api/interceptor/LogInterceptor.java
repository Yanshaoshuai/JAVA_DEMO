package com.javademo.api.interceptor;

import com.javademo.common.pojo.BaseUser;
import com.javademo.common.utils.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {
    private final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();
    private final static Logger LOG = LoggerFactory.getLogger(LogInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        startTimeThreadLocal.set(startTime);
        LOG.info("-------- LogInterception.preHandle --- ");
        BaseUser currentUser = UserInfoUtil.getCurrentUser();
        LOG.info("-------- user {}----- ", currentUser == null ? "anonymous" : currentUser.getUsername());
        LOG.info("Request URL: {}", request.getRequestURL());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("-------- LogInterception.postHandle --- ");
        LOG.info("Request URL: {}", request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("-------- LogInterception.afterCompletion --- ");

        long startTime = startTimeThreadLocal.get();
        long endTime = System.currentTimeMillis();
        LOG.info("Request URL: {}", request.getRequestURL());

        LOG.info("Time Taken: {}", (endTime - startTime));
    }
}
