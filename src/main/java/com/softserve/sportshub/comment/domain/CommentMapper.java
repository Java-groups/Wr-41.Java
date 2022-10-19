package com.softserve.sportshub.comment.domain;

import com.softserve.sportshub.comment.dto.CommentDto;
import com.softserve.sportshub.comment.dto.ReadCommentDto;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public Comment dtoToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setContent(commentDto.getContent());
        comment.setCreatedAt(commentDto.getCreatedAt());
        comment.setOwner(commentDto.getOwner());
        comment.setListOfUserLikes(commentDto.getListOfUserLikes());
        comment.setListOfUserDislikes(commentDto.getListOfUserDislikes());
        return comment;
    }

    public CommentDto entityToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setCreatedAt(comment.getCreatedAt());
        commentDto.setOwner(comment.getOwner());
        commentDto.setListOfUserLikes(comment.getListOfUserLikes());
        commentDto.setListOfUserDislikes(comment.getListOfUserDislikes());
        return commentDto;
    }

    public ReadCommentDto entityToReadDto(Comment comment) {
        ReadCommentDto readCommentDto = new ReadCommentDto();
        readCommentDto.setId(comment.getId());
        readCommentDto.setContent(comment.getContent());
        readCommentDto.setCreatedAt(comment.getCreatedAt());
        readCommentDto.setOwner(comment.getOwner().getUsername());
        readCommentDto.setNumberOfLikes(
                comment.getListOfUserLikes().stream().count());
        readCommentDto.setNumberOfDislikes(
                comment.getListOfUserDislikes().stream().count());
        return readCommentDto;
    }
}
