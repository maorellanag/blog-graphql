package org.example.controller;

import org.example.domain.Comment;
import org.example.service.CommentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @QueryMapping
    public List<Comment> comments(Long postId) {
        return commentService.getCommentsForPost(postId);
    }

    @MutationMapping
    public Comment createComment(@Argument Long postId, @Argument String author, @Argument String content) {
        return commentService.createComment(postId, author, content);
    }
}
