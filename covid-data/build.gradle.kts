plugins {
    id("com.android.library")
    kotlin("android")
    `android-kotlin-convention`
    id("workplaces.sdk-versions")
}

android {

	buildFeatures {
		viewBinding = true
	}

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

    // Kotlin extensions
    implementation(KotlinKtx.coreKtx)
    implementation(KotlinKtx.activityKtx)
    implementation(KotlinKtx.fragmentKtx)
    implementation(KotlinKtx.livedataKtx)
    implementation(KotlinKtx.lifecycleRuntimeKtx)

    // Lifecycle
    implementation(Lifecycle.lifecycleCommon)
    implementation(Lifecycle.lifecycleExtensions)

    // Chart
    implementation(Other.charts)
    implementation(Other.lottie)

    // Retrofit
    implementation(Retrofit.retrofit)
    implementation(Retrofit.retrofitConverter)
    implementation(Retrofit.gson)
    implementation(Retrofit.okhttpLoggingInterceptor)

    // Modules
    implementation(project(":core"))
    implementation(project(":core-android"))

    // Test
    testImplementation(Tests.jUnit)
    androidTestImplementation(Tests.jUnitExtensions)
    androidTestImplementation(Tests.espresso)
}
