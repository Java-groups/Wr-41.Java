package com.softserve.sportshub.article.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
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

    public Article(Language language, String pic, String alternativePic, String headline, String caption, String content, Boolean showComments) {
        this.language = language;
        this.pic = pic;
        this.alternativePic = alternativePic;
        this.headline = headline;
        this.caption = caption;
        this.content = content;
        this.showComments = showComments;
    }
}
