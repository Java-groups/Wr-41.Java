package com.softserve.sportshub.subcategory.model;

import com.softserve.sportshub.category.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "SUBCATEGORY")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Subcategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }

}
