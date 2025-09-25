package com.practice.SecurityApplication.controllers;

import com.practice.SecurityApplication.dto.PostDto;
import com.practice.SecurityApplication.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto inputPost) {
        return postService.createNewPost(inputPost);
    }

    @PutMapping("/{postId}")
    public PostDto updatePost(@RequestBody PostDto inputPost, @PathVariable Long postId) {
        return postService.updatePost(inputPost, postId);
    }


}
