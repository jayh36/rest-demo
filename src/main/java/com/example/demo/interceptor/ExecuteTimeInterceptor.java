package com.example.demo.interceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class ExecuteTimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        log.info("### startTime: " + startTime);
        log.info("### reqUrl: " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        long startTime = (Long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        request.setAttribute("executeTime", executeTime);

        log.info("### ["+ handler + "] executeTime : " + executeTime + "ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, @Nullable Exception arg3) throws Exception {
    }

}
