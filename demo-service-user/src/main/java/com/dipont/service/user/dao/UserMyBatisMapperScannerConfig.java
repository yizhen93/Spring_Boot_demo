package com.dipont.service.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dipont.service.common.MyBatisMapperScannerConfig;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class UserMyBatisMapperScannerConfig extends MyBatisMapperScannerConfig{
    
    @Bean
    @Override
    public MapperScannerConfigurer mapperScannerConfigurer() {
        return super.mapperScannerConfigurer();
    }
}
