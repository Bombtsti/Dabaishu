package com.lian.xhs.service;

import com.lian.xhs.entity.TCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alex wong
 * @since 2024-03-12
 */
public interface TCategoryService extends IService<TCategory> {

    ArrayList<TCategory> getCategoryTreeData();

}
