package com.gerencaiwu.web.controller.system.mapper;

import java.util.List;
import com.gerencaiwu.web.controller.system.domain.Yusuan;
import org.apache.ibatis.annotations.Param;

/**
 * 预算管理Mapper接口
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
public interface YusuanMapper
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
     * 删除预算管理
     *
     * @param id 预算管理主键
     * @return 结果
     */
    public int deleteYusuanById(Long id);

    /**
     * 批量删除预算管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYusuanByIds(Long[] ids);

    Yusuan selectyusuan(@Param("id") Long id, @Param("userId") Long userId);
}
