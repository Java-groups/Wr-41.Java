package com.softserve.sportshub.comment;

import com.softserve.sportshub.comment.dao.CommentDao;
import com.softserve.sportshub.comment.domain.Comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCommentDao implements CommentDao {
    private Long id = 1L;
    Map<Long, Comment> commentMap = new HashMap<>();

    @Override
    public void save(Comment comment) {
        commentMap.put(id, comment);
        id++;
    }

    @Override
    public List<Comment> list() {
        return commentMap.values().stream().toList();
    }

    @Override
    public boolean delete(Long id) {
        if (!commentMap.containsKey(id)) {
            return false;
        }
        commentMap.remove(id);
        return true;
    }

    @Override
    public Comment findById(Long id) {
        return commentMap.get(id);
    }
}
