package com.codecool.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RecipeAppApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RecipeAppApplication.class, args);
    }

}
