package com.example.delivery.screen.menu

import com.example.delivery.domain.models.MenuTabs

data class MenuState(
    val tabs: List<MenuTabs>,
    val currentTab: MenuTabs
) {
    companion object {
        val InitState = MenuState(
            tabs = MenuTabs.values().toList(),
            currentTab = MenuTabs.Pizza
        )
    }
}