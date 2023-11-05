package com.example.delivery.di

import com.example.delivery.screen.menu.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MenuViewModel)
}