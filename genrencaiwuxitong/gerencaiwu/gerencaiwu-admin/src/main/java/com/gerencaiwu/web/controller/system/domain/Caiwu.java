package com.gerencaiwu.web.controller.system.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Caiwu
 * @Description
 * @Date 2024/2/22 20:56
 * @Version 1.0
 */
@Data
public class Caiwu {
    private BigDecimal totalIncome;

    private BigDecimal totalExpense;

    private BigDecimal totalDebt;

    private List<String> fenleiList;

    private List<BigDecimal> shouruList;

    private List<Map<String, Object>> zhichuMap;
    private List<Map<String, Object>> zhaiwuMap;
}
