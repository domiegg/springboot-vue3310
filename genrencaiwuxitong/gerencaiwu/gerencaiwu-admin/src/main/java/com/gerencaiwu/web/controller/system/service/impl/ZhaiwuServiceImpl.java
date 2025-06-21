package com.gerencaiwu.web.controller.system.service.impl;

import java.util.Date;
import java.util.List;

import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Zhaiwu;
import com.gerencaiwu.web.controller.system.domain.Zhaiwulishi;
import com.gerencaiwu.web.controller.system.mapper.ZhaiwuMapper;
import com.gerencaiwu.web.controller.system.mapper.ZhaiwulishiMapper;
import com.gerencaiwu.web.controller.system.service.IZhaiwuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 债务列Service业务层处理
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Service
public class ZhaiwuServiceImpl implements IZhaiwuService
{
    @Autowired
    private ZhaiwuMapper zhaiwuMapper;

    @Autowired
    private ZhaiwulishiMapper zhaiwulishiMapper;

    /**
     * 查询债务列
     *
     * @param id 债务列主键
     * @return 债务列
     */
    @Override
    public Zhaiwu selectZhaiwuById(Long id)
    {
        return zhaiwuMapper.selectZhaiwuById(id);
    }

    /**
     * 查询债务列列表
     *
     * @param zhaiwu 债务列
     * @return 债务列
     */
    @Override
    public List<Zhaiwu> selectZhaiwuList(Zhaiwu zhaiwu)
    {
        return zhaiwuMapper.selectZhaiwuList(zhaiwu);
    }

    /**
     * 新增债务列
     *
     * @param zhaiwu 债务列
     * @return 结果
     */
    @Override
    public int insertZhaiwu(Zhaiwu zhaiwu)
    {
        return zhaiwuMapper.insertZhaiwu(zhaiwu);
    }

    /**
     * 修改债务列
     *
     * @param zhaiwu 债务列
     * @return 结果
     */
    @Override
    public int updateZhaiwu(Zhaiwu zhaiwu)
    {
        return zhaiwuMapper.updateZhaiwu(zhaiwu);
    }

    /**
     * 批量删除债务列
     *
     * @param ids 需要删除的债务列主键
     * @return 结果
     */
    @Override
    public int deleteZhaiwuByIds(Long[] ids)
    {
        return zhaiwuMapper.deleteZhaiwuByIds(ids);
    }

    /**
     * 删除债务列信息
     *
     * @param id 债务列主键
     * @return 结果
     */
    @Override
    public int deleteZhaiwuById(Long id)
    {
        return zhaiwuMapper.deleteZhaiwuById(id);
    }

    @Override
    public int changeZhaiwu(Zhaiwu zhaiwu) {
        //扣减债务
        zhaiwuMapper.costZhaiwu(zhaiwu);
        //新增历史
        Zhaiwulishi zhaiwulishi = new Zhaiwulishi();
        zhaiwulishi.setZhaiwuId(zhaiwu.getId());
        zhaiwulishi.setName(zhaiwu.getName());
        zhaiwulishi.setAmount(zhaiwu.getPayAmount());
        zhaiwulishi.setTime(new Date());
        zhaiwulishi.setType(zhaiwu.getType());
        zhaiwulishi.setUserId(SecurityUtils.getUserId());
        zhaiwulishiMapper.insertZhaiwulishi(zhaiwulishi);
        return 1;
    }
}
