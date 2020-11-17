package com.best.controller;

import com.best.entity.JsonResult;
import com.best.entity.SysUser;
import com.best.service.SysUserService;
import com.best.utils.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:sunxj
 * @date:2020-11-08 11:08:30
 * @description:用户验证控制器
 */
@RestController
public class UserController {
    @Autowired
    private SysUserService sysUserService;
    @GetMapping("/getUser")
    public JsonResult getUser() {
        SysUser users = sysUserService.selectByName("user1");
        return ResultTool.success(users);
    }
}
