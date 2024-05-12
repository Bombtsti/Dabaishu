package com.lian.xhs.mapper;

import com.lian.xhs.entity.TCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author alex wong
 * @since 2024-03-12
 */
@Repository
public interface TCategoryMapper extends BaseMapper<TCategory> {

    ArrayList<TCategory> getCategoryTreeData();
}
