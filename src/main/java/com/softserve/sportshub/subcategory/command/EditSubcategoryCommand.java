package com.softserve.sportshub.subcategory.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EditSubcategoryCommand {

    private long id;

    private String name;
}
