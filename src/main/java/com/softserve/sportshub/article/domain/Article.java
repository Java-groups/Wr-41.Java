package com.softserve.sportshub.article.domain;

import com.softserve.sportshub.comment.Comment;
import com.softserve.sportshub.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Language language;
    private String pic;
    private String alternativePic;
    private String headline;
    private String caption;
    private String content;
    private Boolean showComments;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "article_id")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;

    public Article(Language language, String pic, String alternativePic, String headline, String caption, String content, Boolean showComments) {
        this.language = language;
        this.pic = pic;
        this.alternativePic = alternativePic;
        this.headline = headline;
        this.caption = caption;
        this.content = content;
        this.showComments = showComments;
    }

    public Article(Long id, Language language, String pic, String alternativePic, String headline, String caption, String content, Boolean showComments) {
        this.id = id;
        this.language = language;
        this.pic = pic;
        this.alternativePic = alternativePic;
        this.headline = headline;
        this.caption = caption;
        this.content = content;
        this.showComments = showComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Article article = (Article) o;
        return id != null && Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
