plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "id.deval.mygames"
    compileSdk = 34

    defaultConfig {
        applicationId = "id.deval.mygames"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
    dynamicFeatures += setOf(":favorite")

}

configurations {
//    create("cleanedAnnotations")
//    implementation {
//        exclude(group = "org.jetbrains", module = "annotations")
//    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.dynamic.fragment)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.navigation.testing)

    implementation(libs.dagger.hilt)
//    implementation(libs.dagger.hilt.gradle)
    kapt(libs.dagger.hilt.annotation)
//    kapt(libs.dagger.hilt.kapt)
    kapt(libs.hilt.compiler)

    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.common)

    implementation(libs.glide)
    kapt(libs.glide.compiler)

    implementation(libs.androidx.material3)
    implementation(project(":core"))

    //MOCK JUnit
    testImplementation(libs.junit)
    testImplementation(libs.androidx.test)
    testImplementation(libs.mockito)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mock.framework)
    testImplementation(libs.androidx.arch)
    testImplementation(libs.kotlin.coroutines.test)
}