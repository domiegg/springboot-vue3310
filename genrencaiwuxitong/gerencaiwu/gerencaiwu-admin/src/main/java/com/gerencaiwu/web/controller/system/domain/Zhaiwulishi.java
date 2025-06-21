package com.gerencaiwu.web.controller.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gerencaiwu.common.annotation.Excel;
import com.gerencaiwu.common.core.domain.BaseEntity;

/**
 * 债务历史对象 a_zhaiwulishi
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Data
public class Zhaiwulishi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    private String name;

    /** 债务id */
    @Excel(name = "债务id")
    private Long zhaiwuId;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    private Date timeStart;

    private Date timeEnd;

    private Long userId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setZhaiwuId(Long zhaiwuId)
    {
        this.zhaiwuId = zhaiwuId;
    }

    public Long getZhaiwuId()
    {
        return zhaiwuId;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setTime(Date time)
    {
        this.time = time;
    }

    public Date getTime()
    {
        return time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("zhaiwuId", getZhaiwuId())
            .append("amount", getAmount())
            .append("type", getType())
            .append("time", getTime())
            .toString();
    }
}
