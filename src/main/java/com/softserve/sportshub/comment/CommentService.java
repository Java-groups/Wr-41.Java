package com.softserve.sportshub.comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Comment> list();
}
