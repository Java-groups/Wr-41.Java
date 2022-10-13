package com.softserve.SportsHub.comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Comment> list();
}
