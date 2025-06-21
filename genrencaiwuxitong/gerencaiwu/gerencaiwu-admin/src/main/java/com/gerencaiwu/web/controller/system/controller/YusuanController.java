package com.gerencaiwu.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gerencaiwu.common.core.domain.entity.SysUser;
import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Yusuan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gerencaiwu.common.annotation.Log;
import com.gerencaiwu.common.core.controller.BaseController;
import com.gerencaiwu.common.core.domain.AjaxResult;
import com.gerencaiwu.common.enums.BusinessType;
import com.gerencaiwu.web.controller.system.service.IYusuanService;
import com.gerencaiwu.common.utils.poi.ExcelUtil;
import com.gerencaiwu.common.core.page.TableDataInfo;

/**
 * 预算管理Controller
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@RestController
@RequestMapping("/system/yusuan")
public class YusuanController extends BaseController
{
    @Autowired
    private IYusuanService yusuanService;

    /**
     * 查询预算管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:yusuan:list')")
    @GetMapping("/list")
    public TableDataInfo list(Yusuan yusuan)
    {
        startPage();
        if (!SysUser.isAdmin(SecurityUtils.getUserId())){
            yusuan.setUserId(getUserId());
        }
        List<Yusuan> list = yusuanService.selectYusuanList(yusuan);
        return getDataTable(list);
    }

    /**
     * 导出预算管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:yusuan:export')")
    @Log(title = "预算管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Yusuan yusuan)
    {
        List<Yusuan> list = yusuanService.selectYusuanList(yusuan);
        ExcelUtil<Yusuan> util = new ExcelUtil<Yusuan>(Yusuan.class);
        util.exportExcel(response, list, "预算管理数据");
    }

    /**
     * 获取预算管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:yusuan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(yusuanService.selectYusuanById(id));
    }

    /**
     * 新增预算管理
     */
    @PreAuthorize("@ss.hasPermi('system:yusuan:add')")
    @Log(title = "预算管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Yusuan yusuan)
    {
        yusuan.setUserId(getUserId());
        return toAjax(yusuanService.insertYusuan(yusuan));
    }

    /**
     * 修改预算管理
     */
    @PreAuthorize("@ss.hasPermi('system:yusuan:edit')")
    @Log(title = "预算管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Yusuan yusuan)
    {
        yusuan.setUserId(getUserId());
        return toAjax(yusuanService.updateYusuan(yusuan));
    }

    /**
     * 删除预算管理
     */
    @PreAuthorize("@ss.hasPermi('system:yusuan:remove')")
    @Log(title = "预算管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(yusuanService.deleteYusuanByIds(ids));
    }
}
