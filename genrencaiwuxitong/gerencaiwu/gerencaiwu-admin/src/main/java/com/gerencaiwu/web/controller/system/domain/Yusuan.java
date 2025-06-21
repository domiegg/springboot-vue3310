package com.gerencaiwu.web.controller.system.domain;

import java.math.BigDecimal;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gerencaiwu.common.annotation.Excel;
import com.gerencaiwu.common.core.domain.BaseEntity;

/**
 * 预算管理对象 a_yusuan
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Data
public class Yusuan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 分类id */
    @Excel(name = "分类id")
    private Long typeId;

    /** 预算金额 */
    @Excel(name = "预算金额")
    private BigDecimal amount;

    private String typeName;

    private Long userId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTypeId(Long typeId)
    {
        this.typeId = typeId;
    }

    public Long getTypeId()
    {
        return typeId;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeId", getTypeId())
            .append("amount", getAmount())
            .toString();
    }
}
