val ktor_version: String by project
val kotlin_version: String by project

plugins {
    kotlin("multiplatform") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
}

group = "io.ktor.samples"
version = "0.0.1"

repositories {
    mavenCentral()
}

kotlin {
    macosX64() {
    //macosArm64 {
        binaries {
            executable()
        }
    }

    sourceSets {
        macosMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

                implementation("io.ktor:ktor-server-core:$ktor_version")
                implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
                implementation("io.ktor:ktor-server-cio:$ktor_version")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
            }
        }
        macosTest {
            dependencies {
                implementation("io.ktor:ktor-server-tests:$ktor_version")
                implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
            }
        }
    }
}
