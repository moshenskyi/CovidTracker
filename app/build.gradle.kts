plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.moshenskyi.covidtracker"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
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