plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
    `android-kotlin-convention`
    id("workplaces.sdk-versions")
}

android {

    defaultConfig {
        applicationId = "com.moshenskyi.covidtracker"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    // Android
    implementation(DefaultDependencies.kotlin)
    implementation(Android.appcompat)
    implementation(Android.material)
    implementation(Android.constraintLayout)

    // Kotlin Extensions
    implementation(KotlinKtx.coreKtx)
    implementation(KotlinKtx.fragmentKtx)
    implementation(KotlinKtx.activityKtx)
    implementation(KotlinKtx.livedataKtx)
    implementation(KotlinKtx.lifecycleRuntimeKtx)

    // Chart
    implementation(Other.charts)

    //LifeCycle
    implementation(Lifecycle.lifecycleCommon)
    implementation(Lifecycle.lifecycleExtensions)

    // Logging
    implementation(Other.timber)

    // Firebase
    implementation(Firebase.firebaseBom)
    implementation(Firebase.firebaseCommon)

    implementation(project(":covid-data"))
    implementation(project(":auth"))
}