package com.example.delivery.data.api

import com.example.delivery.data.models.meal.MealsResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query

interface MenuApi {

    @GET("search.php")
    suspend fun searchMeal(
        @Query("s") title: String,
    ): MealsResponse

}