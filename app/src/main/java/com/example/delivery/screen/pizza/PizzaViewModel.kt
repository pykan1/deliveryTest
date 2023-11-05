package com.example.delivery.screen.pizza

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delivery.domain.models.MealUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PizzaViewModel : ViewModel() {

    val state = MutableStateFlow(PizzaState.InitState)

    fun loadData() {
        viewModelScope.launch {
            state.update {
                state.value.copy(
                    pizza = listOf(
                        MealUI(
                            "fgdgfdg",
                            "gfdggd",
                            "https://s3-alpha-sig.figma.com/img/58a2/2596/99ea12a527793773d9d0f5b1f99ad832?Expires=1699833600&Signature=T-5EtO1052u~iMjaYCIOyGEStmaffgiyD-OgNBLcQTQJcY8Hf6MmF7~~2~pftxZ00-cffw7PARBNt3r5l~-Laciyq3QDxPJcWoq~Qt2YHNKCLrq0OhORgAzNSSOaMrZehigSkspDlRO9X9uRW9XJppgPH9hO2TZoh7-z~RbRBmL8BMAw90EUmP1~Kl7cI71aFIbEmPXb6TBWmBc69Zx9j5gT3QbmdqyFEETZqRKDq2oEylqKj8jlDVxJLdObeU1p~DSGCVS9IbF1uvEquOWdER-vPrEq9jXGwan35QnQgeoOe3eAsWcHZ1AwoRCrCUg~QCvps1PSZsh2agDrW6sMMA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
                            "100",
                            "",
                            "",
                            ""
                        )
                    )
                )
            }
        }
    }

}