package com.lian.xhs.controller;


import com.lian.xhs.entity.TCategory;
import com.lian.xhs.result.Result;
import com.lian.xhs.service.TCategoryService;
import com.lian.xhs.utils.ConvertUtils;
import com.lian.xhs.utils.TreeUtils;
import com.lian.xhs.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alex wong
 * @since 2024-03-12
 */
@RestController
@RequestMapping("/api/category")
public class TCategoryController {

    @Autowired
    private TCategoryService tCategoryService;

    @GetMapping("getCategoryTreeData")
    public Result<?> getCategoryTreeData(){

        List<TCategory> categories = tCategoryService.getCategoryTreeData();
        List<CategoryVo> categoryVos = ConvertUtils.sourceToTarget(categories, CategoryVo.class);
        List<CategoryVo> treeData = TreeUtils.build(categoryVos);
        return Result.ok(treeData);
    }



}

