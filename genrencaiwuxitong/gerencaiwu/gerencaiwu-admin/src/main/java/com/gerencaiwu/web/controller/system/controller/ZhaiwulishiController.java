package com.gerencaiwu.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gerencaiwu.common.core.domain.entity.SysUser;
import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Zhaiwulishi;
import com.gerencaiwu.web.controller.system.service.IZhaiwulishiService;
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
import com.gerencaiwu.common.utils.poi.ExcelUtil;
import com.gerencaiwu.common.core.page.TableDataInfo;

/**
 * 债务历史Controller
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@RestController
@RequestMapping("/system/zhaiwulishi")
public class ZhaiwulishiController extends BaseController
{
    @Autowired
    private IZhaiwulishiService zhaiwulishiService;

    /**
     * 查询债务历史列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwulishi:list')")
    @GetMapping("/list")
    public TableDataInfo list(Zhaiwulishi zhaiwulishi)
    {
        startPage();
        if (!SysUser.isAdmin(SecurityUtils.getUserId())){
            zhaiwulishi.setUserId(getUserId());
        }
        List<Zhaiwulishi> list = zhaiwulishiService.selectZhaiwulishiList(zhaiwulishi);
        return getDataTable(list);
    }

    /**
     * 导出债务历史列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwulishi:export')")
    @Log(title = "债务历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Zhaiwulishi zhaiwulishi)
    {
        List<Zhaiwulishi> list = zhaiwulishiService.selectZhaiwulishiList(zhaiwulishi);
        ExcelUtil<Zhaiwulishi> util = new ExcelUtil<Zhaiwulishi>(Zhaiwulishi.class);
        util.exportExcel(response, list, "债务历史数据");
    }

    /**
     * 获取债务历史详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwulishi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(zhaiwulishiService.selectZhaiwulishiById(id));
    }

    /**
     * 新增债务历史
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwulishi:add')")
    @Log(title = "债务历史", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Zhaiwulishi zhaiwulishi)
    {
        return toAjax(zhaiwulishiService.insertZhaiwulishi(zhaiwulishi));
    }

    /**
     * 修改债务历史
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwulishi:edit')")
    @Log(title = "债务历史", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Zhaiwulishi zhaiwulishi)
    {
        return toAjax(zhaiwulishiService.updateZhaiwulishi(zhaiwulishi));
    }

    /**
     * 删除债务历史
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwulishi:remove')")
    @Log(title = "债务历史", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhaiwulishiService.deleteZhaiwulishiByIds(ids));
    }
}
