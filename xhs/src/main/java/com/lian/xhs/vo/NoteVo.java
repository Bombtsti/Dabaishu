package com.lian.xhs.vo;

import com.lian.xhs.entity.TTag;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.swing.text.html.HTML;
import java.io.Serializable;
import java.util.List;

/**
 * @author xiaozhao
 */
@Data
@Accessors(chain = true)
public class NoteVo implements Serializable {

    private String id;

    private String title;

    private String content;

    private String noteCover;

    private String uid;

    private String username;

    private String avatar;

    private String urls;

    private String cid;

    private String cpid;

    //图片数量
    private Integer count;

    //类型（图片或视频）
    private Integer type;

    private Long likeCount;

    private Long collectionCount;

    private Long commentCount;

    private List<TTag> tagList;

    private Long time;

    private Integer pinned;

    //点赞关注收藏
    private Boolean isFollow;

    private Boolean isLike;

    private Boolean isCollection;
}
