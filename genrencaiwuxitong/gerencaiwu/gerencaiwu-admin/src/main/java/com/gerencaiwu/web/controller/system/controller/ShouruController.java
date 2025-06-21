package com.gerencaiwu.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gerencaiwu.common.core.domain.entity.SysUser;
import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Shouru;
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
import com.gerencaiwu.web.controller.system.service.IShouruService;
import com.gerencaiwu.common.utils.poi.ExcelUtil;
import com.gerencaiwu.common.core.page.TableDataInfo;

/**
 * 收入账单Controller
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@RestController
@RequestMapping("/system/shouru")
public class ShouruController extends BaseController
{
    @Autowired
    private IShouruService shouruService;

    /**
     * 查询收入账单列表
     */
    @PreAuthorize("@ss.hasPermi('system:shouru:list')")
    @GetMapping("/list")
    public TableDataInfo list(Shouru shouru)
    {
        startPage();
        if (!SysUser.isAdmin(SecurityUtils.getUserId())){
            shouru.setUserId(getUserId());
        }
        List<Shouru> list = shouruService.selectShouruList(shouru);
        return getDataTable(list);
    }

    /**
     * 导出收入账单列表
     */
    @PreAuthorize("@ss.hasPermi('system:shouru:export')")
    @Log(title = "收入账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Shouru shouru)
    {
        if (!SysUser.isAdmin(SecurityUtils.getUserId())){
            shouru.setUserId(getUserId());
        }
        List<Shouru> list = shouruService.selectShouruList(shouru);
        ExcelUtil<Shouru> util = new ExcelUtil<Shouru>(Shouru.class);
        util.exportExcel(response, list, "收入账单数据");
    }

    /**
     * 获取收入账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:shouru:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(shouruService.selectShouruById(id));
    }

    /**
     * 新增收入账单
     */
    @PreAuthorize("@ss.hasPermi('system:shouru:add')")
    @Log(title = "收入账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Shouru shouru)
    {
        return toAjax(shouruService.insertShouru(shouru));
    }

    /**
     * 修改收入账单
     */
    @PreAuthorize("@ss.hasPermi('system:shouru:edit')")
    @Log(title = "收入账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Shouru shouru)
    {
        return toAjax(shouruService.updateShouru(shouru));
    }

    /**
     * 删除收入账单
     */
    @PreAuthorize("@ss.hasPermi('system:shouru:remove')")
    @Log(title = "收入账单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(shouruService.deleteShouruByIds(ids));
    }
}
