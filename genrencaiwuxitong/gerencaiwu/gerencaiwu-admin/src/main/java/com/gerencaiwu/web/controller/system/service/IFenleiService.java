package com.gerencaiwu.web.controller.system.service;

import java.util.List;
import com.gerencaiwu.web.controller.system.domain.Fenlei;

/**
 * 账单分类Service接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface IFenleiService
{
    /**
     * 查询账单分类
     *
     * @param id 账单分类主键
     * @return 账单分类
     */
    public Fenlei selectFenleiById(Long id);

    /**
     * 查询账单分类列表
     *
     * @param fenlei 账单分类
     * @return 账单分类集合
     */
    public List<Fenlei> selectFenleiList(Fenlei fenlei);

    /**
     * 新增账单分类
     *
     * @param fenlei 账单分类
     * @return 结果
     */
    public int insertFenlei(Fenlei fenlei);

    /**
     * 修改账单分类
     *
     * @param fenlei 账单分类
     * @return 结果
     */
    public int updateFenlei(Fenlei fenlei);

    /**
     * 批量删除账单分类
     *
     * @param ids 需要删除的账单分类主键集合
     * @return 结果
     */
    public int deleteFenleiByIds(Long[] ids);

    /**
     * 删除账单分类信息
     *
     * @param id 账单分类主键
     * @return 结果
     */
    public int deleteFenleiById(Long id);
}
