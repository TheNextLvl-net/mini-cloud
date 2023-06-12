plugins {
    id("java")
    id("org.openapi.generator") version "6.6.0"
}

group = rootProject.group
version = rootProject.version

tasks.openApiGenerate {
    generatorName.set("go-server")
    inputSpec.set("$rootDir/api.yaml")
    outputDir.set("$buildDir/generated-server")
    apiPackage.set("minicloud.server.api")
    invokerPackage.set("minicloud.server.invoker")
    modelPackage.set("minicloud.server.model")
    skipValidateSpec.set(true)
    logToStderr.set(true)
    generateAliasAsModel.set(false)
    enablePostProcessFile.set(true)
    configOptions.set(mapOf(
            "outputAsLibrary" to "true",
            "sourceFolder" to "server"
    ))
}