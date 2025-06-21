package com.gerencaiwu.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gerencaiwu.web.controller.system.domain.Fenlei;
import com.gerencaiwu.web.controller.system.service.IFenleiService;
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
 * 账单分类Controller
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@RestController
@RequestMapping("/system/fenlei")
public class FenleiController extends BaseController
{
    @Autowired
    private IFenleiService fenleiService;

    /**
     * 查询账单分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:fenlei:list')")
    @GetMapping("/list")
    public TableDataInfo list(Fenlei fenlei)
    {
        startPage();
        fenlei.setUserId(getUserId());
        List<Fenlei> list = fenleiService.selectFenleiList(fenlei);
        return getDataTable(list);
    }

    /**
     * 导出账单分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:fenlei:export')")
    @Log(title = "账单分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Fenlei fenlei)
    {
        List<Fenlei> list = fenleiService.selectFenleiList(fenlei);
        ExcelUtil<Fenlei> util = new ExcelUtil<Fenlei>(Fenlei.class);
        util.exportExcel(response, list, "账单分类数据");
    }

    /**
     * 获取账单分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:fenlei:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fenleiService.selectFenleiById(id));
    }

    /**
     * 新增账单分类
     */
    @PreAuthorize("@ss.hasPermi('system:fenlei:add')")
    @Log(title = "账单分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Fenlei fenlei)
    {
        fenlei.setUserId(getUserId());
        return toAjax(fenleiService.insertFenlei(fenlei));
    }

    /**
     * 修改账单分类
     */
    @PreAuthorize("@ss.hasPermi('system:fenlei:edit')")
    @Log(title = "账单分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Fenlei fenlei)
    {
        fenlei.setUserId(getUserId());
        return toAjax(fenleiService.updateFenlei(fenlei));
    }

    /**
     * 删除账单分类
     */
    @PreAuthorize("@ss.hasPermi('system:fenlei:remove')")
    @Log(title = "账单分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fenleiService.deleteFenleiByIds(ids));
    }
}
