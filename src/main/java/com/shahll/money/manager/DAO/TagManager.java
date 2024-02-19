package com.shahll.money.manager.DAO;

import com.shahll.money.manager.model.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagManager {
    private List<Tag> tags;

    public TagManager() {
        tags = new ArrayList<>();
    }

    public List<Tag> displayTags() {
        return tags;
    }

    public void addTag(String name) {
        name = name.toLowerCase();
        for (Tag t : tags) {
            if (t.getName().equals(name)) {
                return;
            }
        }
        tags.add(new Tag(name));
    }

    public void changeTagName(String oldName, String newName) {
        oldName = oldName.toLowerCase();
        newName = newName.toLowerCase();

        if (oldName.equals(newName)) {
            return;
        }

        for (Tag t : tags) {
            if (t.getName().equals(oldName)) {
                t.setName(newName);
                return;
            }
        }
    }

    public void deleteTag(String name) {
        name = name.toLowerCase();

        for (Tag t : tags) {
            if (t.getName().equals(name)) {
                tags.remove(t);
            }
        }
    }

}
