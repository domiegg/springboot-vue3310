package com.gerencaiwu.web.controller.system.mapper;

import java.util.List;
import com.gerencaiwu.web.controller.system.domain.Zhaiwulishi;

/**
 * 债务历史Mapper接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface ZhaiwulishiMapper
{
    /**
     * 查询债务历史
     *
     * @param id 债务历史主键
     * @return 债务历史
     */
    public Zhaiwulishi selectZhaiwulishiById(Long id);

    /**
     * 查询债务历史列表
     *
     * @param zhaiwulishi 债务历史
     * @return 债务历史集合
     */
    public List<Zhaiwulishi> selectZhaiwulishiList(Zhaiwulishi zhaiwulishi);

    /**
     * 新增债务历史
     *
     * @param zhaiwulishi 债务历史
     * @return 结果
     */
    public int insertZhaiwulishi(Zhaiwulishi zhaiwulishi);

    /**
     * 修改债务历史
     *
     * @param zhaiwulishi 债务历史
     * @return 结果
     */
    public int updateZhaiwulishi(Zhaiwulishi zhaiwulishi);

    /**
     * 删除债务历史
     *
     * @param id 债务历史主键
     * @return 结果
     */
    public int deleteZhaiwulishiById(Long id);

    /**
     * 批量删除债务历史
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZhaiwulishiByIds(Long[] ids);
}
