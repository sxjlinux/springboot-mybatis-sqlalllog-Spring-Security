package com.best.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:sunxj
 * @date:2020-11-07 17:15:06
 * @description:用户表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    private Integer id;//用户id
    private String account;//账号
    private String userName;//用户名
    private String password;//密码
    private Date lastLoginTime;//上一次登录时间
    private Boolean enabled;//账号是否可用，默认为1表示可用
    private Boolean accountNonExpired;//账号是否过期，默认为1表示不过期
    private Boolean accountNonLocked;//账号是否锁定，默认为1表示不锁定
    private Boolean credentialsNonExpired;//证书（密码）是否过期，默认为1（表示不过期）
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    private Integer createUser;//创建用户的id
    private Integer updateUser;//修改用户的id
}
