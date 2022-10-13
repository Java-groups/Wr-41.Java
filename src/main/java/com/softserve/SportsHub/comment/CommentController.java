package com.softserve.SportsHub.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    public CommentService service;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        Comment comment = new Comment();
        comment.setCreatedAt(LocalDate.now().toString());
        comment.setContent("Test message");
        service.save(comment);
        return service.list();
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setCreatedAt(LocalDate.now().toString());
        comment.setContent(commentDto.getContent());
        service.save(comment);
        return comment;
    }

}
