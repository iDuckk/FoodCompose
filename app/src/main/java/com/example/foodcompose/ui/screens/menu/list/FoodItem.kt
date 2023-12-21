package com.example.foodcompose.ui.screens.menu.list

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.foodcompose.data.models.Meal
import com.example.foodcompose.ui.theme.Gray1
import com.example.foodcompose.ui.theme.Pink1

@Composable
fun FoodItem(
    meal: Meal,
) {
    Card(
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row {
            AsyncImage(
                model = meal.strMealThumb,
                contentDescription = meal.strMeal,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(145.dp)
                    .width(135.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = meal.strMeal,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth()
                )

                Text(
                    text = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                    fontSize = 14.sp,
                    letterSpacing = 0.4.sp,
                    color = Gray1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )

                Text(
                    text = "от ${(100..999).random()} р",
                    color = Pink1,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .border(width = 1.dp, Pink1, RoundedCornerShape(6.dp))
                        .padding(5.dp)
                        .align(Alignment.End)
                )

            }
        }
    }
}