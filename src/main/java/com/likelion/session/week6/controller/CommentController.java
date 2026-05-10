package com.likelion.session.week6.controller;

import com.likelion.session.week6.dto.CommentDTO;
import com.likelion.session.week6.entity.Comment;
import com.likelion.session.week6.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/comment")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/getComment")
    public Optional<Comment> getComment(@RequestParam(name = "commentId") Long commentId) {
        return commentService.getComment(commentId);
    }

    @PostMapping("/postComment")
    public void postComment(@RequestBody CommentDTO commentDTO) {
        commentService.postComment(commentDTO);
    }

    @PutMapping("/putComment")
    public void putComment(@RequestBody CommentDTO commentDTO) {
        commentService.putComment(commentDTO);
    }

    @DeleteMapping("/deleteComment/{commentId}")
    public void deleteComment(@PathVariable(name = "commentId") Long commentId) {
        commentService.deleteComment(commentId);
    }
}