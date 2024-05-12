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
 * @since 2024-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TNote implements Serializable {

    private static final long serialVersionUID=1L;

      private String id;

    private String title;

    private String content;

    private String noteCover;

    private Integer noteCoverHeight;

    private String uid;

    private String cid;

    private String cpid;

    private String urls;

    private Integer count;

    private Integer sort;

    private Integer pinned;

    private Integer status;

    private Integer type;

    private Long viewCount;

    private Long likeCount;

    private Long collectionCount;

    private Long commentCount;

    private String creator;

    private LocalDateTime createDate;

    private String updater;

    private LocalDateTime updateDate;


}
