package com.example.delivery.screen.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delivery.domain.models.MenuTabs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {
    val state = MutableStateFlow(MenuState.InitState)

    fun changeCurrentState(tab: MenuTabs) {
        viewModelScope.launch {
            state.update { state.value.copy(currentTab = tab) }
        }
    }
}