package com.shahll.money.manager.DAO;

import com.shahll.money.manager.model.Tag;
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
        Tag tagToChange = null;
        for (Tag t : tags) {
            if (t.getName().equals(oldName)) {
                tagToChange = t;
            }
            if (t.getName().equals(newName)) {
                 deleteTag(oldName);
                return;
            }
        }
        if (tagToChange != null) {
            tagToChange.setName(newName);
        }
    }

    public void deleteTag(String name) {
        name = name.toLowerCase();

        for (Tag t : tags) {
            if (t.getName().equals(name)) {
                tags.remove(t);
                return;
            }
        }
    }

    public Tag findTag(String name) {
        for (Tag t : tags) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        addTag(name);
        return tags.getLast();

    }

}
