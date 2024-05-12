package com.lian.xhs.vo;

import com.lian.xhs.utils.TreeNode;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryVo extends TreeNode<CategoryVo> implements Serializable {
    private String title;
    private long likeCount;
}
