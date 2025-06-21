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
 * 收入账单对象 a_shouru
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Data
public class Shouru extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 账单名称 */
    @Excel(name = "账单名称")
    private String name;

    /** 账单类型 */
    @Excel(name = "账单类型")
    private String type;

    /** 收入金额 */
    @Excel(name = "收入金额")
    private BigDecimal payAmount;

    /** 收入方式 */
    @Excel(name = "收入方式")
    private String payWay;

    /** 收入日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收入日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 用户id */
//    @Excel(name = "用户id")
    private Long userId;

    private Integer typeId;

    private Date timeStart;

    private Date timeEnd;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setPayAmount(BigDecimal payAmount)
    {
        this.payAmount = payAmount;
    }

    public BigDecimal getPayAmount()
    {
        return payAmount;
    }
    public void setPayWay(String payWay)
    {
        this.payWay = payWay;
    }

    public String getPayWay()
    {
        return payWay;
    }
    public void setTime(Date time)
    {
        this.time = time;
    }

    public Date getTime()
    {
        return time;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("payAmount", getPayAmount())
            .append("payWay", getPayWay())
            .append("time", getTime())
            .append("username", getUsername())
            .append("userId", getUserId())
            .append("remark", getRemark())
            .toString();
    }
}
