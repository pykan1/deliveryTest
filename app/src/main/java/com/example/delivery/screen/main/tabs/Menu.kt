package com.example.delivery.screen.main.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.delivery.R
import com.example.delivery.screen.menu.MenuScreen
import io.github.skeptick.libres.compose.painterResource

object Menu: Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1.toUShort(),
            title = "Меню",
            icon = painterResource(image = R.drawable.menu)
        )

    @Composable
    override fun Content() {
        Navigator(MenuScreen())
    }

}