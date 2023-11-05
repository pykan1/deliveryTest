package com.example.delivery.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

import com.example.delivery.data.repository.MenuRepositoryImpl
import com.example.delivery.domain.repository.MenuRepository
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    factoryOf(::MenuRepositoryImpl) { bind<MenuRepository>() }
}