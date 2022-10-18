package com.softserve.sportshub.category.model;

import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy="category")
    private Set<Subcategory> subcategories = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }

}
