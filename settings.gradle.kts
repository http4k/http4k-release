rootProject.name = "http4k-release"

pluginManagement {
    repositories {
        mavenLocal {
            url = uri("$rootDir/gradle/repo")
        }
        gradlePluginPortal()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "org.http4k") {
                useModule("org.http4k:gradle-plugins:0.0.0.0")
            }
        }
    }
}

include(":http4k-bom")