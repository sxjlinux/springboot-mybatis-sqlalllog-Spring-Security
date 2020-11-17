package com.best.service.impl;

import com.best.entity.SysRequestPathPermissionRelation;
import com.best.mapper.SysRequestPathPermissionRelationMapper;
import com.best.service.SysRequestPathPermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:sunxj
 * @date:2020-11-08 23:22:04
 * @description:路径权限关联表(SysRequestPathPermissionRelation)表服务实现类
 */
@Service
public class SysRequestPathPermissionRelationServiceImpl implements SysRequestPathPermissionRelationService {
    @Autowired
    private SysRequestPathPermissionRelationMapper sysRequestPathPermissionRelationMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRequestPathPermissionRelation queryById(Integer id) {
        return this.sysRequestPathPermissionRelationMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRequestPathPermissionRelation> queryAllByLimit(int offset, int limit) {
        return this.sysRequestPathPermissionRelationMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRequestPathPermissionRelation 实例对象
     * @return 实例对象
     */
    @Override
    public SysRequestPathPermissionRelation insert(SysRequestPathPermissionRelation sysRequestPathPermissionRelation) {
        this.sysRequestPathPermissionRelationMapper.insert(sysRequestPathPermissionRelation);
        return sysRequestPathPermissionRelation;
    }

    /**
     * 修改数据
     *
     * @param sysRequestPathPermissionRelation 实例对象
     * @return 实例对象
     */
    @Override
    public SysRequestPathPermissionRelation update(SysRequestPathPermissionRelation sysRequestPathPermissionRelation) {
        this.sysRequestPathPermissionRelationMapper.update(sysRequestPathPermissionRelation);
        return this.queryById(sysRequestPathPermissionRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysRequestPathPermissionRelationMapper.deleteById(id) > 0;
    }
}
