package com.softserve.sportshub.comment;

import com.softserve.sportshub.comment.dao.CommentDao;
import com.softserve.sportshub.comment.domain.Comment;
import com.softserve.sportshub.comment.domain.CommentMapper;
import com.softserve.sportshub.comment.dto.CreateCommentDto;
import com.softserve.sportshub.comment.dto.ReadCommentDto;
import com.softserve.sportshub.comment.service.CommentServiceImpl;
import com.softserve.sportshub.user.User;
import com.softserve.sportshub.user.UserDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;

class CommentServiceImplTest {

    private final CommentDao commentDao = new InMemoryCommentDao();
    UserDao userDao = Mockito.mock(UserDao.class);
    private final CommentMapper mapper = new CommentMapper();

    private final CommentServiceImpl commentService
            = new CommentServiceImpl(commentDao, userDao, mapper);

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1L, "Lena", "password", false, false, new ArrayList<>());
    }

    @Test
    public void shouldCreateCommentTest() {
        // given
        CreateCommentDto createCommentDto = new CreateCommentDto("Test comment");
        Mockito.when(userDao.findByUsername(any())).thenReturn(user);
        // when
        ReadCommentDto createdComment = commentService.save(createCommentDto, "Lena");
        // then
        assertThat(createdComment.getContent()).isEqualTo("Test comment");
        assertThat(createdComment.getCreatedAt()).isEqualTo(LocalDate.now().toString());
        assertThat(createdComment.getOwner()).isEqualTo(user.getUsername());
    }

    @Test
    public void shouldReturnAllComments() {
        // given
        testInMemoryDaoInitialized();

        Comment comment1 = createNewComment(1L, "Test comment");
        Comment comment2 = createNewComment(2L, "Second test comment");
        List<ReadCommentDto> commentsExpected
                = Stream.of(comment1, comment2)
                        .map(mapper::entityToReadDto)
                        .toList();

        // when
        List<ReadCommentDto> commentsFound = commentService.list();

        //then
        assertThat(commentsFound).hasSameSizeAs(commentsExpected);
        assertThat(commentsFound).element(0).usingRecursiveComparison().isEqualTo(commentsExpected.get(0));
        assertThat(commentsFound)
                .element(1)
                .hasFieldOrPropertyWithValue("content", commentsExpected.get(1).getContent());
    }

    @Test
    public void givenCorrectId_whenFindByIdIsCalled_shouldFindOneComment() {
        // given
        testInMemoryDaoInitialized();
        Comment expectedComment = createNewComment(2L, "Second test comment");
        // when
        Comment actualComment = commentService.findById(2L);
        // then
        assertThat(actualComment).isNotNull();
        assertThat(actualComment).usingRecursiveComparison().isEqualTo(expectedComment);

    }

    @Test
    public void givenCorrectId_whenDeleteIsCalled_shouldDeleteTheComment() {
        // given
        List<Comment> comments = testInMemoryDaoInitialized();
        // when
        // then
        assertThat(commentService.delete(500L)).isFalse();
        assertThat(commentService.delete(1L)).isTrue();
        assertThat(commentService.list()).hasSize(1);
        assertThat(commentService.findById(2L)).hasFieldOrPropertyWithValue("content","Second test comment");
    }

    @Test
    public void givenOtherUser_whenAddLikeIsCalled_shouldAddLike() {
        // given
        testInMemoryDaoInitialized();
        User user2 = new User(2L, "Lena2", "strongPassword", false, false, new ArrayList<>());
        Mockito.when(userDao.findByUsername(any())).thenReturn(user2);
        // when
        commentService.like(1L, user2.getUsername());
        // then
        assertThat(commentService.findById(1L)).hasFieldOrPropertyWithValue("listOfUserLikes", Set.of(user2));
    }

    @Test
    public void givenTheSameUser_whenAddLikeIsCalled_shouldNotAddLike() {
        // given
        testInMemoryDaoInitialized();
        Mockito.when(userDao.findByUsername(any())).thenReturn(user);
        // when
        commentService.like(1L, user.getUsername());
        // then
        assertThat(commentService.findById(1L)).hasFieldOrPropertyWithValue("listOfUserLikes", Set.of());
    }

    Comment createNewComment(Long id, String content) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setCreatedAt(LocalDate.now().toString());
        comment.setListOfUserDislikes(new HashSet<>());
        comment.setListOfUserLikes(new HashSet<>());
        comment.setOwner(user);
        comment.setContent(content);
        return comment;
    }

    List<Comment> testInMemoryDaoInitialized() {
        Comment comment1 = createNewComment(1L, "Test comment");
        commentService.save(comment1);
        Comment comment2 = createNewComment(2L, "Second test comment");
        commentService.save(comment2);
        return List.of(comment1, comment2);
    }
}
