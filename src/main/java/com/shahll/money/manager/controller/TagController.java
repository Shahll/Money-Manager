package com.shahll.money.manager.controller;

import com.shahll.money.manager.dto.TagDto;
import com.shahll.money.manager.model.Tag;
import com.shahll.money.manager.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    public TagServiceImpl tagService;

    @Autowired
    public TagController(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/list")
    public List<TagDto> displayTags() {
        return tagService.findAllTags();
    }

    @GetMapping("/{id}")
    public TagDto displayTag(@PathVariable long id) {
        return tagService.findTagById(id);
    }

    @PostMapping("/new")
    public Tag addTag(@RequestBody Tag tag) {
        return tagService.saveTag(tag);
    }

    @PutMapping("/{id}/edit")
    public void editTag(@PathVariable long id, @RequestBody TagDto tag) {
        tag.setId(id);
        tagService.updateTag(tag);
    }

}