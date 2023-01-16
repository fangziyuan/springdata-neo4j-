package com.zhaokun.springneo4j.config;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author zhaok
 * @summary 自定义 DispatcherServlet 来分派 XinHttpServletRequestWrapper
*/
public class CmdbDispatcherServlet extends DispatcherServlet {

    /**
     * 包装成我们自定义的request
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doDispatch(new CmdbHttpServletRequestWrapper(request), response);
    }
}