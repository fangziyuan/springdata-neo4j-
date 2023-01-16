package com.zhaokun.springneo4j.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhaokun.springneo4j.config.CmdbHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaok
 * @Date 2023/1/16 20:16
 */
@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;


        String queryString = request.toString();
        log.info("请求参数：{}", JSON.toJSONString(queryString));


        pushRequest2Body(request, handlerMethod);
        return true;
    }


    private void pushRequest2Body(HttpServletRequest request, HandlerMethod handlerMethod) {
        try{
            MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
            if(ArrayUtils.isEmpty(methodParameters)) {
                return;
            }
            if(request instanceof CmdbHttpServletRequestWrapper){
                CmdbHttpServletRequestWrapper requestWrapper = (CmdbHttpServletRequestWrapper)request;
                String body = new String(requestWrapper.getBody(), request.getCharacterEncoding());
                String s = body.toLowerCase();
                log.info("处理后的请求参数：{}", StringEscapeUtils.unescapeJava(s));
                byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
                requestWrapper.setBody(bytes);
            }
        }catch (Exception e){
            log.warn("fill userInfo to request body Error ", e);
        }
    }
}