package com.gerencaiwu.web.controller.system.service;

import java.util.List;
import com.gerencaiwu.web.controller.system.domain.Shouru;

/**
 * 收入账单Service接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface IShouruService
{
    /**
     * 查询收入账单
     *
     * @param id 收入账单主键
     * @return 收入账单
     */
    public Shouru selectShouruById(Long id);

    /**
     * 查询收入账单列表
     *
     * @param shouru 收入账单
     * @return 收入账单集合
     */
    public List<Shouru> selectShouruList(Shouru shouru);

    /**
     * 新增收入账单
     *
     * @param shouru 收入账单
     * @return 结果
     */
    public int insertShouru(Shouru shouru);

    /**
     * 修改收入账单
     *
     * @param shouru 收入账单
     * @return 结果
     */
    public int updateShouru(Shouru shouru);

    /**
     * 批量删除收入账单
     *
     * @param ids 需要删除的收入账单主键集合
     * @return 结果
     */
    public int deleteShouruByIds(Long[] ids);

    /**
     * 删除收入账单信息
     *
     * @param id 收入账单主键
     * @return 结果
     */
    public int deleteShouruById(Long id);
}
