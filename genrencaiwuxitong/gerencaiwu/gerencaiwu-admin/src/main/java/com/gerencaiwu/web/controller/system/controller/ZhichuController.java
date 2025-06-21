package com.gerencaiwu.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gerencaiwu.common.core.domain.entity.SysUser;
import com.gerencaiwu.common.core.domain.model.LoginUser;
import com.gerencaiwu.common.utils.SecurityUtils;
import com.gerencaiwu.web.controller.system.domain.Zhichu;
import com.gerencaiwu.web.controller.system.service.IZhichuService;
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
 * 支出账单Controller
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@RestController
@RequestMapping("/system/zhichu")
public class ZhichuController extends BaseController
{
    @Autowired
    private IZhichuService zhichuService;

    /**
     * 查询支出账单列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhichu:list')")
    @GetMapping("/list")
    public TableDataInfo list(Zhichu zhichu)
    {
        startPage();
        if (!SysUser.isAdmin(SecurityUtils.getUserId())){
            zhichu.setUserId(getUserId());
        }
        List<Zhichu> list = zhichuService.selectZhichuList(zhichu);
        return getDataTable(list);
    }

    /**
     * 导出支出账单列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhichu:export')")
    @Log(title = "支出账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Zhichu zhichu)
    {
        if (!SysUser.isAdmin(SecurityUtils.getUserId())){
            zhichu.setUserId(getUserId());
        }
        List<Zhichu> list = zhichuService.selectZhichuList(zhichu);
        ExcelUtil<Zhichu> util = new ExcelUtil<Zhichu>(Zhichu.class);
        util.exportExcel(response, list, "支出账单数据");
    }

    /**
     * 获取支出账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zhichu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {

        return success(zhichuService.selectZhichuById(id));
    }

    /**
     * 新增支出账单
     */
    @PreAuthorize("@ss.hasPermi('system:zhichu:add')")
    @Log(title = "支出账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Zhichu zhichu)
    {
        zhichu.setUserId(getUserId());
        return toAjax(zhichuService.insertZhichu(zhichu));
    }

    @PostMapping("/checkBudget")
    public AjaxResult checkBudget(@RequestBody Zhichu zhichu)
    {
        zhichu.setUserId(getUserId());
        return success(zhichuService.checkBudget(zhichu));
    }

    /**
     * 修改支出账单
     */
    @PreAuthorize("@ss.hasPermi('system:zhichu:edit')")
    @Log(title = "支出账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Zhichu zhichu)
    {
        zhichu.setUserId(getUserId());
        return toAjax(zhichuService.updateZhichu(zhichu));
    }

    /**
     * 删除支出账单
     */
    @PreAuthorize("@ss.hasPermi('system:zhichu:remove')")
    @Log(title = "支出账单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhichuService.deleteZhichuByIds(ids));
    }
}
