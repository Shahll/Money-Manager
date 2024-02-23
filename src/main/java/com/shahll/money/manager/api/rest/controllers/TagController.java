package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.TagManager;
import com.shahll.money.manager.model.Requests.StringRequest;
import com.shahll.money.manager.model.Requests.ChangeTagNameRequest;
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

    @SuppressWarnings("unused")
    @GetMapping("/display")
    public List<Tag> showTags() {
        return tm.displayTags();
    }

    @SuppressWarnings("unused")
    @PostMapping("/add")
    public void addTag(@RequestBody StringRequest input) {
        tm.addTag(input.getName());
    }

    @SuppressWarnings("unused")
    @PutMapping("/change")
    public void changeTagName(@RequestBody ChangeTagNameRequest input){
        if (input.getOldName() == null || input.getNewName() == null) {
            return;
        }
        tm.changeTagName(input.getOldName(), input.getNewName());
    }

      @SuppressWarnings("unused")
      @DeleteMapping("/delete")
    public void deleteTag(@RequestBody StringRequest input) {
        if (input.getName() == null) {
            return;
        }
        tm.deleteTag(input.getName());
    }

}
