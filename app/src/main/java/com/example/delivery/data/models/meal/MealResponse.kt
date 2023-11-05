package com.example.delivery.data.models.meal

import kotlinx.serialization.Serializable


@Serializable
class MealResponse(
    val idMeal: String?,
    val strMeal: String?,
    val strDrinkAlternate: Any?,
    val strCategory: String?,
    val strArea: String?,
    val strInstructions: String?,
    val strMealThumb: String?,
    val strTags: Any?,
    val strYoutube: String?,
    val strSource: String?,
    val strImageSource: Any?,
    val strCreativeCommonsConfirmed: Any?,
    val dateModified: Any?,
)