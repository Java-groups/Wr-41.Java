package com.softserve.SportsHub.comment;

import java.util.List;

interface CommentDao {
    void save(Comment comment);
    List<Comment> list();
}
