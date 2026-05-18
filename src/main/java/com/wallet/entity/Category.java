package com.wallet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.wallet.enums.CategoryType;

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

    @Enumerated(EnumType.STRING)
    private CategoryType type;

    @Column(name = "default_category")
    private Boolean defaultCategory;

    public Category(String name,CategoryType type, Boolean defaultCategory){
        this.name = name;
        this.type = type;
        this.defaultCategory = defaultCategory;
    }

}
