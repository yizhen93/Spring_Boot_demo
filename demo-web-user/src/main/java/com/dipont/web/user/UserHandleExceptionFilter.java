package com.dipont.web.user;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;

import com.dipont.web.core.BaseHandleExceptionFilter;

@Order(1)
@WebFilter(filterName = "commonFilter", urlPatterns = "/*")
public class UserHandleExceptionFilter extends BaseHandleExceptionFilter {
}
