package com.example.recipeexplorer.component.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.recipeexplorer.data.RecipeData
import com.example.recipeexplorer.ui.theme.RecipeExplorerTheme

@Composable
fun MainView(modifier: Modifier, windowSize: WindowWidthSizeClass) {
    val viewModel: RecipeViewModel = RecipeViewModel()
    val uiState by viewModel.uiState.collectAsState()

    RecipeExplorerTheme {
        Scaffold(modifier = modifier) { innerPadding ->
            val padding = innerPadding // shut up the error
            if (windowSize == WindowWidthSizeClass.Compact) {
                BackHandler(!uiState.isShowingList) {
                    viewModel.navToList()

                }
                if (uiState.isShowingList) {
                    RecipeListView(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = innerPadding,
                        recipeList = uiState.recipeList,
                        onItemClick = {
                            viewModel.updateCurrentRecipe(it)
                            viewModel.navToDetail()
                        }
                    )
                }
                else {
                    RecipeDetailsView(
                        modifier = Modifier.fillMaxSize(),
                        recipe = uiState.currentRecipe,
                        contentPadding = innerPadding
                    )
                }
            }
            else // anything that isn't a Compact WindowWidthSizeClass is >600 dp width.
            {
                Row {
                    RecipeListView(
                        modifier = Modifier.width(300.dp).fillMaxHeight(),
                        contentPadding = innerPadding,
                        recipeList = uiState.recipeList,
                        onItemClick = {
                            viewModel.updateCurrentRecipe(it)
                            viewModel.navToDetail() // only shows detail once you select an option
                        }
                    )
                    if (!uiState.isShowingList) {
                        RecipeDetailsView(
                            modifier = Modifier.fillMaxSize(),
                            recipe = uiState.currentRecipe,
                            contentPadding = innerPadding
                        )
                    }
                }
            }
        }
    }
}