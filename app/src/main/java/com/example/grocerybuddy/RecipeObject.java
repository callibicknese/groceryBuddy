package com.example.grocerybuddy;

import java.util.LinkedList;

public class RecipeObject {

    public class FoodObject{

        String name;
        String unit;
        String quantity;


    }

    LinkedList<String> steps;
    LinkedList<FoodObject> ingredientList;
    String RecipeName;
    LinkedList<String> imageNames;

}
