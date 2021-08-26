plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        create("root-project") {
            id = "workplaces.root-project"
            implementationClass = "RootProjectPlugin"
        }
        create("sdk-versions") {
            id = "workplaces.sdk-versions"
            implementationClass = "SdkVersionPlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:4.2.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
}