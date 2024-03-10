package com.shahll.money.manager.repository;

import com.shahll.money.manager.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAll();
    Tag findById(long id);
    Tag save(Tag tag);
    void deleteById(long id);
}
