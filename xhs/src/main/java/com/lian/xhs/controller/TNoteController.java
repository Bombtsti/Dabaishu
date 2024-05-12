package com.lian.xhs.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lian.xhs.dto.NoteDTO;
import com.lian.xhs.entity.TNote;
import com.lian.xhs.result.Result;
import com.lian.xhs.service.TNoteService;
import com.lian.xhs.vo.NoteSearchVo;
import com.lian.xhs.vo.NoteVo;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alex wong
 * @since 2024-03-13
 */
@RestController
@RequestMapping("/api/note")
public class TNoteController {

    @Autowired
    private TNoteService tNoteService;

    @RequestMapping("/getNotePageByDTO/{currentPage}/{pageSize}")
    public Result<?> getNotePageByDTO(@PathVariable long currentPage, @PathVariable long pageSize, @RequestBody NoteDTO noteDTO){
        Page<NoteSearchVo> notePageByDTO = tNoteService.getNotePageByDTO(currentPage, pageSize, noteDTO);
        return Result.ok(notePageByDTO);
    }


    @RequestMapping("/getNotePage/{currentPage}/{pageSize}")
    public Result<?> getNotePage(@PathVariable long currentPage, @PathVariable long pageSize){
        Page<NoteSearchVo> notePageByDTO = tNoteService.getNotePage(currentPage, pageSize);
        return Result.ok(notePageByDTO);
    }


    @GetMapping("/getNoteById")
    public Result<?> getNodeById(String noteId){
        NoteVo noteVo = tNoteService.getNodeVoById(noteId);
        return Result.ok(noteVo);
    }


}

