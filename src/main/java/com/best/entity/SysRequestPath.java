package com.best.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:sunxj
 * @date:2020-11-08 17:19:37
 * @description:用户请求url实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRequestPath {
    private Integer id;
    private String url;
    private String description;
}
