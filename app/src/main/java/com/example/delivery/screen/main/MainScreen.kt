package com.example.delivery.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.delivery.screen.main.tabs.Bucket
import com.example.delivery.screen.main.tabs.Menu
import com.example.delivery.screen.main.tabs.Profile
import com.example.delivery.screen.uiKit.DeliveryPageContainer

class MainScreen(private val tab: Tab = Menu) : Screen {
    @Composable
    override fun Content() {
        TabNavigator(tab = tab, disposeNestedNavigators = true) {
            DeliveryPageContainer(background = Color.White, content = {
                it.current.Content()
            },
                footer = {
                    Row(modifier = Modifier.background(Color(0xFF7B7B7B))) {
                        TabNavItem(Menu)
                        TabNavItem(Profile)
                        TabNavItem(Bucket)
                    }
                })
        }
    }
}
@Composable
private fun RowScope.TabNavItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val selected = tabNavigator.current == tab
    val color = if (selected) Color(0xFFFD3A69) else Color(0xFF7B7B7B)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .weight(1f)
            .clickable {
                tabNavigator.current = tab
            }) {

        tab.options.icon?.let {
            Image(
                painter = it,
                contentDescription = null,
                colorFilter = ColorFilter.tint(color),
                modifier = Modifier
                    .size(24.dp)

            )
        }

        Text(
            text = tab.options.title,
            modifier = Modifier,
            color = color,
        )

    }
}