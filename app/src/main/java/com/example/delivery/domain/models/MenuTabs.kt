package com.example.delivery.domain.models

enum class MenuTabs {
    Pizza,
    Combo,
    Desserts,
    Drinks
}

fun MenuTabs.getText(): String {
    return when(this) {
        MenuTabs.Pizza -> "Пицца"
        MenuTabs.Combo -> "Комбо"
        MenuTabs.Desserts -> "Десерты"
        MenuTabs.Drinks -> "Напитки"
    }
}