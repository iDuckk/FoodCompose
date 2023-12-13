package com.example.foodcompose.ui.main.navBottomBar

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodcompose.R
import com.example.foodcompose.ui.main.MainActivity
import com.example.foodcompose.ui.theme.Gray1
import com.example.foodcompose.ui.theme.Gray_nav_bottom_bg
import com.example.foodcompose.ui.theme.Pink1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBottomBar(navController: NavHostController) {
    val items = listOf(
        BottomNavigationItem(
            title = MainActivity.MENU,
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_menu),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_menu),
            hasNews = false,
        ),
        BottomNavigationItem(
            title = MainActivity.PROFILE,
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_profile),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_profile),
            hasNews = false
        ),
        BottomNavigationItem(
            title = MainActivity.BASKET,
            selectedIcon = ImageVector.vectorResource(id = R.drawable.ic_basket),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.ic_basket),
            hasNews = false,
        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = Gray_nav_bottom_bg,
        modifier = Modifier.wrapContentSize()
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Pink1,
                    selectedTextColor = Pink1,
                    indicatorColor = Gray_nav_bottom_bg,
                    unselectedIconColor = Gray1,
                    unselectedTextColor = Gray1
                ),
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                     navController.navigate(item.title)
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp
                    )
                },
                alwaysShowLabel = true,
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    }
}