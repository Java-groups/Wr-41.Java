package com.softserve.SportsHub.comment;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


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

}
