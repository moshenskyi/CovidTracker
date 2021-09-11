plugins {
    id("com.android.library")
    kotlin("android")
    `android-kotlin-convention`
    id("workplaces.sdk-versions")
}

android {
    defaultConfig {
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
