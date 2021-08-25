import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

// android
android {

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // kotlinOptions
    (this as ExtensionAware).configure<KotlinJvmOptions> {
        jvmTarget = "1.8"
    }
}

fun Project.android(configure: BaseExtension.() -> Unit) {
    extensions.configure("android", configure)
}
