package com.weekfour.production_ready_features.prod_ready_features.controllers;

import com.weekfour.production_ready_features.prod_ready_features.dto.PostDTO;
import com.weekfour.production_ready_features.prod_ready_features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

     //localhost:8080/posts
     //{
//    "title":"This is the title 1",
//            "description":"This is description 1"
//}
    @PostMapping //localhost:8080/posts/1
    public PostDTO createNewPost(@RequestBody PostDTO inputPost) {
        return postService.createNewPost(inputPost);
    }
//
//    @PutMapping("{postId}")
//    public PostDTO updatePost(@RequestBody PostDTO inputPost, @PathVariable Long postId) {
//        return postService.updatePost(inputPost, postId);
//    }
}
