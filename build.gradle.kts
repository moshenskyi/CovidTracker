import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

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
        classpath("org.jlleitschuh.gradle:ktlint-gradle:9.2.1")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("workplaces.root-project")
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    repositories {
        mavenCentral()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        version.set("0.42.1")
        android.set(true)

        outputToConsole.set(true)
        outputColorName.set("RED")

        ignoreFailures.set(true)

        reporters {
            reporter(ReporterType.CHECKSTYLE)
        }
    }

    tasks.register("runChecksForDanger") {
        group = "Reporting"
        dependsOn("ktlintCheck")
        dependsOn(":app:lint")
        dependsOn(":auth:lint")
        dependsOn(":core-android:lint")
        dependsOn(":covid-data:lint")

        val file = file("${project.rootDir}/build/reports/ktlint")
        if (!file.exists()) file.mkdirs()
        val lintFile = File("${project.rootDir}/build/reports/lint")
        if (!lintFile.exists()) lintFile.mkdirs()
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
