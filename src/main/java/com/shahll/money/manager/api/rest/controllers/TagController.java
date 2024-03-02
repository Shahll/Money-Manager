package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.TagManager;
import com.shahll.money.manager.model.Requests.StringRequest;
import com.shahll.money.manager.model.Requests.TagNameRequest;
import com.shahll.money.manager.model.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final TagManager tm;

    public TagController(TagManager tm) {
        this.tm = tm;
    }

    @GetMapping("/display")
    public List<Tag> showTags() {
        return tm.displayTags();
    }

    @PostMapping("/add")
    public void addTag(@RequestBody StringRequest input) {
        tm.addTag(input.name());
    }

    @PutMapping("/change")
    public void changeTagName(@RequestBody TagNameRequest input){
        if (input.oldName() == null || input.newName() == null) {
            return;
        }
        tm.changeTagName(input.oldName(), input.newName());
    }

    @DeleteMapping("/delete")
    public void deleteTag(@RequestBody StringRequest input) {
        if (input.name() == null) {
            return;
        }
        tm.deleteTag(input.name());
    }

}
