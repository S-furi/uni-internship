plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.kotlin.link")
}

dependencies {
    testImplementation(kotlin("test"))
<<<<<<< HEAD:kt/prjs/dfExtensions/build.gradle.kts
    implementation("org.jetbrains.kotlinx:dataframe:0.9.1")
=======
    implementation("org.jetbrains.kotlinx:multik-core:0.2.1")
    implementation("org.jetbrains.kotlinx:multik-default:0.2.1")
    implementation("space.kscience:kmath-core:0.3.0")
    implementation("space.kscience:kmath-tensors:0.3.0")
    implementation("space.kscience:kmath-multik:0.3.0")
    implementation("space.kscience:kmath-stat:0.3.0")
>>>>>>> c57cd56 (Fixed depencencies):kt/prjs/broadcasting/build.gradle.kts
}


tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}