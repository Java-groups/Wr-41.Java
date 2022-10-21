package com.softserve.sportshub.comment.controller;

import com.softserve.sportshub.comment.dto.CreateCommentDto;
import com.softserve.sportshub.comment.dto.ReadCommentDto;
import com.softserve.sportshub.comment.service.CommentService;
import com.softserve.sportshub.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {


    public CommentService commentService;
    public UserService userService;

    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/comments")
    public List<ReadCommentDto> getAllComments() {
        return commentService.list();
    }

    @PostMapping("/comment")
    public ResponseEntity<ReadCommentDto> createComment(Principal principal, @RequestBody CreateCommentDto createCommentDto) {
        String username = principal.getName();
        ReadCommentDto savedComment = commentService.save(createCommentDto, username);
        return ResponseEntity.ok().body(savedComment);
    }

    @DeleteMapping("/comment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }


    @PostMapping("/{id}/like")
    public ResponseEntity<ReadCommentDto> likeComment(@PathVariable Long id, Principal principal) {
        String username = principal.getName();
        ReadCommentDto commentLiked = commentService.like(id, username);
        return ResponseEntity.ok().body(commentLiked);
    }

    @PostMapping("/{id}/dislike")
    public ResponseEntity<ReadCommentDto> dislikeComment(@PathVariable Long id, Principal principal) {
        String username = principal.getName();
        ReadCommentDto commentDisliked = commentService.dislike(id, username);
        return ResponseEntity.ok().body(commentDisliked);
    }


}
