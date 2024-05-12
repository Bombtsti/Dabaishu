package com.lian.xhs.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lian.xhs.entity.TNote;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lian.xhs.vo.NoteSearchVo;
import com.lian.xhs.vo.NoteVo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author alex wong
 * @since 2024-03-13
 */
@Repository
public interface TNoteMapper extends BaseMapper<TNote> {

    Page<NoteSearchVo> getSearchNoteVoList(Page<NoteSearchVo> page);
    Page<NoteSearchVo> getSearchNoteVoListByDTO(Page<NoteSearchVo> page,String cpid);

    TNote getNodeById(String noteid);
}
