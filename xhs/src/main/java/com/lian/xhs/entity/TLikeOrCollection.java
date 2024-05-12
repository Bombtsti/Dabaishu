package com.lian.xhs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlw
 * @since 2024-03-17 05:07:58
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_like_or_collection")
public class TLikeOrCollection implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 点赞的用户
     */
    @TableField("uid")
    private String uid;

    /**
     * 点赞和收藏的id(可能是图片或者评论)
     */
    @TableField("like_or_collection_id")
    private Long likeOrCollectionId;

    /**
     * 点赞和收藏通知的用户
     */
    @TableField("publish_uid")
    private Long publishUid;

    @TableField("type")
    private Integer type;

    @TableField("timestamp")
    private Long timestamp;

    @TableField("creator")
    private String creator;

    @TableField("create_date")
    private Date createDate;

    @TableField("updater")
    private String updater;

    @TableField("update_date")
    private Date updateDate;


}
