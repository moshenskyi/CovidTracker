// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("com.google.gms:google-services:4.3.10")
        classpath("com.android.tools.lint:lint:30.0.2")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.17.1")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("workplaces.root-project")
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    repositories {
        mavenCentral()
    }

    configure<io.gitlab.arturbosch.detekt.extensions.DetektExtension> {
        buildUponDefaultConfig = true
        allRules = false
		config = files("$rootDir/config/detekt/detekt.yml")
        baseline = file("$rootDir/config/detekt/baseline.xml")

        reports {
            xml.enabled = true
        }
    }

    tasks.register("runChecksForDanger") {
        group = "Reporting"
        dependsOn("detekt")
        dependsOn(":app:lint")
        dependsOn(":auth:lint")
        dependsOn(":core-android:lint")
        dependsOn(":covid-data:lint")

        val file = file("${project.rootDir}/build/reports/ktlint")
        if (!file.exists()) file.mkdirs()
        val lintFile = File("${project.rootDir}/build/reports/lint")
        if (!lintFile.exists()) lintFile.mkdirs()
    }

	// Kotlin DSL
	tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
		// Target version of the generated JVM bytecode. It is used for type resolution.
		jvmTarget = "1.8"
	}
}

workplaces {
    minSdk.set(21)
    targetSdk.set(30)
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        jcenter() // Warning: this repository is going to shut down soon
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
