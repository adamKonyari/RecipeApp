package com.codecool.recipeapp.controllers;

import com.codecool.recipeapp.model.Recipe;
import com.codecool.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    IndexController indexController;

    @Mock
    Model model;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
        model.addAttribute("recipes");
    }

    @Test
    public void testMocMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipeSet.add(recipe);

        Mockito.when(recipeService.getRecipes()).thenReturn(recipeSet);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String expected = "index";
        assertEquals(expected, indexController.getIndexPage(model));
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}