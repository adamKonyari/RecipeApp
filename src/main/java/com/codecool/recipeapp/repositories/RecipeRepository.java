package com.codecool.recipeapp.repositories;

import com.codecool.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
