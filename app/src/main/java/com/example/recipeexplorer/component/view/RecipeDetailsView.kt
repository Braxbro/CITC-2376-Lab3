package com.example.recipeexplorer.component.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.recipeexplorer.data.classes.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsView(modifier: Modifier, recipe: Recipe, contentPadding: PaddingValues = PaddingValues(0.dp)) {
    Card(modifier = modifier.padding(paddingValues = contentPadding).padding(8.dp)) {
        Column() {
            TopAppBar(
                title = { Text(text = stringResource(recipe.nameResourceId)) }
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(recipe.longDescriptionResourceId)
            )
        }
    }
}