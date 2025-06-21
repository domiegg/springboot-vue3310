package com.gerencaiwu.web.controller.system.service.impl;

import java.util.List;

import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Fenlei;
import com.gerencaiwu.web.controller.system.domain.Shouru;
import com.gerencaiwu.web.controller.system.mapper.FenleiMapper;
import com.gerencaiwu.web.controller.system.mapper.ShouruMapper;
import com.gerencaiwu.web.controller.system.service.IShouruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 收入账单Service业务层处理
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Service
public class ShouruServiceImpl implements IShouruService
{
    @Autowired
    private ShouruMapper shouruMapper;

    @Autowired
    private FenleiMapper fenleiMapper;

    /**
     * 查询收入账单
     *
     * @param id 收入账单主键
     * @return 收入账单
     */
    @Override
    public Shouru selectShouruById(Long id)
    {
        return shouruMapper.selectShouruById(id);
    }

    /**
     * 查询收入账单列表
     *
     * @param shouru 收入账单
     * @return 收入账单
     */
    @Override
    public List<Shouru> selectShouruList(Shouru shouru)
    {
        return shouruMapper.selectShouruList(shouru);
    }

    /**
     * 新增收入账单
     *
     * @param shouru 收入账单
     * @return 结果
     */
    @Override
    public int insertShouru(Shouru shouru)
    {
        Long userId = SecurityUtils.getUserId();
        shouru.setUserId(userId);
        return shouruMapper.insertShouru(shouru);
    }

    /**
     * 修改收入账单
     *
     * @param shouru 收入账单
     * @return 结果
     */
    @Override
    public int updateShouru(Shouru shouru)
    {
        Long userId = SecurityUtils.getUserId();
        shouru.setUserId(userId);
        return shouruMapper.updateShouru(shouru);
    }

    /**
     * 批量删除收入账单
     *
     * @param ids 需要删除的收入账单主键
     * @return 结果
     */
    @Override
    public int deleteShouruByIds(Long[] ids)
    {
        return shouruMapper.deleteShouruByIds(ids);
    }

    /**
     * 删除收入账单信息
     *
     * @param id 收入账单主键
     * @return 结果
     */
    @Override
    public int deleteShouruById(Long id)
    {
        return shouruMapper.deleteShouruById(id);
    }
}
