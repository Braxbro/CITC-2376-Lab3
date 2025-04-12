package com.example.recipeexplorer.component.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.recipeexplorer.data.classes.Recipe

@Composable
fun RecipeListView(modifier: Modifier,
                   recipeList: List<Recipe>,
                   onItemClick: (Recipe) -> Unit,
                   contentPadding: PaddingValues = PaddingValues(0.dp)
                   )
{
    // this bit is basically fully reusable from lab 2
    LazyColumn(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = contentPadding
    ) {
        itemsIndexed(recipeList) { _, item ->
            RecipeItem(Modifier, item, onItemClick)
        }
    }
}

@Composable
fun RecipeItem(modifier: Modifier, recipe: Recipe, onClick: (Recipe) -> Unit) {
    Card(modifier = modifier.fillMaxWidth(), onClick = { onClick(recipe) }) {
        Column(modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
            Text(text = stringResource(recipe.nameResourceId),
                modifier = Modifier.padding(horizontal = 8.dp),
                fontWeight = FontWeight.Bold)
            Text(text = stringResource(recipe.shortSummaryResourceId),
                modifier = Modifier.padding(horizontal = 8.dp),
                fontWeight = FontWeight.Light)
        }
    }
}