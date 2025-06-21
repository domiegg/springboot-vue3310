package com.gerencaiwu.web.controller.system.controller;

import com.gerencaiwu.common.annotation.Log;
import com.gerencaiwu.common.core.controller.BaseController;
import com.gerencaiwu.common.core.domain.AjaxResult;
import com.gerencaiwu.common.core.page.TableDataInfo;
import com.gerencaiwu.common.enums.BusinessType;
import com.gerencaiwu.common.utils.poi.ExcelUtil;
import com.gerencaiwu.web.controller.system.domain.Fenlei;
import com.gerencaiwu.web.controller.system.service.ICaiwuService;
import com.gerencaiwu.web.controller.system.service.IFenleiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 账单分类Controller
 *
 * @author gerencaiwu
 * @date 2024-02-21
 */
@RestController
@RequestMapping("/system/caiwu")
public class CaiwuController extends BaseController
{

    @Autowired
    ICaiwuService caiwuService;


    @PostMapping("total")
    public AjaxResult total()
    {
        return success(caiwuService.getTotal());
    }

    @PostMapping("gettongji")
    public AjaxResult gettongji()
    {
        return success(caiwuService.gettongji());
    }

}
