import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

val localProperties = File(rootProject.rootDir, "local.properties")
val properties = Properties()
if (localProperties.exists()) {
    properties.load(localProperties.inputStream())
}

val apiKey: String = properties.getProperty("API_KEY") ?: ""

android {
    namespace = "id.deval.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "API_KEY", "\"d6f25f3aa6ef4c93bdc55630fccd96ce\"")
        }

        debug {
            buildConfigField("String", "API_KEY", "\"d6f25f3aa6ef4c93bdc55630fccd96ce\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)
    androidTestImplementation(libs.room.testing)

    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.logging)

    implementation(libs.coroutines)
    implementation(libs.coroutines.android)

    implementation(libs.glide)
    kapt(libs.glide.compiler)

    implementation(libs.gson)
    implementation(libs.dagger.hilt)
//    implementation(libs.dagger.hilt.gradle)
    kapt(libs.dagger.hilt.annotation)
//    kapt(libs.dagger.hilt.kapt)
    kapt(libs.hilt.compiler)

    //MOCK JUnit
    testImplementation(libs.junit)
    testImplementation(libs.androidx.test)
    testImplementation(libs.mockito)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mock.framework)
}