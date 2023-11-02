package com.example.delivery.screen.pizza

import com.example.delivery.domain.models.PizzaUI

data class PizzaState(
    val pizza: List<PizzaUI>
) {
    companion object {
        val InitState = PizzaState(emptyList())
    }
}