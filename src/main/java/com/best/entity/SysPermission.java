package com.best.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:sunxj
 * @date:2020-11-08 00:18:33
 * @description:权限表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    private Integer id;//主键ID
    private String permissionCode;//权限Code
    private String permissionName;//权限名
}
