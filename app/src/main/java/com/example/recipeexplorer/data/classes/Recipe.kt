package com.example.recipeexplorer.data.classes

import androidx.annotation.StringRes

data class Recipe(
    val id: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val shortSummaryResourceId: Int, // Displayed on the list of recipes.
    @StringRes val longDescriptionResourceId: Int // Displayed on the recipe view.
    // In an actual app, I'd probably have a list of steps or something here.
    // But this is enough of a pain in the butt to do so I'm gonna stop it here.
    // The example also only has text.
    )