package com.gerencaiwu.web.controller.system.service.impl;

import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Caiwu;
import com.gerencaiwu.web.controller.system.domain.Fenlei;
import com.gerencaiwu.web.controller.system.domain.Zhichu;
import com.gerencaiwu.web.controller.system.mapper.CaiwuMapper;
import com.gerencaiwu.web.controller.system.mapper.FenleiMapper;
import com.gerencaiwu.web.controller.system.service.ICaiwuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 账单分类Service业务层处理
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Service
public class CaiwuServiceImpl implements ICaiwuService
{
    @Autowired
    private CaiwuMapper caiwuMapper;

    @Autowired
    private FenleiMapper fenleiMapper;
    @Override
    public Caiwu getTotal() {
        Long userId = SecurityUtils.getUserId();
        BigDecimal totalIncome = caiwuMapper.getTotalIncome(userId);
        BigDecimal totalExpense = caiwuMapper.getTotalExpense(userId);
        BigDecimal totalDebt = caiwuMapper.getTotalDebt(userId);
        Caiwu caiwu = new Caiwu();
        caiwu.setTotalDebt(totalDebt);
        caiwu.setTotalIncome(totalIncome);
        caiwu.setTotalExpense(totalExpense);
        return caiwu;
    }

    @Override
    public Caiwu gettongji() {
        Caiwu caiwu = new Caiwu();
        Long userId = SecurityUtils.getUserId();
        Fenlei fenlei1 = new Fenlei();
        fenlei1.setUserId(SecurityUtils.getUserId());
        List<Fenlei> fenleiList = fenleiMapper.selectFenleiList(fenlei1);
        List<String> fenleiNames = new ArrayList<>();
        //根据分类查对应的收入
        List<BigDecimal> shouruList = new ArrayList<>();
        for (Fenlei fenlei : fenleiList) {
            Long fenleiId = fenlei.getId();
            String fenleiName = fenlei.getName();
            fenleiNames.add(fenleiName);
            BigDecimal shouru = caiwuMapper.selectShouru(fenleiId,userId);
            if (shouru == null) shouru = BigDecimal.ZERO;
            shouruList.add(shouru);
        }

        caiwu.setFenleiList(fenleiNames);
        caiwu.setShouruList(shouruList);

        //统计支出
        List<Map<String, Object>> zhichu = caiwuMapper.selectZhichu(userId);

        caiwu.setZhichuMap(zhichu);

        //统计债务
        List<Map<String, Object>> zhaiwu = caiwuMapper.selectZhaiwu(userId);
        caiwu.setZhaiwuMap(zhaiwu);
        return caiwu;
    }

}
