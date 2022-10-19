package com.softserve.sportshub.comment.service;


import com.softserve.sportshub.comment.dao.CommentDao;
import com.softserve.sportshub.comment.domain.Comment;
import com.softserve.sportshub.comment.domain.CommentMapper;
import com.softserve.sportshub.comment.dto.CommentDto;
import com.softserve.sportshub.comment.dto.CreateCommentDto;
import com.softserve.sportshub.comment.dto.ReadCommentDto;
import com.softserve.sportshub.user.User;
import com.softserve.sportshub.user.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    private final CommentDao commentDao;
    private final UserDao userDao;
    private final CommentMapper mapper;

    public CommentServiceImpl(CommentDao commentDao, UserDao userDao, CommentMapper mapper) {
        this.commentDao = commentDao;
        this.userDao = userDao;

        this.mapper = mapper;
    }

    @Transactional
    public ReadCommentDto save(Comment comment) {
        commentDao.save(comment);
        return mapper.entityToReadDto(comment);
    }

    @Override
    @Transactional
    public ReadCommentDto save(CreateCommentDto createCommentDto, String username) {
        Comment comment = new Comment();
        comment.setContent(createCommentDto.getContent());
        comment.setCreatedAt(LocalDate.now().toString());
        comment.setOwner(userDao.findByUsername(username));
        comment.setListOfUserLikes(new HashSet<>());
        comment.setListOfUserDislikes(new HashSet<>());
        commentDao.save(comment);
        return mapper.entityToReadDto(comment);
    }


    @Transactional(readOnly = true)
    public List<ReadCommentDto> list() {
        return commentDao.list().stream().map(mapper::entityToReadDto).toList();
    }

    @Override
    @Transactional
    public Comment findById(Long id) {
        return commentDao.findById(id);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return commentDao.delete(id);
    }

    @Transactional
    public ReadCommentDto like(Long id, String username) {
        User userLiked = userDao.findByUsername(username);
        Comment likedComment = commentDao.findById(id);
        if (likedComment.getOwner().getUsername().equals(username)) {
            return mapper.entityToReadDto(likedComment);
        }
        likedComment.getListOfUserDislikes().remove(userLiked);
        likedComment.getListOfUserLikes().add(userLiked);
        commentDao.save(likedComment);
        return mapper.entityToReadDto(likedComment);
    }

    @Transactional
    public ReadCommentDto dislike(Long id, String username) {
        User userDisliked = userDao.findByUsername(username);
        Comment dislikedComment = commentDao.findById(id);
        if (dislikedComment.getOwner().equals(userDisliked)) {
            return mapper.entityToReadDto(dislikedComment);
        }
        dislikedComment.getListOfUserLikes().remove(userDisliked);
        dislikedComment.getListOfUserDislikes().add(userDisliked);
        commentDao.save(dislikedComment);
        return mapper.entityToReadDto(dislikedComment);
    }
}
