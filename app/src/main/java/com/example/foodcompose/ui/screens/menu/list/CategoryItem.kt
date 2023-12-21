package com.example.foodcompose.ui.screens.menu.list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.ui.theme.Gray1
import com.example.foodcompose.ui.theme.Pink1
import com.example.foodcompose.ui.theme.Pink2
import kotlinx.coroutines.flow.MutableStateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CategoryItem(
    category: Category,
    isSelected: MutableStateFlow<String>,
    onClick: (String) -> Unit) {
    Card(
        elevation =  CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .height(32.dp)
            .width(110.dp)
            .padding(start = 10.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                .background(
                    color = if (isSelected.collectAsState().value == category.strCategory) Pink2 else Color.White,
                    shape = RectangleShape
                )
                .clickable(
                    onClick = {
                        onClick.invoke(category.strCategory)
                    })
            ) {
            Text(
                text = category.strCategory,
                fontSize = 13.sp,
                color = if (isSelected.collectAsState().value == category.strCategory) Pink1 else Gray1,
                modifier = Modifier
                    .wrapContentSize(),
                textAlign = TextAlign.Center,
            )
        }
    }

}