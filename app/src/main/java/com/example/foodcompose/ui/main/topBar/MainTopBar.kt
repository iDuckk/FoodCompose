package com.example.foodcompose.ui.main.topBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodcompose.R
import com.example.foodcompose.ui.theme.FoodComposeTheme

@Composable
fun MainTopBar() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        DropDownList(
            modifier = Modifier
            .height(60.dp)
            .width(180.dp)
        )
        Image(
            painter = painterResource(R.drawable.qr),
            contentDescription = "Qr code",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .height(24.dp)
                .width(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodComposeTheme {
        MainTopBar()
    }
}