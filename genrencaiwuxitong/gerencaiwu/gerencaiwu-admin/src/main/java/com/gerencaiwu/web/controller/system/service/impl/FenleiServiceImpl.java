package com.gerencaiwu.web.controller.system.service.impl;

import java.util.List;

import com.gerencaiwu.web.controller.system.domain.Fenlei;
import com.gerencaiwu.web.controller.system.mapper.FenleiMapper;
import com.gerencaiwu.web.controller.system.service.IFenleiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账单分类Service业务层处理
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Service
public class FenleiServiceImpl implements IFenleiService
{
    @Autowired
    private FenleiMapper fenleiMapper;

    /**
     * 查询账单分类
     *
     * @param id 账单分类主键
     * @return 账单分类
     */
    @Override
    public Fenlei selectFenleiById(Long id)
    {
        return fenleiMapper.selectFenleiById(id);
    }

    /**
     * 查询账单分类列表
     *
     * @param fenlei 账单分类
     * @return 账单分类
     */
    @Override
    public List<Fenlei> selectFenleiList(Fenlei fenlei)
    {
        return fenleiMapper.selectFenleiList(fenlei);
    }

    /**
     * 新增账单分类
     *
     * @param fenlei 账单分类
     * @return 结果
     */
    @Override
    public int insertFenlei(Fenlei fenlei)
    {
        return fenleiMapper.insertFenlei(fenlei);
    }

    /**
     * 修改账单分类
     *
     * @param fenlei 账单分类
     * @return 结果
     */
    @Override
    public int updateFenlei(Fenlei fenlei)
    {
        return fenleiMapper.updateFenlei(fenlei);
    }

    /**
     * 批量删除账单分类
     *
     * @param ids 需要删除的账单分类主键
     * @return 结果
     */
    @Override
    public int deleteFenleiByIds(Long[] ids)
    {
        return fenleiMapper.deleteFenleiByIds(ids);
    }

    /**
     * 删除账单分类信息
     *
     * @param id 账单分类主键
     * @return 结果
     */
    @Override
    public int deleteFenleiById(Long id)
    {
        return fenleiMapper.deleteFenleiById(id);
    }
}
