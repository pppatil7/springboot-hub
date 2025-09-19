package com.practice.controllers;

import com.practice.entities.Post;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/posts/{postId}")
    List<Post> getPostRevisions(@PathVariable Long postId) {
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = reader.getRevisions(Post.class, postId);
        return revisions
                .stream()
                .map(revisionNumber -> reader.find(Post.class, postId, revisionNumber))
                .collect(Collectors.toList());
    }


}
