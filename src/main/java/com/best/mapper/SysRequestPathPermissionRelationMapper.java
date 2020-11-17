package com.best.mapper;

import com.best.entity.SysRequestPathPermissionRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:sunxj
 * @date:2020-11-08 17:17:32
 * @description:路径权限关联表(SysRequestPathPermissionRelation)表数据库访问层
 */
@Repository
public interface SysRequestPathPermissionRelationMapper {
    /**
     *通过ID查询单条数据
     * @param id 主键id
     * @return
     */
    SysRequestPathPermissionRelation queryById(Integer id);

    /**
     * 查询指定行数据
     * @param offset
     * @param limit
     * @return
     */
    List<SysRequestPathPermissionRelation> queryAllByLimit(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     * @param sysRequestPathPermissionRelation
     * @return
     */
    List<SysRequestPathPermissionRelation> queryAll(SysRequestPathPermissionRelation sysRequestPathPermissionRelation);

    /**
     * 新增数据
     * @param sysRequestPathPermissionRelation
     * @return
     */
    int insert(SysRequestPathPermissionRelation sysRequestPathPermissionRelation);

    /**
     * 修改数据
     * @param sysRequestPathPermissionRelation
     * @return
     */
    int update(SysRequestPathPermissionRelation sysRequestPathPermissionRelation);

    /**
     * 通过主键删除数据
     * @param id
     * @return
     */
    int deleteById(Integer id);
}
