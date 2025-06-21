package com.gerencaiwu.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gerencaiwu.common.core.domain.entity.SysUser;
import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Zhaiwu;
import com.gerencaiwu.web.controller.system.service.IZhaiwuService;
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
 * 债务列Controller
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@RestController
@RequestMapping("/system/zhaiwu")
public class ZhaiwuController extends BaseController
{
    @Autowired
    private IZhaiwuService zhaiwuService;

    /**
     * 查询债务列列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwu:list')")
    @GetMapping("/list")
    public TableDataInfo list(Zhaiwu zhaiwu)
    {
        startPage();
        if (!SysUser.isAdmin(SecurityUtils.getUserId())){
            zhaiwu.setUserId(getUserId());
        }
        List<Zhaiwu> list = zhaiwuService.selectZhaiwuList(zhaiwu);
        return getDataTable(list);
    }

    /**
     * 导出债务列列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwu:export')")
    @Log(title = "债务列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Zhaiwu zhaiwu)
    {
        if (!SysUser.isAdmin(SecurityUtils.getUserId())){
            zhaiwu.setUserId(getUserId());
        }
        List<Zhaiwu> list = zhaiwuService.selectZhaiwuList(zhaiwu);
        ExcelUtil<Zhaiwu> util = new ExcelUtil<Zhaiwu>(Zhaiwu.class);
        util.exportExcel(response, list, "债务列数据");
    }

    /**
     * 获取债务列详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(zhaiwuService.selectZhaiwuById(id));
    }

    /**
     * 新增债务列
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwu:add')")
    @Log(title = "债务列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Zhaiwu zhaiwu)
    {
        zhaiwu.setUserId(getUserId());
        return toAjax(zhaiwuService.insertZhaiwu(zhaiwu));
    }

    @Log(title = "债务列", businessType = BusinessType.INSERT)
    @PostMapping("/changeZhaiwu")
    public AjaxResult change(@RequestBody Zhaiwu zhaiwu)
    {
        zhaiwu.setUserId(getUserId());
        return toAjax(zhaiwuService.changeZhaiwu(zhaiwu));
    }

    /**
     * 修改债务列
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwu:edit')")
    @Log(title = "债务列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Zhaiwu zhaiwu)
    {
        zhaiwu.setUserId(getUserId());
        return toAjax(zhaiwuService.updateZhaiwu(zhaiwu));
    }

    /**
     * 删除债务列
     */
    @PreAuthorize("@ss.hasPermi('system:zhaiwu:remove')")
    @Log(title = "债务列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhaiwuService.deleteZhaiwuByIds(ids));
    }
}
