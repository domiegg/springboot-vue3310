package com.gerencaiwu.web.controller.system.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gerencaiwu.web.controller.system.domain.Yusuan;
import com.gerencaiwu.web.controller.system.domain.Zhichu;
import com.gerencaiwu.web.controller.system.mapper.YusuanMapper;
import com.gerencaiwu.web.controller.system.mapper.ZhichuMapper;
import com.gerencaiwu.web.controller.system.service.IZhichuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支出账单Service业务层处理
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Service
public class ZhichuServiceImpl implements IZhichuService
{
    @Autowired
    private ZhichuMapper zhichuMapper;

    @Autowired
    private YusuanMapper yusuanMapper;



    /**
     * 查询支出账单
     *
     * @param id 支出账单主键
     * @return 支出账单
     */
    @Override
    public Zhichu selectZhichuById(Long id)
    {
        return zhichuMapper.selectZhichuById(id);
    }

    /**
     * 查询支出账单列表
     *
     * @param zhichu 支出账单
     * @return 支出账单
     */
    @Override
    public List<Zhichu> selectZhichuList(Zhichu zhichu)
    {
        return zhichuMapper.selectZhichuList(zhichu);
    }

    /**
     * 新增支出账单
     *
     * @param zhichu 支出账单
     * @return 结果
     */
    @Override
    public int insertZhichu(Zhichu zhichu)
    {
        return zhichuMapper.insertZhichu(zhichu);
    }

    /**
     * 修改支出账单
     *
     * @param zhichu 支出账单
     * @return 结果
     */
    @Override
    public int updateZhichu(Zhichu zhichu)
    {
        return zhichuMapper.updateZhichu(zhichu);
    }

    /**
     * 批量删除支出账单
     *
     * @param ids 需要删除的支出账单主键
     * @return 结果
     */
    @Override
    public int deleteZhichuByIds(Long[] ids)
    {
        return zhichuMapper.deleteZhichuByIds(ids);
    }

    /**
     * 删除支出账单信息
     *
     * @param id 支出账单主键
     * @return 结果
     */
    @Override
    public int deleteZhichuById(Long id)
    {
        return zhichuMapper.deleteZhichuById(id);
    }

    @Override
    public Map<String, Object> checkBudget(Zhichu zhichu) {
        boolean isOverBudget = false;
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("isOverBudget",isOverBudget);
        Integer typeId = zhichu.getTypeId();
        if (typeId == null) return resultMap;
        //根据typeId查预算
        Yusuan selectyusuan = yusuanMapper.selectyusuan(Long.parseLong(typeId.toString()),zhichu.getUserId());
        if (selectyusuan == null) return resultMap;
        BigDecimal amount = selectyusuan.getAmount();
        if (BigDecimal.ZERO.compareTo(amount) == 0) return resultMap;
        //查出该分类的历史金额
        BigDecimal oldAmount = zhichuMapper.selectOldAmount(typeId);
        if (oldAmount == null) oldAmount = BigDecimal.ZERO;
        BigDecimal payAmount = zhichu.getPayAmount();
        if (payAmount == null) payAmount = BigDecimal.ZERO;
        BigDecimal totalAmount = payAmount.add(oldAmount);
        if (totalAmount.compareTo(amount) > 0) {
            isOverBudget = true;
        }
        resultMap.put("isOverBudget",isOverBudget);
        return resultMap;
    }
}
