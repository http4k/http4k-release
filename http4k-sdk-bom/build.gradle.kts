description = "Http4k Bill Of Materials (BOM)"

dependencies {

    constraints{
        api("org.http4k:http4k-core:LOCAL")
    }
//        project(":http4k-bom").dependencyProject.dependencies
//            .filter { it.name != project.name }
//            .filter { hasAnArtifact(it) }
//            .sortedBy { it.name }
//            .forEach { api(it) }
}

fun hasAnArtifact(it: Project) =
    !it.name.contains("test-function") && !it.name.contains("integration-test")

