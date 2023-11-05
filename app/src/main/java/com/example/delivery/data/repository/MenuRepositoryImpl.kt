package com.example.delivery.data.repository

import com.example.delivery.data.api.MenuApi
import com.example.delivery.domain.models.MealUI
import com.example.delivery.domain.repository.MenuRepository
import com.example.delivery.platform.Either
import com.example.delivery.platform.Failure
import com.example.delivery.platform.apiCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuRepositoryImpl(
    private val menuApi: MenuApi
) : MenuRepository {
    override suspend fun searchMeal(title: String): Either<Failure, List<MealUI>> {
        return apiCall(
            call = {menuApi.searchMeal(title)},
            mapResponse = { response ->
                response.meals.map {
                    MealUI(
                        idMeal = it.idMeal.orEmpty(),
                        strMeal = it.strMeal.orEmpty(),
                        strCategory = it.strCategory.orEmpty(),
                        strMealThumb = it.strMealThumb.orEmpty(),
                        strYoutube = it.strYoutube.orEmpty(),
                        strSource = it.strSource.orEmpty(),
                        strImageSource = it.strImageSource
                    )
                }
            }
        )
    }


}