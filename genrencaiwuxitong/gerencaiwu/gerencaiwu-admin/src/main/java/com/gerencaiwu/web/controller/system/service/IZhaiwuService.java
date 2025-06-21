package com.gerencaiwu.web.controller.system.service;

import java.util.List;
import com.gerencaiwu.web.controller.system.domain.Zhaiwu;

/**
 * 债务列Service接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface IZhaiwuService
{
    /**
     * 查询债务列
     *
     * @param id 债务列主键
     * @return 债务列
     */
    public Zhaiwu selectZhaiwuById(Long id);

    /**
     * 查询债务列列表
     *
     * @param zhaiwu 债务列
     * @return 债务列集合
     */
    public List<Zhaiwu> selectZhaiwuList(Zhaiwu zhaiwu);

    /**
     * 新增债务列
     *
     * @param zhaiwu 债务列
     * @return 结果
     */
    public int insertZhaiwu(Zhaiwu zhaiwu);

    /**
     * 修改债务列
     *
     * @param zhaiwu 债务列
     * @return 结果
     */
    public int updateZhaiwu(Zhaiwu zhaiwu);

    /**
     * 批量删除债务列
     *
     * @param ids 需要删除的债务列主键集合
     * @return 结果
     */
    public int deleteZhaiwuByIds(Long[] ids);

    /**
     * 删除债务列信息
     *
     * @param id 债务列主键
     * @return 结果
     */
    public int deleteZhaiwuById(Long id);

    int changeZhaiwu(Zhaiwu zhaiwu);
}
