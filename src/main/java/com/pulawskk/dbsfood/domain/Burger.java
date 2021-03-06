package com.pulawskk.dbsfood.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "burgers")
@Data
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "burgers_id_generator")
    @SequenceGenerator(name = "burgers_id_generator", sequenceName = "burgers_id_sequence", allocationSize = 1)
    private Long id;

    private String name;

    private BigDecimal price;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        if (this.ingredients == null) {
            this.ingredients = new ArrayList<>();
        }
        this.ingredients.add(ingredient);
    }

    public String toStringIngredients() {
        return ingredients.stream().map(Ingredient::getName).collect(Collectors.joining(","));
    }
}
