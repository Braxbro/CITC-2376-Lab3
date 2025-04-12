@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package com.example.recipeexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipeexplorer.component.view.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSize = calculateWindowSizeClass(this).widthSizeClass
            MainView(Modifier.fillMaxSize(), windowSize)
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
fun RecipeExplorerPhonePortrait() {
    MainView(Modifier.fillMaxSize(), WindowWidthSizeClass.Compact)
}

@Preview(showBackground = true, heightDp = 412, widthDp = 915)
@Composable
fun RecipeExplorerPhoneLandscape() {
    MainView(Modifier.fillMaxSize(), WindowWidthSizeClass.Medium)
}

@Preview(showBackground = true, widthDp = 800, heightDp = 1280)
@Composable
fun RecipeExplorerTabletPortrait() {
    MainView(Modifier.fillMaxSize(), WindowWidthSizeClass.Medium)
}

@Preview(showBackground = true, heightDp = 800, widthDp = 1280)
@Composable
fun RecipeExplorerTabletLandscape() {
    MainView(Modifier.fillMaxSize(), WindowWidthSizeClass.Expanded)
}