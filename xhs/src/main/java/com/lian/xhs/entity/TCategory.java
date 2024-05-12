package com.lian.xhs.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author alex wong
 * @since 2024-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TCategory implements Serializable {

    private static final long serialVersionUID=1L;

      private String id;

    private String title;

    private String pid;

    private Integer sort;

    private Long likeCount;

    private String description;

    /**
     * 分类的封面，如果是一级分类就是随便看看的封面，二级分类则是主封面
     */
    private String normalCover;

    /**
     * 热门封面
     */
    private String hotCover;

    private String creator;

    private LocalDateTime createDate;

    private String updater;

    private LocalDateTime updateDate;


}
