package com.shahll.money.manager.api.rest.controllers;

import com.shahll.money.manager.DAO.TagManager;
import com.shahll.money.manager.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    private TagManager tm;


    @GetMapping("/display")
    public List<Tag> showTags() {
        return tm.displayTags();
    }

    @PostMapping("/add")
    public void addTag(@RequestParam(value = "name") String name) {
        tm.addTag(name);
    }

    @PutMapping("/change")
    public void changeTagName(
            @RequestParam(value = "oldName") String oldName,
            @RequestParam(value = "newName") String newName ) {
        tm.changeTagName(oldName, newName);
    }

    @DeleteMapping("/delete")
    public void deleteTag(@RequestParam(value = "name") String name) {
        tm.deleteTag(name);
    }

}
