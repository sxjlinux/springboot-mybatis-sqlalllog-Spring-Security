package com.best.config;

import com.best.config.handler.*;
import com.best.config.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author:sunxj
 * @date:2020-11-15 22:59:03
 * @description:权限配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //登录成功处理逻辑
    @Autowired
    private CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;
    //登录失败处理逻辑
    @Autowired
    private CustomizeAuthenticationFailureHandler authenticationFailureHandler;
    //权限拒绝处理逻辑
    @Autowired
    private CustomizeAccessDeniedHandler accessDeniedHandler;
    //匿名用户访问无权限资源时的异常
    @Autowired
    private CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;
    //会话失效（账号被挤下线）处理逻辑
    @Autowired
    private CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    //登出成功处理逻辑
    @Autowired
    private CustomizeLogoutSuccessHandler logoutSuccessHandler;
    //访问决策管理器
    @Autowired
    private CustomizeAccessDecisionManager accessDecisionManager;
    //实现权限拦截
    @Autowired
    private CustomizeFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
    //
    @Autowired
    private CustomizeAbstractSecurityInterceptor abstractSecurityInterceptor;
    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式等
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        //http相关的配置，包括登入登出、异常处理、回话管理
       /* http.cors().and().csrf().disable();//禁用默认的重定向功能
        http.authorizeRequests()
                .antMatchers("/getUser")
                .hasAuthority("query_user")
                .and()
                .formLogin();*/
        http.cors().and().csrf().disable();//禁用默认的重定向功能
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(accessDecisionManager);
                        o.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                        return o;
                    }
                })
                //登出
                .and()
                .logout()
                .permitAll()//允许所有用户
                .logoutSuccessHandler(logoutSuccessHandler)//退出成功处理逻辑
                .deleteCookies("JSESSIONID")//登出之前删除cookie
                .and()//登入
                .formLogin()
                .permitAll()//允许所有用户
                .successHandler(authenticationSuccessHandler)//登陆成功逻辑
                .failureHandler(authenticationFailureHandler)//登录失败逻辑
                .and()//异常处理（权限拒绝、登录失效等）
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)//权限拒绝处理逻辑
                .authenticationEntryPoint(customizeAuthenticationEntryPoint)//匿名用户访问无权限资源时的异常处理，比如用户未登陆访问资源
                .and()//会话管理
                .sessionManagement()
                .maximumSessions(1)//同一账号同时登录最大用户数
                .maxSessionsPreventsLogin(false)//如果有用户已登录则在次登录是不允许的
                .expiredSessionStrategy(sessionInformationExpiredStrategy);//会话失效（账号被挤下线处理逻辑）
        http.addFilterBefore(abstractSecurityInterceptor,FilterSecurityInterceptor.class);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }
}
