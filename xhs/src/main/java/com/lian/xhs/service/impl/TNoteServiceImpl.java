package com.lian.xhs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lian.xhs.dto.NoteDTO;
import com.lian.xhs.entity.*;
import com.lian.xhs.mapper.TNoteMapper;
import com.lian.xhs.mapper.TUserMapper;
import com.lian.xhs.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lian.xhs.utils.ConvertUtils;
import com.lian.xhs.vo.NoteSearchVo;
import com.lian.xhs.vo.NoteVo;
import net.sf.jsqlparser.statement.select.First;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alex wong
 * @since 2024-03-13
 */
@Service
public class TNoteServiceImpl extends ServiceImpl<TNoteMapper, TNote> implements TNoteService {

    @Autowired
    private TNoteMapper tNoteMapper;

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TFollowerService tFollowerService;

    @Autowired
    private TLikeOrCollectionService tLikeOrCollectionService;

    @Autowired
    private TTagNoteRelationService tTagNoteRelationService;

    @Autowired
    private TTagService tTagService;


    @Override
    public Page<NoteSearchVo> getNotePageByDTO(long currentPage, long pageSize, NoteDTO noteDTO) {
        String categoryId = noteDTO.getCpid();
        Page<NoteSearchVo> page = new Page<>(currentPage,pageSize);
        Page<NoteSearchVo> voList = tNoteMapper.getSearchNoteVoListByDTO(page,categoryId);
        return voList;
    }

    @Override
    public Page<NoteSearchVo> getNotePage(long currentPage, long pageSize) {
        Page<NoteSearchVo> page = new Page<>(currentPage,pageSize);
        Page<NoteSearchVo> voList = tNoteMapper.getSearchNoteVoList(page);
        return voList;
    }

    @Override
    public NoteVo getNodeVoById(String noteId) {
        TNote note = tNoteMapper.getNodeById(noteId);
        TUser user = tUserService.selectUserById(note.getUid());
        NoteVo noteVo = ConvertUtils.sourceToTarget(note, NoteVo.class);

        noteVo.setUsername(user.getUsername());
        noteVo.setAvatar(user.getAvatar());

        boolean follow = tFollowerService.isFollow(user.getId());
        noteVo.setIsFollow(follow);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUid = (String) authentication.getPrincipal();

        List<TLikeOrCollection> likeOrCollectionList =
                tLikeOrCollectionService.list(new QueryWrapper<TLikeOrCollection>().eq("like_or_collection_id", noteId).eq("uid", currentUid));

        Set<Integer> types = likeOrCollectionList.stream().map(TLikeOrCollection::getType).collect(Collectors.toSet());
        noteVo.setIsLike(types.contains(1));
        noteVo.setIsCollection(types.contains(3));

        List<TTagNoteRelation> tagNoteRelationList = tTagNoteRelationService.list(new QueryWrapper<TTagNoteRelation>().eq("nid", noteId));
        List<String> tids = tagNoteRelationList.stream().map(TTagNoteRelation::getTid).collect(Collectors.toList());

        if (!tids.isEmpty()) {
            List<TTag> tagList = tTagService.listByIds(tids);
            noteVo.setTagList(tagList);
        }
        return noteVo;
    }
}
