package com.example.delivery.data.models.meal

import kotlinx.serialization.Serializable


@Serializable
class MealsResponse (
    val meals: List<MealResponse>
)