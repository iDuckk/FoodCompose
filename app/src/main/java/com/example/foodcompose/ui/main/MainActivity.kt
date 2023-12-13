package com.example.foodcompose.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.foodcompose.ui.main.navBottomBar.NavBottomBar
import com.example.foodcompose.ui.main.topBar.MainTopBar
import com.example.foodcompose.ui.theme.FoodComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel.getFoodListByCategory(category = "Seafood")
        setContent {
            FoodComposeTheme {
                Scaffold()
            }
        }
    }

    companion object {
        const val MENU = "Меню"
        const val PROFILE = "Профиль"
        const val BASKET = "Корзина"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            MainTopBar()
        },
        bottomBar = { NavBottomBar(navController = navController) }
    )
    { innerPadding ->
        Navigation(navController = navController, innerPadding = innerPadding)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodComposeTheme {
        Scaffold()
    }
}
