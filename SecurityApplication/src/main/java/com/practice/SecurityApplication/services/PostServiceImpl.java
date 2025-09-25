package com.practice.SecurityApplication.services;

import com.practice.SecurityApplication.dto.PostDto;
import com.practice.SecurityApplication.entities.Post;
import com.practice.SecurityApplication.exceptions.ResourceNotFoundException;
import com.practice.SecurityApplication.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;


    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtoList = posts.stream().map((post) -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id:" + postId));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        Post post = modelMapper.map(inputPost, Post.class);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto inputPost, Long postId) {
        Post olderPost = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id:" + postId));
        inputPost.setId(postId);
        modelMapper.map(inputPost, olderPost);
        Post savedPost = postRepository.save(olderPost);
        System.out.println("updated");
        return modelMapper.map(savedPost, PostDto.class);
    }
}
