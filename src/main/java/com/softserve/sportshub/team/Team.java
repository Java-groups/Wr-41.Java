package com.softserve.sportshub.team;

import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.subcategory.model.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "SUBCATEGORY_ID", referencedColumnName = "id")
    private Subcategory subcategory;


}
