package com.example.delivery.screen.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delivery.domain.models.MenuTabs
import com.example.delivery.domain.repository.MenuRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject

class MenuViewModel() : ViewModel(), KoinComponent {
    val state = MutableStateFlow(MenuState.InitState)

    private val menuRepository: MenuRepository by inject()

    fun changeCurrentState(tab: MenuTabs) {
        viewModelScope.launch {
            state.update { state.value.copy(currentTab = tab) }
        }
    }

    fun loadData() {
        viewModelScope.launch{
            menuRepository.searchMeal("")
        }
    }
}