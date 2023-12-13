package com.example.foodcompose.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navController: NavHostController,
    innerPadding: PaddingValues
    ) {
    NavHost(
        navController = navController,
        startDestination = MainActivity.MENU,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(MainActivity.MENU) {
            LazyColumn(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                content = {
                    item {
                        Text(text = MainActivity.MENU)
                    }
                })

        }
        composable(MainActivity.PROFILE) {
            Box (
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            ) {
                Text(text = MainActivity.PROFILE)
            }
        }
        composable(MainActivity.BASKET) {
            Box(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            ) {
                Text(text = MainActivity.BASKET)
            }
        }
    }
}