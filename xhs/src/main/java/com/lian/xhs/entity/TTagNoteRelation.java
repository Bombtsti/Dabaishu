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
 * @since 2024-03-17 05:08:49
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_tag_note_relation")
public class TTagNoteRelation implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("nid")
    private String nid;

    @TableField("tid")
    private String tid;

    @TableField("creator")
    private String creator;

    @TableField("create_date")
    private Date createDate;

    @TableField("updater")
    private String updater;

    @TableField("update_date")
    private Date updateDate;


}
