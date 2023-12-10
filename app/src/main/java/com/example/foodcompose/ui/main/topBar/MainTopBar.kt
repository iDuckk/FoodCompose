package com.example.foodcompose.ui.main.topBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodcompose.ui.theme.FoodComposeTheme

@Composable
fun MainTopBar() {
    Box {
        DropDownList()
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodComposeTheme {
        MainTopBar()
    }
}