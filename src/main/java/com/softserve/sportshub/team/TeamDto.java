package com.softserve.sportshub.team;

import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private String teamName;
    private Category category;
    private Subcategory subcategory;


}
