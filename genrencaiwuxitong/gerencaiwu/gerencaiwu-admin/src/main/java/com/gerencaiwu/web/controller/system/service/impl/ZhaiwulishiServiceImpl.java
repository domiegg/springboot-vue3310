package com.gerencaiwu.web.controller.system.service.impl;

import java.util.List;

import com.gerencaiwu.web.controller.system.domain.Zhaiwulishi;
import com.gerencaiwu.web.controller.system.mapper.ZhaiwulishiMapper;
import com.gerencaiwu.web.controller.system.service.IZhaiwulishiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 债务历史Service业务层处理
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Service
public class ZhaiwulishiServiceImpl implements IZhaiwulishiService
{
    @Autowired
    private ZhaiwulishiMapper zhaiwulishiMapper;

    /**
     * 查询债务历史
     *
     * @param id 债务历史主键
     * @return 债务历史
     */
    @Override
    public Zhaiwulishi selectZhaiwulishiById(Long id)
    {
        return zhaiwulishiMapper.selectZhaiwulishiById(id);
    }

    /**
     * 查询债务历史列表
     *
     * @param zhaiwulishi 债务历史
     * @return 债务历史
     */
    @Override
    public List<Zhaiwulishi> selectZhaiwulishiList(Zhaiwulishi zhaiwulishi)
    {
        return zhaiwulishiMapper.selectZhaiwulishiList(zhaiwulishi);
    }

    /**
     * 新增债务历史
     *
     * @param zhaiwulishi 债务历史
     * @return 结果
     */
    @Override
    public int insertZhaiwulishi(Zhaiwulishi zhaiwulishi)
    {
        return zhaiwulishiMapper.insertZhaiwulishi(zhaiwulishi);
    }

    /**
     * 修改债务历史
     *
     * @param zhaiwulishi 债务历史
     * @return 结果
     */
    @Override
    public int updateZhaiwulishi(Zhaiwulishi zhaiwulishi)
    {
        return zhaiwulishiMapper.updateZhaiwulishi(zhaiwulishi);
    }

    /**
     * 批量删除债务历史
     *
     * @param ids 需要删除的债务历史主键
     * @return 结果
     */
    @Override
    public int deleteZhaiwulishiByIds(Long[] ids)
    {
        return zhaiwulishiMapper.deleteZhaiwulishiByIds(ids);
    }

    /**
     * 删除债务历史信息
     *
     * @param id 债务历史主键
     * @return 结果
     */
    @Override
    public int deleteZhaiwulishiById(Long id)
    {
        return zhaiwulishiMapper.deleteZhaiwulishiById(id);
    }
}
