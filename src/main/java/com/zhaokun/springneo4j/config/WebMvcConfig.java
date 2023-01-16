package com.zhaokun.springneo4j.config;

import com.zhaokun.springneo4j.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMVC配置，你可以集中在这里配置拦截器、过滤器、静态资源缓存等
 * @author zhaok
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final RequestInterceptor requestInterceptor;

    public WebMvcConfig(RequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor)
                .addPathPatterns("/hello/**");
    }

    @Bean
    @Qualifier(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new CmdbDispatcherServlet();
    }
}