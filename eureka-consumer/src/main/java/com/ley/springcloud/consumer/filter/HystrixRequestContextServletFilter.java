package com.ley.springcloud.consumer.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * 用于初始化Hystrix请求上下文环境{@link Filter}
 **/
@WebFilter(filterName = HystrixRequestContextServletFilter.FILTER_NAME, urlPatterns = HystrixRequestContextServletFilter.URL_PATTERNS, asyncSupported = true)
@Slf4j
public class HystrixRequestContextServletFilter implements Filter {

    public static final String URL_PATTERNS = "/*";

    public static final String FILTER_NAME = "hystrixRequestContextServletFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("HystrixRequestContextServletFilter拦截之前");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //初始化Hystrix请求上下文
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            //请求正常通过
            chain.doFilter(request, response);
        } finally {
            //关闭Hystrix请求上下文
            context.shutdown();
        }
    }

    @Override
    public void destroy() {
        log.info("HystrixRequestContextServletFilter拦截之后");
    }
}
