package com.gerencaiwu.web.controller.system.mapper;

import java.util.List;
import com.gerencaiwu.web.controller.system.domain.Fenlei;

/**
 * 账单分类Mapper接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface FenleiMapper
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
     * 删除账单分类
     *
     * @param id 账单分类主键
     * @return 结果
     */
    public int deleteFenleiById(Long id);

    /**
     * 批量删除账单分类
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFenleiByIds(Long[] ids);
}
