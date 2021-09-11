plugins {
    id("com.android.library")
    id("com.google.gms.google-services")
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
    implementation(Android.constraintLayout)
    implementation(Android.legacySupport)

    // Kotlin extensions
    implementation(KotlinKtx.coreKtx)
    implementation(KotlinKtx.fragmentKtx)
    implementation(KotlinKtx.livedataKtx)
    implementation(KotlinKtx.viewModelKtx)

    // Test
    testImplementation(Tests.jUnit)
    androidTestImplementation(Tests.jUnitExtensions)
    androidTestImplementation(Tests.espresso)

    // Firebase
    implementation(platform(Firebase.firebaseBom))
    implementation(Firebase.firebaseAuth)
    implementation(Firebase.googleAuthPlayService)

    implementation(Other.timber)
}
