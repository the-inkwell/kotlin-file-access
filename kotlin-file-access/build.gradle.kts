@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(additionals.plugins.kotlin.multiplatform)
    alias(additionals.plugins.android.library)
    alias(additionals.plugins.kotlin.serialization)
    id("publication")
    id("jvmCompat")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    androidTarget {
        publishLibraryVariants("release")
    }

    jvm()

    js(IR) {
        browser()
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(additionals.kotlinx.coroutines)
                api(libs.korio)
            }
        }
        val commonTest by getting {
            dependencies {
                api(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                dependsOn(commonMain)

                api(additionals.kotlinx.coroutines.android)

                implementation(libs.korio.android)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }

        val jvmMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.korio.jvm)
            }
        }

        val jsMain by getting {
            dependsOn(commonMain)
            dependencies {
                api(libs.korio.js)
            }
        }
    }
}

android {
    namespace = "eu.codlab.file.access"
}
