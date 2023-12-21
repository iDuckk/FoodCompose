package com.example.foodcompose.ui.screens.menu

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.foodcompose.R
import com.example.foodcompose.ui.main.MainViewModel
import com.example.foodcompose.ui.screens.menu.list.CarouselItem
import com.example.foodcompose.ui.screens.menu.list.CategoryItem
import com.example.foodcompose.ui.screens.menu.list.FoodItem
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("MutableCollectionMutableState")
@Composable
fun Menu(viewModel: MainViewModel) {
    val listAds = listOf<Int>(R.drawable.ads, R.drawable.ads, R.drawable.ads)

    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(),
            content = {

                item {
                    LazyRow(
                        modifier = Modifier
                            .height(140.dp)
                            .fillMaxWidth(),
                        content = {
                            items(items = listAds, itemContent = {
                                CarouselItem(id = it)
                            })
                        })
                }

                stickyHeader {
                    LazyRow(
                        modifier = Modifier
                            .background(color = Color.White)
                            .wrapContentSize()
                            .padding(10.dp),
                        content = {
                            items(items = viewModel.categories.value!!, itemContent = { category ->
                                CategoryItem(
                                    category = category,
                                    isSelected = viewModel.isSelected,
                                    onClick = {
                                        viewModel.isSelected.value = it
                                        viewModel.getFoodListByCategory(it)
                                    })
                            })
                        })
                }

                item {
                    viewModel.foodList.collectAsState().value!!.forEach {
                        FoodItem(meal = it)
                    }
                }

            })
    }
}