plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://artifacts.unidata.ucar.edu/repository/unidata-all")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("edu.ucar:cdm-core:5.5.3")
    runtimeOnly("org.slf4j:slf4j-jdk14:2.0.7")
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