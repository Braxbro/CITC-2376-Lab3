package com.example.recipeexplorer.data

import com.example.recipeexplorer.R
import com.example.recipeexplorer.data.classes.Recipe

object RecipeData {
    val defaultRecipe = getRecipeData()[0]

    fun getRecipeData(): List<Recipe> {
        return listOf(
            Recipe(
                1,
                R.string.placeholdercookie,
                R.string.sdesc_placeholdercookie,
                R.string.ldesc_placeholdercookie
            ),
            Recipe(
                2,
                R.string.placeholderpasta,
                R.string.sdesc_placeholderpasta,
                R.string.ldesc_placeholderpasta
            )
        )
    }
}