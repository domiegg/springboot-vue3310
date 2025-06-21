package com.gerencaiwu.web.controller.system.service;

import java.util.List;
import java.util.Map;

import com.gerencaiwu.web.controller.system.domain.Zhichu;

/**
 * 支出账单Service接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface IZhichuService
{
    /**
     * 查询支出账单
     *
     * @param id 支出账单主键
     * @return 支出账单
     */
    public Zhichu selectZhichuById(Long id);

    /**
     * 查询支出账单列表
     *
     * @param zhichu 支出账单
     * @return 支出账单集合
     */
    public List<Zhichu> selectZhichuList(Zhichu zhichu);

    /**
     * 新增支出账单
     *
     * @param zhichu 支出账单
     * @return 结果
     */
    public int insertZhichu(Zhichu zhichu);

    /**
     * 修改支出账单
     *
     * @param zhichu 支出账单
     * @return 结果
     */
    public int updateZhichu(Zhichu zhichu);

    /**
     * 批量删除支出账单
     *
     * @param ids 需要删除的支出账单主键集合
     * @return 结果
     */
    public int deleteZhichuByIds(Long[] ids);

    /**
     * 删除支出账单信息
     *
     * @param id 支出账单主键
     * @return 结果
     */
    public int deleteZhichuById(Long id);

    Map<String,Object> checkBudget(Zhichu zhichu);
}
