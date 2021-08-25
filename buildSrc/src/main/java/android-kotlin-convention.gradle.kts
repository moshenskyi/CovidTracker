
import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// android
android {

    defaultConfig {
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro")
    }

    buildTypes {
        getByName(BuildTypes.RELEASE) {
            minifyEnabled(true)
            isShrinkResources = true
        }

        getByName(BuildTypes.DEBUG) {
            minifyEnabled(false)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

fun Project.android(configure: BaseExtension.() -> Unit) {
    extensions.configure("android", configure)
}
