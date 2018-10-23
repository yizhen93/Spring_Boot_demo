package com.dipont.web.user;

import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;

import com.dipont.web.core.BaseHandleExceptionFilter;

@Order(1)
@WebFilter(filterName = "userHandleExceptionFilter", urlPatterns = "/*")
public class UserHandleExceptionFilter extends BaseHandleExceptionFilter {
}
