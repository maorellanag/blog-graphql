package org.example.controller;

import org.example.domain.Post;
import org.example.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public List<Post> posts() {
        return postService.getAllPosts();
    }

    @QueryMapping
    public Post post(Long id) {
        return postService.getPostById(id);
    }

    @SchemaMapping
    public int commentsCount(Post post) {
        return post.getComments().size();
    }

    @MutationMapping
    public Post createPost(@Argument String author, @Argument String title, @Argument String content) {
        return postService.createPost(author, title, content);
    }
}
