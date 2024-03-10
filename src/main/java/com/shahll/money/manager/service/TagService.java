package com.shahll.money.manager.service;

import com.shahll.money.manager.dto.TagDto;
import com.shahll.money.manager.model.Tag;

import java.util.List;

public interface TagService {
    List<TagDto> findAllTags();
    TagDto findTagById(long id);
    Tag saveTag(Tag tag);
    void updateTag(TagDto tagDto);
    void deleteTag(long id);

}

