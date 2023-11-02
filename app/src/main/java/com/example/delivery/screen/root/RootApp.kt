package com.example.delivery.screen.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.example.delivery.navigation.RootNavigator
import com.example.delivery.screen.MainActivity
import com.example.delivery.screen.main.MainScreen
import com.example.delivery.screen.menu.MenuScreen

@Composable
fun RootApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        BottomSheetNavigator(
            sheetShape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8)
        ) {
            Navigator(MainScreen()) {
                CompositionLocalProvider(RootNavigator provides it) {
                    CurrentScreen()
                }
            }
        }
    }
}