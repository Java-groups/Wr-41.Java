package com.softserve.sportshub.comment.service;

import com.softserve.sportshub.comment.domain.Comment;
import com.softserve.sportshub.comment.dto.CommentDto;
import com.softserve.sportshub.comment.dto.CreateCommentDto;
import com.softserve.sportshub.comment.dto.ReadCommentDto;

import java.util.List;

public interface CommentService {
    ReadCommentDto save(Comment comment);

    ReadCommentDto save(CreateCommentDto createCommentDto, String username);

    List<ReadCommentDto> list();

    Comment findById(Long id);

    boolean delete(Long id);

    ReadCommentDto like(Long id, String username);

    ReadCommentDto dislike(Long id, String username);
}
