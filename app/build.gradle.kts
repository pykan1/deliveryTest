plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.github.skeptick.libres")
}

libres {
    generatedClassName = "MainRes" // "Res" by default
    generateNamedArguments = true // false by default
    baseLocaleLanguageCode = "ru" // "en" by default
    camelCaseNamesForAppleFramework = false // false by default
}

android {
    namespace = "com.example.delivery"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.delivery"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    /**
     *Koin*/
    implementation("io.insert-koin:koin-android:3.5.0")
    implementation("io.insert-koin:koin-androidx-compose:3.5.0")
    implementation("cafe.adriel.voyager:voyager-koin:1.0.0-rc05")

    //Voyager
    implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-rc05")
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:1.0.0-rc05")
    implementation("cafe.adriel.voyager:voyager-tab-navigator:1.0.0-rc05")

    //material 3
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")


    //strings and image
    implementation("io.github.skeptick.libres:libres-compose:1.2.0")

    //Glide
    implementation("io.coil-kt:coil-compose:2.5.0")


}