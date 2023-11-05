package com.example.delivery.screen.pizza

import com.example.delivery.domain.models.MealUI

data class PizzaState(
    val pizza: List<MealUI>
) {
    companion object {
        val InitState = PizzaState(emptyList())
    }
}