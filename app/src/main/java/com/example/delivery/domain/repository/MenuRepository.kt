package com.example.delivery.domain.repository

import com.example.delivery.data.models.meal.MealsResponse
import com.example.delivery.domain.models.MealUI
import com.example.delivery.platform.Either
import com.example.delivery.platform.Failure

interface MenuRepository {
    suspend fun searchMeal(title: String): Either<Failure, List<MealUI>>
}