package com.example.foodcompose.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodcompose.ui.screens.basket.Basket
import com.example.foodcompose.ui.screens.menu.Menu
import com.example.foodcompose.ui.screens.profile.Profile

@Composable
fun Navigation(
    navController: NavHostController,
    innerPadding: PaddingValues,
    viewModel: MainViewModel
    ) {
    NavHost(
        navController = navController,
        startDestination = MainActivity.MENU,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(MainActivity.MENU) {
            Menu(viewModel = viewModel)
        }
        composable(MainActivity.PROFILE) {
            Profile()
        }
        composable(MainActivity.BASKET) {
            Basket()
        }
    }
}