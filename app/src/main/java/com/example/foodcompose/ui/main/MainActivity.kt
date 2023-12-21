package com.example.foodcompose.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                Scaffold(viewModel = viewModel)
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
fun Scaffold(viewModel: MainViewModel) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.height(1000.dp),
        topBar = {
            MainTopBar()
        },
        bottomBar = { NavBottomBar(navController = navController) }
    )
    { innerPadding ->
        Navigation(navController = navController, innerPadding = innerPadding, viewModel = viewModel)
    }
}
