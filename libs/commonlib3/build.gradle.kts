import org.jetbrains.dokka.Platform
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.dokka.gradle.DokkaTaskPartial

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

apply<DokkaPlugin>()

val externalDocUrls = listOf(
    "https://d.android.com/reference/",
)

tasks.withType<DokkaTaskPartial>().configureEach {
    dokkaSourceSets {
//        register("combined") {
//            displayName.set("androidJvm")
//            platform.set(Platform.jvm)
//            sourceRoots.from(kotlin.sourceSets.getByName("androidMain").kotlin.srcDirs)
//            sourceRoots.from(kotlin.sourceSets.getByName("commonMain").kotlin.srcDirs)
//        }
        configureEach {
//            println("sourceSetName = $name")
//            if (name.contains("jvm") || name.contains("android") || name.contains("common")) {
//                suppress.set(true)
//            }
            jdkVersion.set(8)
            skipDeprecated.set(true)
            skipEmptyPackages.set(true)
            includeNonPublic.set(false)
            reportUndocumented.set(true)
        }
    }
}
