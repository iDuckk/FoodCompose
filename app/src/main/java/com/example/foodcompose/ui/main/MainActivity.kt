package com.example.foodcompose.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold() {
    Scaffold(
        topBar = {
            MainTopBar()
        }
    )
    { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            content = {

        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodComposeTheme {
        Scaffold()
    }
}