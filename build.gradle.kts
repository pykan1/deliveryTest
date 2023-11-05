// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("de.jensklingenberg.ktorfit") version "1.9.1"
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.10"
    id("com.google.devtools.ksp") version "1.9.20-1.0.14"
}

buildscript {
    dependencies {
        classpath("io.github.skeptick.libres:gradle-plugin:1.2.0")
    }
}
