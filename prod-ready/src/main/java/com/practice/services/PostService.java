package com.practice.services;

import com.practice.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);

    PostDto updatePost(PostDto inputPost, Long postId);
}
