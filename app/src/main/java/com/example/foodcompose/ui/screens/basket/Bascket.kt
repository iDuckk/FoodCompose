package com.example.foodcompose.ui.screens.basket

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodcompose.ui.main.MainActivity

@Composable
fun Basket() {
    Box(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
    ) {
        Text(text = MainActivity.BASKET)
    }
}