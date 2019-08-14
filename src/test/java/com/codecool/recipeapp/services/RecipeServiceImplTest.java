package com.codecool.recipeapp.services;

import com.codecool.recipeapp.model.Recipe;
import com.codecool.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);
        Mockito.when(recipeService.getRecipes()).thenReturn(recipeData);
        Set<Recipe> recipeSet = recipeService.getRecipes();
        assertEquals(recipeSet.size(), 1);
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}