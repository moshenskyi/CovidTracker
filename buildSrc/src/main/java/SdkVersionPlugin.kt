import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class SdkVersionPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		target.configureSdk()
	}
}

private fun Project.configureSdk() = configure<BaseExtension> {
	val config = rootProject.extensions.getByType<WorkplacesExtension>()

	defaultConfig {
		minSdkVersion(config.minSdk.get())
		targetSdkVersion(config.targetSdk.get())
		compileSdkVersion(config.compileSdk.get())
	}
}
