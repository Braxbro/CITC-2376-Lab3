package com.example.recipeexplorer.component.view

import androidx.lifecycle.ViewModel
import com.example.recipeexplorer.data.RecipeData
import com.example.recipeexplorer.data.classes.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        RecipeUiState(
            recipeList = RecipeData.getRecipeData(),
            currentRecipe = RecipeData.getRecipeData().getOrElse(0) {
                RecipeData.defaultRecipe
            }
        )
    )

    val uiState: StateFlow<RecipeUiState> = _uiState

    fun updateCurrentRecipe(recipe: Recipe) {
        _uiState.update {
            it.copy(currentRecipe = recipe)
        }
    }

    fun navToList() {
        _uiState.update {
            it.copy(isShowingList = true)
        }
    }

    fun navToDetail() {
        _uiState.update {
            it.copy(isShowingList = false)
        }
    }


}

data class RecipeUiState(
    val recipeList: List<Recipe> = emptyList(),
    val currentRecipe: Recipe = RecipeData.defaultRecipe,
    val isShowingList: Boolean = true
)