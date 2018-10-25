package com.dipont.web.core;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.alibaba.fastjson.JSON;
import com.dipont.common.exception.BaseException;


@Order(1)
@WebFilter(filterName = "baseHandleExceptionFilter", urlPatterns = "/*")
public class BaseHandleExceptionFilter implements Filter {
    private static String ENCODE_MODE = "application/json;charset=utf-8";
    
    private static final Logger logger = LoggerFactory.getLogger(BaseHandleExceptionFilter.class);
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
        	response.setContentType(ENCODE_MODE);
            chain.doFilter(request, response);
        } catch (Exception ex) {
            ServletOutputStream out = response.getOutputStream();
            if (ex.getCause() instanceof BaseException) {
            	logger.error(ex.getMessage());
                ResultDTO result = new AbnormalResultDTO(((BaseException)ex.getCause()).getErrorCode(), ((BaseException)ex.getCause()).getErrorMessage());
                out.write(JSON.toJSONString(result).getBytes());
            } else {
            	logger.error(ex.getMessage());
                out.write(JSON.toJSONString(new AbnormalResultDTO()).getBytes());
            }
            out.flush();
        }
    }

    @Override
    public void destroy() {
        
    }
}
