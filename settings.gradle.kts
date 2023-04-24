pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Dokkatest"
include(":apps:app")
include(":libs:androidlib")
include(":libs:commonlib")
include(":corelibs:corelib")
include(":libs:commonlib2")
include(":libs:commonlib3")
