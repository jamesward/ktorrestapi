plugins {
    kotlin("multiplatform")        version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
}

repositories {
    mavenCentral()
}

kotlin {
    linuxX64 {
        binaries {
            executable(listOf(DEBUG, RELEASE)) {
                entryPoint = "ktorrestapi.main"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-server-core:2.0.0")
                implementation("io.ktor:ktor-server-cio:2.0.0")
                implementation("io.ktor:ktor-server-content-negotiation:2.0.0")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.0")
            }
        }
    }
}
