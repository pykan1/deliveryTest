package com.example.delivery.di

import com.example.delivery.data.api.MenuApi
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.create
import org.koin.dsl.module

val apiModule = module {
    factory { get<Ktorfit>().create<MenuApi>() }
}