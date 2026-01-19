package com.wallet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "default_category")
    private Boolean defaultCategory;

    public Category(String name, Boolean defaultCategory){
        this.name = name;
        this.defaultCategory = defaultCategory;
    }

}
