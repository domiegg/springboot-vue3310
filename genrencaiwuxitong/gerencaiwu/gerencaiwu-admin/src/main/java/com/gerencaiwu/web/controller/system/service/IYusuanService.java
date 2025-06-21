package com.gerencaiwu.web.controller.system.service;

import java.util.List;
import com.gerencaiwu.web.controller.system.domain.Yusuan;

/**
 * 预算管理Service接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface IYusuanService
{
    /**
     * 查询预算管理
     *
     * @param id 预算管理主键
     * @return 预算管理
     */
    public Yusuan selectYusuanById(Long id);

    /**
     * 查询预算管理列表
     *
     * @param yusuan 预算管理
     * @return 预算管理集合
     */
    public List<Yusuan> selectYusuanList(Yusuan yusuan);

    /**
     * 新增预算管理
     *
     * @param yusuan 预算管理
     * @return 结果
     */
    public int insertYusuan(Yusuan yusuan);

    /**
     * 修改预算管理
     *
     * @param yusuan 预算管理
     * @return 结果
     */
    public int updateYusuan(Yusuan yusuan);

    /**
     * 批量删除预算管理
     *
     * @param ids 需要删除的预算管理主键集合
     * @return 结果
     */
    public int deleteYusuanByIds(Long[] ids);

    /**
     * 删除预算管理信息
     *
     * @param id 预算管理主键
     * @return 结果
     */
    public int deleteYusuanById(Long id);
}
