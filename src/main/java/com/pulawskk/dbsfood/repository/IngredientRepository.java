package com.pulawskk.dbsfood.repository;

import com.pulawskk.dbsfood.domain.Ingredient;
import com.pulawskk.dbsfood.domain.IngredientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByIngredientType(IngredientType ingredientType);

    Optional<Ingredient> findIngredientByName(String name);
}
