package com.example.delivery.screen.main.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.delivery.R
import com.example.delivery.screen.profile.ProfileScreen
import io.github.skeptick.libres.compose.painterResource

object Profile : Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2.toUShort(),
            title = "Профиль",
            icon = painterResource(image = R.drawable.bucket)
        )

    @Composable
    override fun Content() {
        Navigator(ProfileScreen())
    }
}