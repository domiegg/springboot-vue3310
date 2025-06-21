package com.gerencaiwu.web.controller.system.service.impl;

import java.util.List;

import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Yusuan;
import com.gerencaiwu.web.controller.system.mapper.YusuanMapper;
import com.gerencaiwu.web.controller.system.service.IYusuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 预算管理Service业务层处理
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@Service
public class YusuanServiceImpl implements IYusuanService
{
    @Autowired
    private YusuanMapper yusuanMapper;

    /**
     * 查询预算管理
     *
     * @param id 预算管理主键
     * @return 预算管理
     */
    @Override
    public Yusuan selectYusuanById(Long id)
    {
        return yusuanMapper.selectYusuanById(id);
    }

    /**
     * 查询预算管理列表
     *
     * @param yusuan 预算管理
     * @return 预算管理
     */
    @Override
    public List<Yusuan> selectYusuanList(Yusuan yusuan)
    {
        return yusuanMapper.selectYusuanList(yusuan);
    }

    /**
     * 新增预算管理
     *
     * @param yusuan 预算管理
     * @return 结果
     */
    @Override
    public int insertYusuan(Yusuan yusuan)
    {
        return yusuanMapper.insertYusuan(yusuan);
    }

    /**
     * 修改预算管理
     *
     * @param yusuan 预算管理
     * @return 结果
     */
    @Override
    public int updateYusuan(Yusuan yusuan)
    {
        yusuan.setId(yusuan.getTypeId());
        Yusuan yusuan1 = yusuanMapper.selectyusuan(yusuan.getId(), SecurityUtils.getUserId());
        if (yusuan1 != null){
            return yusuanMapper.updateYusuan(yusuan);
        }else{
            return yusuanMapper.insertYusuan(yusuan);
        }

    }

    /**
     * 批量删除预算管理
     *
     * @param ids 需要删除的预算管理主键
     * @return 结果
     */
    @Override
    public int deleteYusuanByIds(Long[] ids)
    {
        return yusuanMapper.deleteYusuanByIds(ids);
    }

    /**
     * 删除预算管理信息
     *
     * @param id 预算管理主键
     * @return 结果
     */
    @Override
    public int deleteYusuanById(Long id)
    {
        return yusuanMapper.deleteYusuanById(id);
    }
}
