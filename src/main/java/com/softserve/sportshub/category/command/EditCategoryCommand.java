package com.softserve.sportshub.category.command;

import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EditCategoryCommand {

    private long id;

    private String name;

    private Set<Subcategory> subcategories;

}
