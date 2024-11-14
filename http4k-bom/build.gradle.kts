description = "Http4k Bill Of Materials (BOM)"

plugins {
    java
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
    bomModules
        .sorted()
        .forEach {
            println(it)
        }
}

