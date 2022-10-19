package com.softserve.sportshub.comment.controller;

import com.softserve.sportshub.comment.dto.CommentDto;
import com.softserve.sportshub.comment.dto.CreateCommentDto;
import com.softserve.sportshub.comment.dto.ReadCommentDto;
import com.softserve.sportshub.comment.service.CommentService;
import com.softserve.sportshub.comment.domain.Comment;
import com.softserve.sportshub.user.UserService;
import com.softserve.sportshub.user.dto.UserDto;
import com.softserve.sportshub.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {


    public CommentService service;
    public UserService userService;

    public CommentController(CommentService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/comments")
    public ResponseEntity<List<ReadCommentDto>> getAllComments() {
        return ResponseEntity.ok().body(service.list());
    }

    @PostMapping("/comment")
    public ResponseEntity<ReadCommentDto> createComment(HttpServletRequest request, @RequestBody CreateCommentDto createCommentDto) throws Exception {
        String username = JwtUtils.getUsernameFromTokenInsideRequest(request);
        ReadCommentDto savedComment = service.save(createCommentDto, username);
        return ResponseEntity.ok().body(savedComment);
    }

    @DeleteMapping("/comment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long id) {
        service.delete(id);
    }


    @PostMapping("/{id}/like")
    public ResponseEntity<ReadCommentDto> likeComment(@PathVariable Long id, HttpServletRequest request) throws Exception {
        String username = JwtUtils.getUsernameFromTokenInsideRequest(request);
        ReadCommentDto commentLiked = service.like(id, username);
        return ResponseEntity.ok().body(commentLiked);
    }

    @PostMapping("/{id}/dislike")
    public ResponseEntity<ReadCommentDto> dislikeComment(@PathVariable Long id, HttpServletRequest request) throws Exception {
        String username = JwtUtils.getUsernameFromTokenInsideRequest(request);
        ReadCommentDto commentDisliked = service.dislike(id, username);
        return ResponseEntity.ok().body(commentDisliked);
    }


}
