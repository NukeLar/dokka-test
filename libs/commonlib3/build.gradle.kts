plugins {
    id("kotlin-multiplatform")
    id("com.android.library")
    id("org.jetbrains.dokka")
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    namespace = "com.nuniwa.commonlib"
}

kotlin {

    android()
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":corelibs:corelib"))
            }
        }
    }
}

apply<org.jetbrains.dokka.gradle.DokkaPlugin>()

val externalDocUrls = listOf(
    "https://d.android.com/reference/",
)

tasks.withType<org.jetbrains.dokka.gradle.DokkaTaskPartial>().configureEach {
    dokkaSourceSets {
        register("combined") {
            displayName.set("androidJvm")
            platform.set(org.jetbrains.dokka.Platform.jvm)
            sourceRoots.from(kotlin.sourceSets.getByName("androidMain").kotlin.srcDirs)
            sourceRoots.from(kotlin.sourceSets.getByName("commonMain").kotlin.srcDirs)
//            dependsOn("commonMain")
//            dependsOn("androidMain")
//            dependsOn("jvmMain")
        }
        configureEach {
            println("sourceSetName = $name")
//            if (name.contains("jvm") || name.contains("android") || name.contains("common")) {
//                documentedVisibilities.set(setOf())
//            }
            jdkVersion.set(9)
            skipDeprecated.set(true)
            skipEmptyPackages.set(true)
            includeNonPublic.set(false)
            reportUndocumented.set(true)
        }
    }
}
