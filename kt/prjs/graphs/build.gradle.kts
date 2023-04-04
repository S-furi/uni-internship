plugins {
    kotlin("jvm") version "1.8.0"
    id("org.openjfx.javafxplugin") version "0.0.13"
    application
}

javafx {
    modules("javafx.controls", "javafx.fxml")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val slf4j_version = "1.7.32"

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.lets-plot:lets-plot-jfx:3.1.0")
    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:4.3.0")
    implementation("org.slf4j:slf4j-simple:$slf4j_version")  // Enable logging to console)
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