package com.best.mapper;

import com.best.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:sunxj
 * @date:2020-11-08 00:14:26
 * @description:用户权限信息
 */
@Repository
public interface SysPermissionMapper {
    /**
     * 通过ID查询单条数据
     * @param id
     * @return
     */
    public SysPermission queryById(Integer id);

    /**
     * 查询指定行数据
     * @param offset
     * @param limit
     * @return
     */
    public List<SysPermission> queryAllByLimit(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * 通过实体类作为筛选条件查询
     * @param sysPermission
     * @return
     */
    public List<SysPermission> queryAll(SysPermission sysPermission);

    /**
     * 新增数据
     * @param sysPermission
     * @return
     */
    int insert(SysPermission sysPermission);

    /**
     * 修改数据
     * @param sysPermission
     * @return
     */
    int update(SysPermission sysPermission);

    /**
     * 通过id删除数据
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 通过主键删除数据
     * @param userId
     * @return
     */
    public List<SysPermission> selectListByUser(Integer userId);

    /**
     * 查询具体某个接口的权限
     * @param path
     * @return
     */
    List<SysPermission> selectListByPath(String path);
}
