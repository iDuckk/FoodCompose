package com.example.foodcompose.ui.screens.menu.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CarouselItem(id: Int) {
    Box(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = id),
            contentDescription = "",
            modifier = Modifier
                .height(140.dp)
                .width(310.dp)
        )
    }
}