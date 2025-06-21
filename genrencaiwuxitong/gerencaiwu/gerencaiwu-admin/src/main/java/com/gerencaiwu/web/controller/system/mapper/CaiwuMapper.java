package com.gerencaiwu.web.controller.system.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 账单分类Mapper接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface CaiwuMapper
{

    BigDecimal getTotalIncome(Long userId);
    BigDecimal getTotalExpense(Long userId);
    BigDecimal getTotalDebt(Long userId);

    BigDecimal selectShouru(@Param("fenleiId") Long fenleiId, @Param("userId") Long userId);

    List<Map<String, Object>> selectZhichu(Long userId);

    List<Map<String, Object>> selectZhaiwu(Long userId);
}
