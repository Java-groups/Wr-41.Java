package com.softserve.SportsHub.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Transactional
    public void save(Comment comment) {
        commentDao.save(comment);
    }


    @Transactional(readOnly = true)
    public List<Comment> list() {
        return commentDao.list();
    }
}
