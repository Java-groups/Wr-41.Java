package com.softserve.sportshub.category.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddSubcategoryCommand {

    private long idOfCategory;

    private long idOfSubcategory;

}
