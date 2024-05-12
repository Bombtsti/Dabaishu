package com.lian.xhs.service.impl;

import com.lian.xhs.entity.TCategory;
import com.lian.xhs.mapper.TCategoryMapper;
import com.lian.xhs.service.TCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alex wong
 * @since 2024-03-12
 */
@Service
public class TCategoryServiceImpl extends ServiceImpl<TCategoryMapper, TCategory> implements TCategoryService {

    @Autowired
    private TCategoryMapper tCategoryMapper;

    @Override
    public ArrayList<TCategory> getCategoryTreeData() {
        return tCategoryMapper.getCategoryTreeData();
    }
}
