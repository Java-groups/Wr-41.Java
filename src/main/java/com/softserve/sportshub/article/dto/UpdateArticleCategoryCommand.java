package com.softserve.sportshub.article.dto;

import com.softserve.sportshub.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleCategoryCommand {

    private Category category;
}
