plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
    `android-kotlin-convention`
    id("workplaces.sdk-versions")
	id("kotlin-android")
}

android {

	buildFeatures {
		viewBinding = true
	}

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

    // LifeCycle
    implementation(Lifecycle.lifecycleCommon)
    implementation(Lifecycle.lifecycleExtensions)

    // Logging
    implementation(Other.timber)
	implementation(Other.lottie)

    // Firebase
    implementation(Firebase.firebaseBom)
    implementation(Firebase.firebaseCommon)

    implementation(project(":covid-data"))
    implementation(project(":auth"))
	implementation(project(":core-android"))
	implementation(project(":profile"))
}
