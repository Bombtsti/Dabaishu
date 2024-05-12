package com.lian.xhs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lian.xhs.dto.NoteDTO;
import com.lian.xhs.entity.TNote;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lian.xhs.vo.NoteSearchVo;
import com.lian.xhs.vo.NoteVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author alex wong
 * @since 2024-03-13
 */
public interface TNoteService extends IService<TNote> {

    Page<NoteSearchVo> getNotePageByDTO(long currentPage, long pageSize, NoteDTO noteDTO);

    Page<NoteSearchVo> getNotePage(long currentPage, long pageSize);

    NoteVo getNodeVoById(String noteId);
}
