package com.example.delivery.di

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpRedirect
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

val networkModule = module {
    factoryOf(::provideJson)
    factoryOf(::provideHttpClient)
    factory { provideKtorHttpClient(get(), BASE_URL) }
}

@OptIn(ExperimentalSerializationApi::class)
private fun provideJson(): Json {
    return Json {
        isLenient = true
        ignoreUnknownKeys = true
        explicitNulls = false
        encodeDefaults = true
        prettyPrint = true
    }
}

private fun provideKtorHttpClient(httpClient: HttpClient, baseUrl: String): Ktorfit {
    return ktorfit {
        baseUrl(baseUrl)
        httpClient(httpClient)
    }
}

private fun provideHttpClient(
    json: Json,
) = HttpClient {

    install(HttpRedirect) {
        checkHttpMethod = false
        allowHttpsDowngrade = false
    }

    defaultRequest {
        header("Content-Type", "application/json")
    }

    HttpResponseValidator {
        handleResponseExceptionWithRequest { cause, request ->
            println(cause)
            println(request)
        }
    }
}