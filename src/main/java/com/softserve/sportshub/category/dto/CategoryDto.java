package com.softserve.sportshub.category.dto;

import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private long id;

    private String name;

    private Set<Subcategory> subcategories;

}
