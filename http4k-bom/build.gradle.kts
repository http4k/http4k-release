import org.http4k.internal.ModuleLicense.Apache2

description = "Http4k Bill Of Materials (BOM)"

val license by project.extra { Apache2 }

plugins {
    id("org.http4k.module")
}

val http4kLocalHavenRepo = file("${System.getProperty("user.home")}/.m2/repository/org/http4k")

val bomModules = when {
    http4kLocalHavenRepo.exists() && http4kLocalHavenRepo.isDirectory ->
        http4kLocalHavenRepo.listFiles()
            ?.filter { it.isDirectory }
            ?.map { it.name }?.toList()
            ?: emptyList()

    else -> emptyList()
}

dependencies {
    constraints {
        bomModules
            .sorted()
            .forEach { api("org.http4k:$it:${rootProject.version}") }
    }
}

