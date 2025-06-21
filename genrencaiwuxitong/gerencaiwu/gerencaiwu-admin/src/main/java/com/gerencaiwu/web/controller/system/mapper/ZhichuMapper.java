package com.gerencaiwu.web.controller.system.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.gerencaiwu.web.controller.system.domain.Zhichu;

/**
 * 支出账单Mapper接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface ZhichuMapper
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
     * 删除支出账单
     *
     * @param id 支出账单主键
     * @return 结果
     */
    public int deleteZhichuById(Long id);

    /**
     * 批量删除支出账单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZhichuByIds(Long[] ids);

    BigDecimal selectOldAmount(Integer typeId);
}
