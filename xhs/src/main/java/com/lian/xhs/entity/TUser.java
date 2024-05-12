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
 * @since 2024-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TUser implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private Long yxId;

    private String username;

    private String password;

    private String avatar;

    private Integer gender;

    private String phone;

    private String email;

    private String description;

    private Integer status;

    private String userCover;

    private String birthday;

    private String address;

    private Long trendCount;

    private Long followerCount;

    private Long fanCount;

    private String creator;

    private LocalDateTime createDate;

    private String updater;

    private LocalDateTime updateDate;


}
