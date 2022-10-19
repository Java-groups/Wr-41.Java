package com.softserve.sportshub.comment.dao;

import com.softserve.sportshub.comment.domain.Comment;

import java.util.List;

public interface CommentDao {
    void save(Comment comment);
    List<Comment> list();
    boolean delete(Long id);
    Comment findById(Long id);
}
