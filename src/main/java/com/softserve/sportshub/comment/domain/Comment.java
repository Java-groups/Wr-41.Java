package com.softserve.sportshub.comment.domain;

import com.softserve.sportshub.user.User;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "Comment")
public class Comment {

    public static final String COLUMN_PREFIX = "co_";

    @Id
    @GeneratedValue
    @Column(name = COLUMN_PREFIX + "id")
    private Long id;

    @Column(name = COLUMN_PREFIX + "content")
    private String content;

    @Column(name = COLUMN_PREFIX + "createdAt")
    private String createdAt;

    @ManyToOne
    private User owner;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "comment_userLikes",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> listOfUserLikes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "comment_userDislikes",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> listOfUserDislikes;


}
