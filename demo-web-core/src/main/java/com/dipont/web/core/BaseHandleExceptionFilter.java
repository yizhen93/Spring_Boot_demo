package com.dipont.web.core;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.alibaba.fastjson.JSON;
import com.dipont.common.exception.BaseRuntimeException;


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
    	ServletOutputStream out = response.getOutputStream();
    	ResultDTO result = null;
    	
    	response.setContentType(ENCODE_MODE);
        try {
            chain.doFilter(request, response);
        } catch (BaseRuntimeException ex) {
        	logger.error(ex.getErrorCode(), ex.getMessage(), ex);
            result = new AbnormalResultDTO(((BaseRuntimeException)ex.getCause()).getErrorCode(), ((BaseRuntimeException)ex.getCause()).getErrorMessage());
        } catch (RuntimeException ex) {
        	logger.error(ex.getMessage(), ex);
        	result = new AbnormalResultDTO();
        } catch (Exception ex) {
        	logger.error(ex.getMessage(), ex);
        	result = new AbnormalResultDTO();
        } finally {
			if (result != null) {
	            out.write(JSON.toJSONString(result).getBytes());
	            out.flush();
			}
		}
    }

    @Override
    public void destroy() {
        
    }
}
