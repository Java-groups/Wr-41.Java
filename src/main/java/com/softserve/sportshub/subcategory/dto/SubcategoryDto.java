package com.softserve.sportshub.subcategory.dto;

import com.softserve.sportshub.category.model.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubcategoryDto {

    private long id;

    private String name;

    private Category category;

}
