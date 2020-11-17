package com.best.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:sunxj
 * @date:2020-11-08 17:22:05
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRequestPathPermissionRelation {
    private Integer id;
    private Integer urlId;
    private Integer permissionId;
}
