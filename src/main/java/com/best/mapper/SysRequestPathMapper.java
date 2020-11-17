package com.best.mapper;

import com.best.entity.SysRequestPath;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:sunxj
 * @date:2020-11-08 17:18:09
 * @description:请求路径(SysRequestPath)表数据库访问层
 */
@Repository
public interface SysRequestPathMapper {
    /**
     * 通过ID查询单挑数据
     * @param id
     * @return
     */
    SysRequestPath queryById(Integer id);

    /**
     * 查询指定行数据
     * @param offset
     * @param limit
     * @return
     */
    List<SysRequestPath> queryAllByLimit(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     * @param sysRequestPath
     * @return
     */
    List<SysRequestPath> queryAll(SysRequestPath sysRequestPath);

    /**
     * 新增数据
     * @param sysRequestPath
     * @return
     */
    int insert(SysRequestPath sysRequestPath);

    /**
     * 修改数据
     * @param sysRequestPath
     * @return
     */
    int update(SysRequestPath sysRequestPath);

    /**
     * 通过主键删除数据
     * @param id
     * @return
     */
    int deleteById(Integer id);

}
