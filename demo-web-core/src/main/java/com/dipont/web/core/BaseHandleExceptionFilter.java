package com.dipont.web.core;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dipont.common.exception.BaseException;
import com.dipont.web.core.ResultDTO;

@Order(1)
@WebFilter(filterName = "commonFilter", urlPatterns = "/*")
public class BaseHandleExceptionFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {
            ServletOutputStream out = response.getOutputStream();
            if (ex.getCause() instanceof BaseException) {
                ResultDTO result = new ResultDTO(((BaseException)ex.getCause()).getErrorCode(), ((BaseException)ex.getCause()).getErrorMessage());
                out.write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue).getBytes());
            } else {
                out.write(JSON.toJSONString(new ResultDTO("500", "Inner Exception!")).getBytes());
            }
            out.flush();
        }
    }

    @Override
    public void destroy() {
        
    }
}
