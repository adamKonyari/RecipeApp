package com.codecool.recipeapp.services;

import com.codecool.recipeapp.commands.RecipeCommand;
import com.codecool.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(Long l);

    void deleteById(Long idToDelete);
}
