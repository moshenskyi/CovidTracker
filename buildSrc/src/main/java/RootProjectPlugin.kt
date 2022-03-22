import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create

class RootProjectPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		target.extensions.create<WorkplacesExtension>("workplaces")
	}
}

abstract class WorkplacesExtension {
	abstract val minSdk: Property<Int>
	abstract val targetSdk: Property<Int>
	abstract val compileSdk: Property<Int>

	init {
		minSdk.convention(21).finalizeValueOnRead()
		targetSdk.convention(30).finalizeValueOnRead()
		compileSdk.convention(targetSdk).finalizeValueOnRead()
	}
}
