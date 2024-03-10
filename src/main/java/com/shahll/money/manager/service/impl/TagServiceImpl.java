package com.shahll.money.manager.service.impl;

import com.shahll.money.manager.dto.TagDto;
import com.shahll.money.manager.model.Tag;
import com.shahll.money.manager.repository.TagRepository;
import com.shahll.money.manager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl (TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagDto> findAllTags() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream().map(this::mapToTagDto).collect(Collectors.toList());
    }

    private TagDto mapToTagDto (Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }

    @Override
    public TagDto findTagById(long id) {
        try {
            return mapToTagDto(Objects.requireNonNull(tagRepository.findById(id)));
        } catch (Exception e) {
            // TODO: handle
            return null;
        }
    }

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void updateTag(TagDto tagDto) {
        Tag tag = mapToTag(tagDto);
        tagRepository.save(tag);
    }

    private Tag mapToTag(TagDto tag) {
        return Tag.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }

    @Override
    public void deleteTag(long id) {
        tagRepository.deleteById(id);
    }

}


