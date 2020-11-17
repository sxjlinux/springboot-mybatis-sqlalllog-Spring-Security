package com.best.config;

import com.best.interceptor.SqlLoggerInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author:sunxj
 * @date:2020-11-11 22:18:55
 * @description:mybatis插件配置类
 */
@Configuration
public class BatisPlusConfig {
    @Bean
    public String myInterceptor(SqlSessionFactory sqlSessionFactory) {
        //实例化插件
        SqlLoggerInterceptor sqlInterceptor = new SqlLoggerInterceptor();
        //创建属性值
        Properties properties = new Properties();
        properties.setProperty("prop1","value1");
        //将属性值设置到插件中
        sqlInterceptor.setProperties(properties);
        //将插件添加到SqlSessionFactory工厂
        sqlSessionFactory.getConfiguration().addInterceptor(sqlInterceptor);
        return "interceptor";
    }
}
