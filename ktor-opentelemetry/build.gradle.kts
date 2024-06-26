val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val opentelemetry_version: String by project

plugins {
    kotlin("jvm") version "1.9.23"
    id("io.ktor.plugin") version "2.3.9"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.23"
    id("org.jetbrains.kotlinx.dataframe") version "0.12.1"
    id("com.avast.gradle.docker-compose") version "0.17.6"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("demos.goto.amsterdam.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:dataframe:0.12.1")

    implementation("io.ktor:ktor-client-core")
    implementation("io.ktor:ktor-client-cio")
    implementation("io.ktor:ktor-client-serialization")
    implementation("io.ktor:ktor-client-content-negotiation")
    implementation("io.ktor:ktor-client-encoding")

    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("io.opentelemetry:opentelemetry-sdk-extension-autoconfigure:$opentelemetry_version")
    implementation("io.opentelemetry:opentelemetry-exporter-otlp:$opentelemetry_version")
    implementation("io.opentelemetry.instrumentation:opentelemetry-ktor-2.0:$opentelemetry_version-alpha")

    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("io.ktor:ktor-client-mock")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

dockerCompose {
    setProjectName("kotlin-conf-opentelemetry")
    useComposeFiles.add("./docker/docker-compose.yml")
    forceRecreate = true
}

tasks.register("runWithDocker") {
    dependsOn("composeUp", "run")
}