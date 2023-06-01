package plugins.multiplatform

import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.DokkaPlugin
import java.net.URL

plugins {
    kotlin("multiplatform")
}
apply<DokkaPlugin>()

val groupId: String by project
val artifactId: String by project
val productName = "Maps and Navigation SDK"

val externalDocUrls = listOf(
    "https://d.android.com/reference/",
)

configurations {
//    register("dokkaCommonMainImplementation").extendsFrom(configurations.commonMainImplementation)
//    getByName("dokkaCommonMainImplementation").isCanBeResolved = true
//
//    register("dokkaCommonMainApi").extendsFrom(configurations.commonMainApi)
//    getByName("dokkaCommonMainApi").isCanBeResolved = true
//
//    register("dokkaAndroidMainApi").extendsFrom(configurations.api)
//    getByName("dokkaAndroidMainApi").isCanBeResolved = true
//
//    register("dokkaAndroidMainImplementation").extendsFrom(configurations.implementation)
//    getByName("dokkaAndroidMainImplementation").isCanBeResolved = true

//    register("dokkaCompileClasspath").extendsFrom(configurations.compileClasspath)
//    getByName("dokkaCompileClasspath").isCanBeResolved = true
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTaskPartial>().configureEach {
    dokkaSourceSets {

        register("combined") {
            displayName.set("androidJvm")
            platform.set(org.jetbrains.dokka.Platform.jvm)
//            sourceRoots.from(kotlin.sourceSets.getByName("androidMain").kotlin.srcDirs)
//            sourceRoots.from(kotlin.sourceSets.getByName("commonMain").kotlin.srcDirs)

//            classpath.from(configurations.getByName("dokkaCommonMainImplementation"))
//            classpath.from(configurations.getByName("dokkaCommonMainApi"))
//            dependsOn("androidMain")

            jdkVersion.set(8)
            skipDeprecated.set(true)
            skipEmptyPackages.set(true)
            includeNonPublic.set(false)
            reportUndocumented.set(true)
        }
    }
}
