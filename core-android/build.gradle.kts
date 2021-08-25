plugins {
    id("com.android.library")
    kotlin("android")
    `android-kotlin-convention`
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    // Android
    implementation(DefaultDependencies.kotlin)
    implementation(Android.appcompat)
    implementation(Android.material)

    // Extensions
    implementation(KotlinKtx.coreKtx)

    // Test
    testImplementation(Tests.jUnit)
    androidTestImplementation(Tests.jUnitExtensions)
    androidTestImplementation(Tests.espresso)
}