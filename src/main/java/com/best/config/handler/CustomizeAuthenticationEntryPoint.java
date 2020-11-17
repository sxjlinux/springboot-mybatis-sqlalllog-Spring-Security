package com.best.config.handler;

import com.alibaba.fastjson.JSON;
import com.best.entity.JsonResult;
import com.best.entity.enums.ResultCode;
import com.best.utils.ResultTool;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:sunxj
 * @date:2020-11-16 22:26:02
 * @description:匿名用户访问无权限资源时的异常
 */
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JsonResult result = ResultTool.fail(ResultCode.USER_NOT_LOGIN);//生成一个用户未登陆json结果串
        httpServletResponse.setContentType("text/json;charset=UTF-8");//设置返回结果的内容类型和编码
        httpServletResponse.getWriter().write(JSON.toJSONString(result));//将json串写入到response中
    }
}
